/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import generators.IGenerator;

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
    
    public CHI2Test(int classesCount, IGenerator g)
    {
        k = classesCount;
        classSaturation = new int[k];
        this.g = g;
        range = (double) g.getRange() / (double) k;
    }
    
    @Override
    public double Test(int n)
    {
        for (int i = 0; i < k; i++)
            classSaturation[i] = 0;
        for (int i = 0 ; i < n; i++)
        {
            int val = g.Next();
            for (int j = 0; j < k; j++)
            {
                if (val >= (double) j*range && val < (double) (j+1)*range )
                {
                    classSaturation[j]++;
                }
            }
        }
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
    
}
