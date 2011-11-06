/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import java.util.Random;


public class InversiveGenerator implements IGenerator
{
    private int prevX;
    private final int a = 123;
    private final int c = 999;
    private int m = 1 << 24;
    
    public InversiveGenerator()
    {
        //przesuniecie jedynki moze spowodowac powstanie liczby ujemnej
        m = (m < 0)? m*(-1) : m;
        prevX = Math.abs(new Random().nextInt())%m;
    }
    
    
    private int invert(int nwd_a, int nwd_b)
    {
        int r, nwd, local_a, q, b;
        int x, x1, x2;
        int y,y1,y2;
        if (nwd_b > nwd_a) 
        {
            nwd = nwd_b;
            nwd_b = nwd_a;
            nwd_a = nwd;
        }
        local_a = nwd_a;
        b = nwd_b;

        q = local_a/b;
        r = local_a - q*b;
        nwd = b;
        x2 = 1;
        x1 = 0;
        y2 = 0;
        y1=1;
        x=1;
        y=y2 - (local_a-1)*y1;
        while (r!=0) 
        {
            local_a = b;
            b=r;
            x=x2-q*x1;
            x2=x1;
            x1=x;
            y=y2-q*y1;
            y2=y1;
            y1=y;
            nwd=r;
            q=local_a/b;
            r=local_a-q*b;
        }
        //y czasami wychodzi ujemny, nie wiem czy to nie oszustwo!
        return (y < 0) ? y*(-1) : y;
    }
    
    @Override
    public int Next()
    {
        if (prevX == m) {
            prevX = c;
        } 
        else if (prevX == 0) 
        {
            prevX = m;
        } 
        else 
        {
            prevX = (a*invert(prevX, m) + c) % m;
        }
        return prevX;
    }
    
    @Override
    public int getRange()
    {
        return m;
    }
}
