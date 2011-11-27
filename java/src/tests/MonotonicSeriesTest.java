/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import generators.IGenerator;

/**
 *
 * @author Dans
 */
public class MonotonicSeriesTest implements IGenerator
{
    private int range;
    private final int classesCnt;
    private final int t = 6;
    private IGenerator generator;
    private final double[] pi = {0.5, 0.333333333, 0.125, 0.033333333, 0.006944444, 0.001388889 };

    public double[] getPi()
    {
        return pi;
    }

    public int getClassesCnt()
    {
        return classesCnt;
    }
    
    
    public MonotonicSeriesTest(IGenerator generator)
    {
        this.generator = generator;
        this.classesCnt = pi.length;
        this.range = t + 1;
    }
    @Override
    public int Next()
    {
        int seriesLen = 1;
        int prevVal = generator.Next();
        int val;
        while ((val = generator.Next()) >= prevVal)
        {
            prevVal = val;
            seriesLen++;
        }
        if (seriesLen > 5)
            return 6;
        return seriesLen;
    }

    @Override
    public int getRange()
    {
        return this.range;
    }
    
}
