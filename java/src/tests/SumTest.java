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
    private final int range = 2;
    private double pi[];
    private final int classesCnt = 10;
    private final int t = 4;
    
    
    public SumTest(IGenerator generator)
    {
        
    }
    
    @Override
    public int Next()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getRange()
    {
        return range;
    }
    
}
