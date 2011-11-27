/*9
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import java.util.Date;
import java.util.Random;


public class InversiveGenerator implements IGenerator
{
    private int prevX;
//    private final int a = 255;
//    private final int c = 1;
//    private int m = 5717;
    private final int a = 843;
    private final int c = 11;
    private int m = 78139;
    
    public InversiveGenerator()
    {
        //przesuniecie jedynki moze spowodowac powstanie liczby ujemnej
        //m = (m < 0)? m*(-1) : m;
        
        prevX = Math.abs(new Random(new Date().getTime()).nextInt())%m;
    }
    
    
    private int invert(int nwd_a, int nwd_b)
    {
        int u = 1, x = 0, w = nwd_a, z = nwd_b;
        while(w!=0) {
            if(w<z) {
                int tmp_u = u;
                u = x;
                x = tmp_u;
                int tmp_w = w;
                w = z;
                z = tmp_w;
            }
            int q = (int) Math.floor((double)(w/z));
            u = u - q * x;
            w = w - q * z;
        }
        if(z!=1) {
            return 0;
        }
        if(x<0) {
            x = x + nwd_b;
        }
        return x;
        
    }
    
    @Override
    public int Next()
    {
        int temp = invert(prevX, m);
        if (temp == 0) 
        {
            prevX = c;
        } 
        else 
        {
            prevX = (a*temp + c) % m;
        }
        return prevX;
    }
    
    @Override
    public int getRange()
    {
        return m;
    }
}
