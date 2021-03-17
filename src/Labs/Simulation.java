package Labs;

import java.util.Random;

public class Simulation
{
    Properties properties;
    final int N;
    final int NTASKS;

    Simulation()
    {
        properties = new Properties();
        N = properties.N;
        NTASKS = properties.NTASKS;
    }

    public void Start()
    {
        int tInSys = 0;

        // Создаём компьютеры.
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
            properties.clearValue();
            PC1.clearPC();
            PC2.clearPC();
            PC3.clearPC();

            for (int n = 0; n < NTASKS; n++) // Проход по всем задачам.
            {
                properties.tIntPrih = rand.nextInt(2) + 1;
                properties.tIntOb = rand.nextInt(8) + 1;
                properties.tPrih += properties.tIntPrih;
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
                    tInSys += algorithm(PC1);

                // Для второго ПК.
                else if (randPC == 2)
                    tInSys += algorithm(PC2);

                // Для третьего ПК.
                else if (randPC == 3)
                    tInSys += algorithm(PC3);
            }

            // Просчитываем вероятности
            PC1.probPC += (double)PC1.tProst / PC1.tOkObr;
            PC2.probPC += (double)PC2.tProst / PC2.tOkObr;
            PC3.probPC += (double)PC3.tProst / PC3.tOkObr;

            // Обнуляем значения countOfTasks для каждого ПК
            PC1.countOFTasks = 0;
            PC2.countOFTasks = 0;
            PC3.countOFTasks = 0;
        }

        System.out.println("Среднее время ожидания: " + properties.tWait / (N * NTASKS));
        System.out.println("Вероятность простоя 1 ПК: " + PC1.probPC / N + " %");
        System.out.println("Вероятность простоя 2 ПК: " + PC2.probPC / N + " %");
        System.out.println("Вероятность простоя 3 ПК: " + PC3.probPC / N + " %");
        System.out.println("Среднее время в системе: " + tInSys / (N * NTASKS));
    }

    public int algorithm(PC numPC)
    {
        if(properties.tPrih < numPC.tOkObr)
        {
            properties.tWait += numPC.tOkObr - properties.tPrih;
            numPC.tOkObr += properties.tIntOb;
        }
        else
        {
            numPC.tProst += properties.tPrih - numPC.tOkObr;
            numPC.tOkObr = properties.tPrih + properties.tIntOb;
        }
        return (numPC.tOkObr - properties.tPrih);
    }
}