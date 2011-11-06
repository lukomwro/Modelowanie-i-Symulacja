/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generatory_testy;

import generators.IGenerator;
import generators.InversiveGenerator;


public class Generatory_testy 
{

    public static void main(String[] args) 
    {
        int n = 100;
        IGenerator generator = new InversiveGenerator();
        for (int i = 0; i < n; i++)
           System.out.println(generator.Next());
        //ITest t = new CHI2Test(10, new InversiveGenerator());
        //double result = t.Test(100);
        //System.out.println(result);
    }
}
