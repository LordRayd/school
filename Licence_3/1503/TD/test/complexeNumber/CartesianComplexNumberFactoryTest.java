package complexeNumber;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author e1604902 Samuel LE BERRE -- SEPTEMBRE 2018
 */
public class CartesianComplexNumberFactoryTest {
    
    public CartesianComplexNumberFactoryTest(){
    }

    /**
     * Test of CartesianComplexeNumberFactory
     */
    @Test
    public void testCartesianComplexeNumberFactory(){
        System.out.println("CartesianComplexNumberFactory");
        
        CartesianComplexNumberFactory instance = null;
        assertNull("Instance non Null",instance);
        
        instance = new CartesianComplexNumberFactory();
        assertNotNull("Instance Null",instance);
    }

    /**
     * Test of createComplexNumberFromCartesian method, of class CartesianComplexNumberFactory.
     */
    @Test
    public void testCreateComplexNumberFromCartesian() {
        System.out.println("createComplexNumberFromCartesian");
        double real = 1.0;
        double imaginary = 4.0;
        CartesianComplexNumberFactory instance = new CartesianComplexNumberFactory();
        CartesianComplexNumber expResult = new CartesianComplexNumber(real, imaginary);
        CartesianComplexNumber result = instance.createComplexNumberFromCartesian(real, imaginary);
        assertTrue("From Cartesian getReal Correct", expResult.getReal() == result.getReal());
        assertTrue("From Cartesian getImaginary Correct", expResult.getImaginary() == result.getImaginary());
        assertTrue("From Cartesian getModulus Correct", expResult.getModulus() == result.getModulus());
        assertTrue("From Cartesian getArgument Correct", expResult.getArgument() == result.getArgument());
        
        expResult = new CartesianComplexNumber(4.0, 10.0);
        assertTrue("From Cartesian getReal Incorrect", expResult.getReal() != result.getReal());
        assertTrue("From Cartesian getImaginary Incorrect", expResult.getImaginary() != result.getImaginary());
        assertTrue("From Cartesian getModulus Incorrect", expResult.getModulus() != result.getModulus());
        assertTrue("From Cartesian getArgument Incorrect", expResult.getArgument() != result.getArgument());
        
    }

    /**
     * Test of createComplexNumberFromPolar method, of class CartesianComplexNumberFactory.
     */
    @Test
    public void testCreateComplexNumberFromPolar() {
        System.out.println("createComplexNumberFromPolar");
        double modulus = 1.0;
        double argument = 1.0;
        CartesianComplexNumberFactory instance = new CartesianComplexNumberFactory();
        CartesianComplexNumber result = instance.createComplexNumberFromPolar(modulus, argument);
        PolarComplexNumber polar = new PolarComplexNumber(modulus, argument);
        
        /*assertEquals(result.getReal(), polar.getReal(),0.0001);
        assertEquals(result.getImaginary(), polar.getImaginary(),0.0001);
        assertEquals(result.getModulus(), polar.getModulus(),0.0001);
        assertEquals(result.getArgument(), polar.getArgument(),0.0001);
        assertTrue(real== result.getReal());
        assertTrue("From Polar getImaginary Correct",imaginary == result.getImaginary());
        assertTrue("From Polar getModulus Correct",modulus == result.getModulus());
        assertTrue("From Polar getArgument Correct",argument == result.getArgument());*/
        
    }
    
}