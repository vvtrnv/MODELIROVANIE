package Labs;

public class Properties
{
    final int N = 100;
    final int NTASKS = 1000;

    public int tPrih;
    public int tOkObr1;
    public int tOkObr2;
    public int tOkObr3;
    public int tIntPrih;
    public int tIntOb;

    public int tOG[];
    public int tOgSum;

    public int tProst1;
    public int tProst2;
    public int tProst3;


    private void clearAr()
    {
        tOG= new int[NTASKS];
        for(int i =0; i < NTASKS;i++)
        {
            tOG[i] = 0;
        }
    }

    public void clearValue()
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