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
    private int[] elements;
    
    public KolmogorovTest(IGenerator g)
    {
        this.g = g;
    }
    
    public double Test(int n)
    {
        double[] results = new double[1000];
        for(int a=0;a<1000;a++) {
            elements = new int[n];
            double maxplus = 0.0;
            double maxminus = 0.0;
            double[] Xtab = new double[n];
            int tmpGen;
            for (int i = 0; i < n; i++)
            {
                tmpGen =  g.Next();
                Xtab[i] = (double) tmpGen/g.getRange();
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
            results[a] = Kn;
        }
        int suma = 0;
        for(int i=0; i < 1000; i++) {
            if(n==10) {
                if(results[i] < 1.1655) {
                    suma++; 
                }
            }else if(n==100) {
                if(results[i] < 1.2091) {
                    suma++; 
                }
            }else if(n==1000) {
                if(results[i] < 1.2188) {
                    suma++; 
                }
            }else if(n==10000) {
                if(results[i] < 1.2222) {
                    suma++; 
                }
            }else if(n==100000){
                if(results[i] < 1.2233) {
                    suma++; 
                }
            }
        }
        return ((double)((double)suma/1000))*100;
    }
    
}
