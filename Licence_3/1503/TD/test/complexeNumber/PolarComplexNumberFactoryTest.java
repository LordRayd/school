/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexeNumber;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author e1604902
 */
public class PolarComplexNumberFactoryTest {
    
    /**
     * Test of createComplexNumberFromCartesian method, of class PolarComplexNumberFactory.
     */
    @Test
    public void testCreateComplexNumberFromCartesian() {
        System.out.println("createComplexNumberFromCartesian");
        double real = 1.0;
        double imaginary = 4.0;
        PolarComplexNumberFactory instance = new PolarComplexNumberFactory();
        PolarComplexNumber result = instance.createComplexNumberFromCartesian(real, imaginary);
        
        /*CartesianComplexNumber expResult = new CartesianComplexNumber(1.0, 4.0);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertTrue("From Cartesian getReal Correct", expResult.getReal() == result.getReal());
        assertTrue("From Cartesian getImaginary Correct", expResult.getImaginary() == result.getImaginary());
        assertTrue("From Cartesian getModulus Correct", expResult.getModulus() == result.getModulus());
        assertTrue("From Cartesian getArgument Correct", expResult.getArgument() == result.getArgument());
        
        expResult = new CartesianComplexNumber(3.0, 0.1);
        assertTrue("From Cartesian getReal Incorrect", expResult.getReal() != result.getReal());
        assertTrue("From Cartesian getImaginary Incorrect", expResult.getImaginary() != result.getImaginary());
        assertTrue("From Cartesian getModulus Incorrect", expResult.getModulus() != result.getModulus());
        assertTrue("From Cartesian getArgument Incorrect", expResult.getArgument() != result.getArgument());*/
    }

    /**
     * Test of createComplexNumberFromPolar method, of class PolarComplexNumberFactory.
     */
    @Test
    public void testCreateComplexNumberFromPolar() {
        System.out.println("createComplexNumberFromPolar");
        double modulus = 4.0;
        double argument = 1.0;
        PolarComplexNumberFactory instance = new PolarComplexNumberFactory();
        PolarComplexNumber result = instance.createComplexNumberFromPolar(modulus, argument);
        
        PolarComplexNumber expResult = new PolarComplexNumber(4,1);
        assertTrue("From Polar getReal Correct", expResult.getReal() == result.getReal());
        assertTrue("From Polar getImaginary Correct", expResult.getImaginary() == result.getImaginary());
        assertTrue("From Polar getModulus Correct", expResult.getModulus() == result.getModulus());
        assertTrue("From Polar getArgument Correct", expResult.getArgument() == result.getArgument());
        
        expResult = new PolarComplexNumber(3.0, 0.1);
        assertTrue("From Polar getReal Incorrect", expResult.getReal() != result.getReal());
        assertTrue("From Polar getImaginary Incorrect", expResult.getImaginary() != result.getImaginary());
        assertTrue("From Polar getModulus Incorrect", expResult.getModulus() != result.getModulus());
        assertTrue("From Polar getArgument Incorrect", expResult.getArgument() != result.getArgument());
    }
    
}