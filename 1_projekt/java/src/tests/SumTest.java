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
public class SumTest implements IGenerator
{
    private int range;
    private double pi[] = { 0.02, 0.06, 0.1, 0.14, 0.18, 0.18, 0.14, 0.1, 0.06, 0.02 };
    //private double pi[] = {};
    private final int t = 2;
    private IGenerator generator;
    private int classesCnt;
    
    
    public SumTest(IGenerator generator)
    {
        this.generator = generator;
        this.range = t * generator.getRange();
        classesCnt = pi.length;
    }

    public int getClassesCnt()
    {
        return classesCnt;
    }
    
    @Override
    public int Next()
    {
        int sum = 0;
        for (int i = 0; i < t; i++)
        {
            sum += generator.Next();
        }
        return sum;
    }

    @Override
    public int getRange()
    {
        return range;
    }

    public double[] getPi()
    {
        return pi;
    }
    
}
