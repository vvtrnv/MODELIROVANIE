package Labs;

import java.util.Random;

public class Lab_1 {
    final static int N = 100;
    final static int NTASKS = 1000;

    static class Simulation
    {
        public static int tPrih;
        public static int tOkObr1;
        public static int tOkObr2;
        public static int tOkObr3;
        public static int tIntPrih;
        public static int tIntOb;

        public static int tOG[];
        public static int tOgSum;

        public static int tProst1;
        public static int tProst2;
        public static int tProst3;


        private static void clearAr()
        {
            tOG= new int[NTASKS];
            for(int i =0; i < NTASKS;i++)
                tOG[i] = 0;
        }

        public static void clearValue()
        {
            clearAr();
            tPrih = 0;
            tOkObr1 = 0;
            tOkObr2 = 0;
            tOkObr3 = 0;
            tIntPrih = 0;
            tIntOb = 0;
            tOgSum = 0;
        }
    }

    public static int algoryrhm(PC numPC, int n)
    {
        if(Simulation.tPrih < numPC.tOkObr)
        {
            if (n == 0)
                Simulation.tOG[n] = numPC.tOkObr - Simulation.tPrih;
            else
                Simulation.tOG[n] = Simulation.tOG[n - 1] + numPC.tOkObr - Simulation.tPrih;

            numPC.tOkObr += Simulation.tIntOb;
        }
        else
        {
            numPC.tProst += Simulation.tPrih - numPC.tOkObr;
            numPC.tOkObr = Simulation.tPrih + Simulation.tIntOb;
        }
        return numPC.tOkObr - Simulation.tPrih;
    }

    public static void main(String[] args)
    {
        int tInSys = 0;
        float tOgAll = 0;

        double probPC1 = 0;
        double probPC2 = 0;
        double probPC3 = 0;

        // Создаём компьбтеры.
        PC PC1 = new PC();
        PC PC2 = new PC();
        PC PC3 = new PC();

        PC1.limiter = (NTASKS / 100) * 40;
        PC2.limiter = (NTASKS / 100) * 30;
        PC3.limiter = (NTASKS / 100) * 30;

        Random rand = new Random();
        int randPC = 0;

        for(int i = 0; i < N; i++) // Проход N раз.
        {
            Simulation.clearValue();

            for (int n = 0; n < NTASKS; n++) // Проход по всем задачам.
            {
                Simulation.tIntPrih = rand.nextInt(2) + 1;
                Simulation.tIntOb = rand.nextInt(8) + 1;
                Simulation.tPrih += Simulation.tIntPrih;
                randPC = 0; // обнуляем выбор ПК

                // выбор ПК
                while(randPC == 0)
                {
                    randPC = rand.nextInt(3 ) + 1;
                    if(randPC == 1 && PC1.countOFTasks < PC1.limiter) // Проверяем условия для 1 ПК
                    {
                        PC1.countOFTasks++;
                        break;
                    }
                    else if(randPC == 2 && PC2.countOFTasks < PC2.limiter) // Проверяем условия для 2 ПК
                    {
                        PC2.countOFTasks++;
                        break;
                    }
                    else if (randPC == 3 && PC3.countOFTasks < PC3.limiter) // Проверяем условия для 3 ПК
                    {
                        PC3.countOFTasks++;
                        break;
                    }
                    else randPC = 0;
                }

                // Для первого ПК.
                if (randPC == 1)
                {
                    tInSys += algoryrhm(PC1,n);
//                    if(Simulation.tPrih < Simulation.tOkObr1)
//                    {
//                        if (n == 0)
//                            Simulation.tOG[n] = Simulation.tOkObr1 - Simulation.tPrih;
//                        else
//                            Simulation.tOG[n] = Simulation.tOG[n - 1] + Simulation.tOkObr1 - Simulation.tPrih;
//
//                        Simulation.tOkObr1 += Simulation.tIntOb;
//                    }
//                    else
//                    {
//                        Simulation.tProst1 += Simulation.tPrih - Simulation.tOkObr1;
//                        Simulation.tOkObr1 = Simulation.tPrih + Simulation.tIntOb;
//                    }
//                    tInSys += Simulation.tOkObr1 - Simulation.tPrih;
                }

                // Для второго ПК.
                else if (randPC == 2)
                {
                    tInSys += algoryrhm(PC2, n);
//                    if(Simulation.tPrih < Simulation.tOkObr2)
//                    {
//                        if (n == 0)
//                            Simulation.tOG[n] = Simulation.tOkObr2 - Simulation.tPrih;
//                        else
//                            Simulation.tOG[n] = Simulation.tOG[n - 1] + Simulation.tOkObr2 - Simulation.tPrih;
//
//                        Simulation.tOkObr2 += Simulation.tIntOb;
//                    }
//                    else
//                    {
//                        Simulation.tProst2 += Simulation.tPrih - Simulation.tOkObr2;
//                        Simulation.tOkObr2 = Simulation.tPrih + Simulation.tIntOb;
//                    }
//                    tInSys += Simulation.tOkObr2 - Simulation.tPrih;
                }

                // Для третьего ПК.
                else if (randPC == 3)
                {
                    tInSys += algoryrhm(PC3, n);
//                    if(Simulation.tPrih < Simulation.tOkObr3)
//                    {
//                        if (n == 0)
//                            Simulation.tOG[n] = Simulation.tOkObr3 - Simulation.tPrih;
//                        else
//                            Simulation.tOG[n] = Simulation.tOG[n - 1] + Simulation.tOkObr3 - Simulation.tPrih;
//
//                        Simulation.tOkObr3 += Simulation.tIntOb;
//                    }
//                    else
//                    {
//                        Simulation.tProst3 += Simulation.tPrih - Simulation.tOkObr3;
//                        Simulation.tOkObr3 = Simulation.tPrih + Simulation.tIntOb;
//                    }
//                    tInSys += Simulation.tOkObr3 - Simulation.tPrih;
                }
            }

            // Просчитываем время ожидания
            for(int j = 0; j < NTASKS; j++)
                Simulation.tOgSum += Simulation.tOG[j];
            tOgAll += Simulation.tOgSum;

            // Просчитываем вероятности
            //probPC1 += (double)PC1.tProst / (double)PC1.tOkObr;
            //probPC2 += (double)PC2.tProst / (double)PC2.tOkObr;
            //probPC3 += (double)PC3.tProst / (double)PC2.tOkObr;
            PC1.probPC += PC1.countProbability();
            PC2.probPC += PC2.countProbability();
            PC3.probPC += PC3.countProbability();

            // Обнуляем значения countOfTasks для каждого ПК
            PC1.countOFTasks = 0;
            PC2.countOFTasks = 0;
            PC3.countOFTasks = 0;
        }
        System.out.println("Среднее время ожидания: " + tOgAll / (N * NTASKS));
        System.out.println("Вероятность простоя 1 ПК: " + PC1.probPC / N + "%");
        System.out.println("Вероятность простоя 2 ПК: " + PC2.probPC / N + "%");
        System.out.println("Вероятность простоя 3 ПК: " + PC3.probPC / N + "%");
        System.out.println("Среднее время в системе: " + tInSys / (N * NTASKS));
    }
}



