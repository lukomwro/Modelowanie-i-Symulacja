/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author DanielWegner
 */
public class JavaRandom implements IGenerator
{
    private Random r;
    private int m = (1 << 24) - 1;
    
    public JavaRandom()
    {
        r = new Random(new Date().getTime());
    }
    
    @Override
    public int Next()
    {
        int val = r.nextInt();
        val = (val < 0) ? val * (-1) : val;
        return val % m;
    }

    @Override
    public int getRange()
    {
        return m;
    }
    
}
