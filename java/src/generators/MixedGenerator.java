/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import java.math.BigInteger;

/**
 *
 * @author DanielWegner
 */
public class MixedGenerator implements IGenerator
{
    private int m = 1<<24;
    private IGenerator a;
    private IGenerator b;
    //private BigInteger sum;
    
    public MixedGenerator(IGenerator a, IGenerator b)
    {
        this.a = a;
        this.b = b;
        m = (m < 0) ? m * (-1) : m;
        //sum = new BigInteger("0");
    }
    
    @Override
    public int Next()
    {
        //sum.add(new BigInteger(String.valueOf((a.Next() + b.Next()) % m)));
        return (a.Next() + b.Next()) % m;
    }

    @Override
    public int getRange()
    {
        return m;
    }
    
//    public BigInteger getSum() {
//       // return sum;
//    }
}
