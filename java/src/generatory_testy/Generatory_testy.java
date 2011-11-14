/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generatory_testy;

import generators.IGenerator;
import generators.InversiveGenerator;
import generators.SWBGenerator;
import tests.CHI2Test;
import tests.ITest;
import tests.KolmogorovTest;


public class Generatory_testy 
{

    public static void main(String[] args) 
    {
        int n = 1000;
        //IGenerator generator = new InversiveGenerator();
        //for (int i = 0; i < n; i++)
        //   System.out.println(generator.Next());
        //ITest t = new CHI2Test(10, new InversiveGenerator());
        ITest t = new KolmogorovTest(new InversiveGenerator());
        double result = t.Test(10000);
        System.out.println("K-S Test: " + result);
        System.out.println("Period: " + t.getPeriod());
        
        t = new CHI2Test(10, new InversiveGenerator());
        result = t.Test(100);
        System.out.println("CHI2 Test: " + result);
        System.out.println("Period: " + t.getPeriod());
    }
}
