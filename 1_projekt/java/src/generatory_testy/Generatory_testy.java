/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generatory_testy;

import generators.InversiveGenerator;
import generators.MixedGenerator;
import generators.SWBGenerator;
import tests.CHI2Test;
import tests.ITest;
import tests.KolmogorovTest;
import tests.MonotonicSeriesTest;
import tests.SumTest;


public class Generatory_testy 
{

    public static void main(String[] args) 
    {
        //IGenerator generator = new InversiveGenerator();
        //for (int i = 0; i < n; i++)
        //   System.out.println(generator.Next());
        //ITest t = new CHI2Test(10, new InversiveGenerator());
        //ITest t = new KolmogorovTest(new InversiveGenerator());
        //double result = t.Test(10000);
        //System.out.println("K-S Test: " + result);
        
        
        double result;
        //SumTest test = new SumTest(new MixedGenerator(new InversiveGenerator(), new SWBGenerator()));
        MonotonicSeriesTest test = new MonotonicSeriesTest(new InversiveGenerator());
        ITest t = new CHI2Test(test.getPi(), test);
        result = t.Test(10000);
        System.out.println("CHI2 Test: " + result);
        
    }
}
