/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import generators.IGenerator;
import java.util.Arrays;

public class KolmogorovTest implements ITest
{

    /*
     * Nasze generatory mają rozkład równomierny.
     * Więc dystrubuanta F(n) = 1/m
     */
    private IGenerator g;
    private int period;
    private int[] elements;

    public int getPeriod()
    {
        return period;
    }
    
    public KolmogorovTest(IGenerator g)
    {
        this.g = g;
        period = 0;
    }
    
    public double Test(int n)
    {
        elements = new int[n];
        double maxplus = 0.0;
        double maxminus = 0.0;
        double[] Xtab = new double[n];
        int tmpGen;
        for (int i = 0; i < n; i++)
        {
            tmpGen =  g.Next();
            Xtab[i] = (double) tmpGen/g.getRange();
            Period(tmpGen, i);
        }
        if (period == 0)
            period = -1;
        Arrays.sort(Xtab);
        for (int i = 1; i <= n; i++)
        {
            double tmp;
            tmp = ((double)i/ (double)n) - Xtab[i - 1];
            
            if (tmp > maxplus || i == 1)
                maxplus = tmp;
            
            tmp = Xtab[i - 1] - ((double) i - 1.0)/(double)n;
            if (tmp > maxminus || i == 1)
                maxminus = tmp;
        }
        double Knplus = Math.sqrt((double)n)* maxplus;
        double Knminus = Math.sqrt((double)n)* maxminus;
        double Kn = Math.max(Knminus, Knplus);
        return Kn;
    }
    
    public void Period(int X, int cnt)
    {
        if (period != 0)
            return;
        for (int i = 0; i < cnt; i++)
        {
            if (X == elements[i])
            {
                this.period = cnt - i;
            }
        }
        elements[cnt] = X;
    }
    
}
