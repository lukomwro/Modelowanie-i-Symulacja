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


public class Generatory_testy 
{

    public static void main(String[] args) 
    {
        int n = 1000;
        //IGenerator generator = new InversiveGenerator();
        //for (int i = 0; i < n; i++)
        //   System.out.println(generator.Next());
        //ITest t = new CHI2Test(10, new InversiveGenerator());
        //ITest t = new KolmogorovTest(new InversiveGenerator());
        //double result = t.Test(10000);
        //System.out.println("K-S Test: " + result);
        double result;
        ITest t = new KolmogorovTest(new SWBGenerator());
        result = t.Test(200000);
        System.out.println("CHI2 Test: " + result);
        
    }
}
