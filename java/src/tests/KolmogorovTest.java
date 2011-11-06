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
    public KolmogorovTest(IGenerator g)
    {
        this.g = g;
    }
    
    @Override
    public double Test(int n)
    {
        
        double maxplus = 0.0;
        double maxminus = 0.0;
        double[] Xtab = new double[n];
        for (int i = 0; i < n; i++)
        {
            Xtab[i] = (double)g.Next()/g.getRange();
        }
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
    
}
