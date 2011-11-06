/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import java.util.Date;
import java.util.Random;


public class SWBGenerator implements IGenerator
{
    private final int R = 24;
    private final int S = 10;
    private int[] Xtab;
    private int c = 0;
    private int m = 1 << 24;
    private int n = 0; //obecna pozycja
    
    public SWBGenerator()
    {
        //przesuniecie jedynki moze spowodowac powstanie liczby ujemnej
        m = (m < 0)? m*(-1) : m;
        Random r = new Random(new Date().getTime());
        Xtab = new int[R];
        for (int i = 0; i < R; i++)
        {
            Xtab[i] = Math.abs(r.nextInt()) % m;
        }
        
    }
    
    @Override
    public int Next()
    {
        int index = n % R;
        n++;
        if (Xtab[(R + n - S) % R] >= Xtab[index] + c) 
        {
            Xtab[index] = Xtab[(R + n - S) % R] - Xtab[index] - c;
            c = 0;
        }
        else 
        {
            Xtab[index] = m - ((Xtab[index] + c) - Xtab[(R + n - S) % R]);
            c = 1;
        }
        return Xtab[index];

    }

    @Override
    public int getRange()
    {
        return m;
    }
    
}
