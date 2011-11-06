/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

/**
 *
 * @author DanielWegner
 */
public class MixedGenerator implements IGenerator
{
    private int m = (1 << 24) - 1;
    private IGenerator a;
    private IGenerator b;
    
    public MixedGenerator(IGenerator a, IGenerator b)
    {
        this.a = a;
        this.b = b;
        m = (m < 0) ? m * (-1) : m;
    }
    
    @Override
    public int Next()
    {
        return (a.Next() + b.Next()) % m;
    }

    @Override
    public int getRange()
    {
        return m;
    }
    
    
}
