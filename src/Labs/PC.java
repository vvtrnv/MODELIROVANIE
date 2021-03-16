package Labs;

public class PC
{
    float limiter;
    int countOFTasks = 0;

    public int tOkObr;
    public int tProst;
    public double probPC;

    public void clearPC()
    {
        tOkObr = 0;
        tProst = 0;
        countOFTasks = 0;
    }

    public double countProbability()
    {
        double result = (double)tProst / (double)tOkObr;
        return result;
    }
}
