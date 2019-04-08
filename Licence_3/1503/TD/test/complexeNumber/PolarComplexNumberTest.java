package complexeNumber;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author e1604902
 */
public class PolarComplexNumberTest {
    
    /**
     * Test of getReal method, of class PolarComplexNumber.
     */
    @Test
    public void testGetReal() {
        System.out.println("getReal");
        PolarComplexNumber instance = new PolarComplexNumber(0,0);
        double expResult = 0.0;
        double result = instance.getReal();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setReal method, of class PolarComplexNumber.
     */
    @Test
    public void testSetReal() {
        System.out.println("setReal");
        double r = 12.0;
        PolarComplexNumber instance = new PolarComplexNumber(0,0);
        assertNotEquals(r, instance.getReal(),0.0001);
        instance.setReal(r);
        assertEquals(r,instance.getReal(),0.0001);
    }

    /**
     * Test of getImaginary method, of class PolarComplexNumber.
     */
    @Test
    public void testGetImaginary() {
        System.out.println("getImaginary");
        PolarComplexNumber instance = new PolarComplexNumber(0,0);
        double expResult = 0.0;
        double result = instance.getImaginary();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setImaginary method, of class PolarComplexNumber.
     */
    @Test
    public void testSetImaginary() {
        System.out.println("setImaginary");
        double i = 2.0;
        PolarComplexNumber instance = new PolarComplexNumber(0,0);
        assertNotEquals(i, instance.getImaginary(),0.0001);
        instance.setImaginary(i);
        assertEquals(i, instance.getImaginary(),0.0001);
    }

    /**
     * Test of getModulus method, of class PolarComplexNumber.
     */
    @Test
    public void testGetModulus() {
        System.out.println("getModulus");
        PolarComplexNumber instance = new PolarComplexNumber(2,1);
        double expResult = 2.0;
        double result = instance.getModulus();
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of setModulus method, of class PolarComplexNumber.
     */
    @Test
    public void testSetModulus() {
        System.out.println("setModulus");
        double m = 3.0;
        PolarComplexNumber instance = new PolarComplexNumber(2,1);
        assertNotEquals(m,instance.getModulus(),0.001);
        instance.setModulus(m);
        assertEquals(m,instance.getModulus(),0.001);
        
    }

    /**
     * Test of getArgument method, of class PolarComplexNumber.
     */
    @Test
    public void testGetArgument() {
        System.out.println("getArgument");
        PolarComplexNumber instance = new PolarComplexNumber(2.0,1.0);
        double expResult = 1.0;
        double result = instance.getArgument();
        assertEquals(expResult, result, 0.00001);
        expResult = 2.0;
        assertNotEquals(expResult, result, 0.00001);
    }

    /**
     * Test of setArgument method, of class PolarComplexNumber.
     */
    @Test
    public void testSetArgument() {
        System.out.println("setArgument");
        double a = 0.6;
        PolarComplexNumber instance = new PolarComplexNumber(1,1);
        assertNotEquals(a, instance.getArgument(), 0.00001);
        instance.setArgument(a);
        assertEquals(a, instance.getArgument(), 0.00001);
        
    }

    /**
     * Test of add method, of class PolarComplexNumber.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        
        PolarComplexNumber pol1 = new PolarComplexNumber(0,0);
        pol1.setReal(2);
        pol1.setImaginary(3);
        
        PolarComplexNumber pol2 = new PolarComplexNumber(0,0);
        pol2.setReal(4);
        pol2.setImaginary(5);
        
        PolarComplexNumber pol3 = (PolarComplexNumber)pol1.add(pol2);
        
        
        assertEquals(6, pol3.getReal(), 0.001);
        assertEquals(8, pol3.getImaginary(), 0.001);
        
        pol1.setReal(-2);
        pol1.setImaginary(5);
        pol2.setReal(1);
        pol2.setImaginary(-3);
        pol3 = (PolarComplexNumber)pol1.add(pol2);
        
        assertEquals(-1, pol3.getReal(), 0.001);
        assertEquals(2, pol3.getImaginary(), 0.001);
    }

    /**
     * Test of minus method, of class PolarComplexNumber.
     */
    @Test
    public void testMinus() {
        System.out.println("minus");
       
        PolarComplexNumber pol1 = new PolarComplexNumber(-2, 5);
        pol1.setReal(-2);
        pol1.setImaginary(5);
        PolarComplexNumber pol2 = new PolarComplexNumber(1, -3);
        pol2.setReal(1);
        pol2.setImaginary(-3);
        PolarComplexNumber pol3 = (PolarComplexNumber)pol1.minus(pol2);
        
        
        assertEquals(-3, pol3.getReal(), 0.001);
        assertEquals(8, pol3.getImaginary(), 0.001);
    }
    
}
