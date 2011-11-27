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
public class TwoWayCHI2 implements IGenerator
{
    private final double[] pi = { 0.07800, 0.38990, 0.33510, 0.14200, 0.04220, 0.01020,
                                    0.00210, 0.00042, 0.00007, 0.00001};
    private final int range = 45;
    private final int classesCount = 10;
    private double[] results;
    private int position;

    
    /**
     * 
     * @param results - wyniki dzialania CHI2 dla testow generatorow
     */
    public TwoWayCHI2(double[] results)
    {
        this.results = results;
        this.position = 0;
    }

    @Override
    public int Next()
    {
        position %= results.length;
        return (int) results[position++];
    }

    public double[] getResults()
    {
        return results;
    }

    public void setResults(double[] results)
    {
        this.results = results;
    }

    @Override
    public int getRange()
    {
        return this.range;
    }

    public int getClassesCount()
    {
        return classesCount;
    }

    public double[] getPi()
    {
        return pi;
    }
}
