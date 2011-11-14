/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import generators.IGenerator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author DanielWegner
 */
public class CHI2Test implements ITest
{
    private IGenerator g;
    public int k;
    public int[] classSaturation;
    private double range;
    private int[] elements;
    private int period;

    public int getPeriod()
    {
        return period;
    }
    
    public CHI2Test(int classesCount, IGenerator g)
    {
        k = classesCount;
        classSaturation = new int[k];
        this.g = g;
        range = (double) g.getRange() / (double) k;
        period = 0;
    }
    
    @Override
    public double Test(int n)
    {
        elements = new int[n];
        for (int i = 0; i < k; i++)
            classSaturation[i] = 0;
        for (int i = 0 ; i < n; i++)
        {
            int val = g.Next();
            Period(val, i);
            for (int j = 0; j < k; j++)
            {
                if (val >= (double) j*range && val < (double) (j+1)*range )
                {
                    classSaturation[j]++;
                }
            }
        }
        if (period == 0)
            period = -1;
        double[] p = new double[k];
        double V = 0;
        double sum = 0;
        for (int i = 0; i < k; i++)
        {
            p[i] = 1.0/(double)k;
            double tmpval = (double)classSaturation[i] - (double)n * p[i];
            tmpval *= tmpval;
            tmpval /= (double) n * p[i];
            V += tmpval;
        }
        return V;
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
