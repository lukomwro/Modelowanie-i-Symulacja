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
    private double[] pi;
    
    public CHI2Test(int classesCount, IGenerator g)
    {
        k = classesCount;
        classSaturation = new int[k];
        this.g = g;
        range = (double) g.getRange() / (double) k;
        pi = new double[classesCount];
        for (int i = 0; i < classesCount; i++)
            pi[i] = 1.0/(double)k;
    }
    
    /**
     * To wymaga nieco wyjasnienia.
     * Tak dlugo jak wykonujemy CHI2 dla generatora o rozkladzie rownomiernym,
     * uzywamy pierwszego konstruktora i jest fajnie.
     * W przypadku testu dwupoziomowego lub sum dystrybuanta sie zmienia
     * i juz nie mamy takich samych prawdopodobienstw dla kazdego 'kubelka'.
     * Radze te prawdopodobienstwa przeliczyc recznie i zakodowac na twardo wywolujac funkcje.
     * Przyklad:
     * Zalozmy, se mamy dystrybuante F(x).
     * Zeby policzyc prawdopodobienstwo dla danego przedzialu [a,b] musimy policzyc Pr { a <= X <= b }
     * Pr( X <= b ) liczymy bezposrednio z dystrybuanty jako F(b);
     * Pr( X <= a) liczymy jako F(a).
     * Ostatecznie  Pr{ a <= X <= b } = F(b) - F(a) .
     * W ten sposób obliczylismy prawdopodobienstwo, ze wylosowany element wpadnie w przedzial (a,b]
     * 
     * @param classesCount - liczba klas [rowna dlugosci tablicy pi]
     * @param pi - prawdopopodobienstwa
     * @param g - generator
     */
    
    public CHI2Test(double[] pi, IGenerator g)
    {
        k = pi.length;
        classSaturation = new int[k];
        this.g = g;
        range = (double) g.getRange() / (double) k;
        this.pi = pi;
    }
    
    @Override
    public double Test(int n)
    {
        double[] results = new double[1000];
        for(int a=0;a<1000;a++) {
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
                        break;
                    }
                }
            }

            double V = 0;
            double sum = 0;
            for (int i = 0; i < k; i++)
            {
                double tmpval = (double)classSaturation[i] - (double)n * pi[i];
                tmpval *= tmpval;
                tmpval /= (double) n * pi[i];
                V += tmpval;
            }
            results[a] = V;
        }
        int suma = 0;
        for(int i=0; i < 1000; i++) {
            if(results[i] < 16.92) {
                suma++; 
            }
        }
        return ((double)((double)suma/1000))*100;
    }

    public double[] getPi()
    {
        return pi;
    }
}
