package complexeNumber;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author e1604902
 */
public class CartesianComplexNumberTest {
    
    
    public CartesianComplexNumberTest() {
    }
       
    @Test
    public void testCartesianComplexNumber(){
        System.out.println("CartedianComplexNumber");
        
        CartesianComplexNumber cartesian  = null;
        assertNull(cartesian);
        
        cartesian = new CartesianComplexNumber();
        assertNotNull("Cartesian initie restant null",cartesian);
    }
    
    @Test
    public void testGetReal(){
        System.out.println("getReal");
        
        CartesianComplexNumber cartesian  = new CartesianComplexNumber(1, 2);
        assertEquals(cartesian.getReal(), 1, 0.001);
        
        cartesian  = new CartesianComplexNumber(2, 2);
        assertNotEquals(cartesian.getReal(), 1, 0.001);
    }
    
    @Test
    public void testSetReal(){
        System.out.println("setReal");
        
    }
    
    @Test
    public void testGetImaginary(){
        System.out.println("getImaginary");
        
        CartesianComplexNumber cartesian  = new CartesianComplexNumber(1, 2);
        assertEquals(cartesian.getImaginary(), 2, 0.001);
        
        cartesian  = new CartesianComplexNumber(1, 3);
        assertNotEquals(cartesian.getImaginary(), 2, 0.001);
    }
    
    @Test
    public void testSetImaginary(){
        System.out.println("setImaginary");
        double i = 2.0;
        CartesianComplexNumber instance = new CartesianComplexNumber(1,1);
        assertNotEquals(i, instance.getImaginary(),0.0001);
        instance.setImaginary(i);
        assertEquals(i, instance.getImaginary(),0.0001);
    }
    
    @Test
    public void testGetModulus(){
        System.out.println("getModulus");
        CartesianComplexNumber instance = new CartesianComplexNumber(2,1);
        double expResult = 2.0;
        instance.setModulus(expResult);
        double result = instance.getModulus();
        assertEquals(expResult, result, 0.0001);
    }
    
    @Test
    public void testSetModulus(){
        System.out.println("setModulus");
        double m = 3.0;
        CartesianComplexNumber instance = new CartesianComplexNumber(2,1);
        assertNotEquals(m,instance.getModulus(),0.001);
        instance.setModulus(m);
        assertEquals(m,instance.getModulus(),0.001);
        
    }
    
    @Test
    public void testGetArgument(){
        System.out.println("getArgument");
        CartesianComplexNumber instance = new CartesianComplexNumber(2.0,1.0);
        double expResult = 1.0;
        instance.setArgument(expResult);
        double result = instance.getArgument();
        
        assertEquals(expResult, result, 0.00001);
        expResult = 2.0;
        assertNotEquals(expResult, result, 0.00001);
    }
    
    @Test
    public void testSetArgument(){
        System.out.println("setArgument");
        CartesianComplexNumber instance = new CartesianComplexNumber(2.0,1.0);
        double expResult = 1.0;
        instance.setArgument(expResult);
        double result = instance.getArgument();
        
        assertEquals(expResult, result, 0.00001);
        expResult = 2.0;
        assertNotEquals(expResult, result, 0.00001);
    }
    
    @Test
    public void testAdd(){
        System.out.println("add");
        
        CartesianComplexNumber cart1 = new CartesianComplexNumber(2,3);
        CartesianComplexNumber cart2 = new CartesianComplexNumber(4,5);
        CartesianComplexNumber cart3 = (CartesianComplexNumber)cart1.add(cart2);
        
        
        assertEquals(cart3.getReal(), 6, 0.001);
        assertEquals(cart3.getImaginary(), 8, 0.001);
        
        cart1 = new CartesianComplexNumber(-2,5); 
        cart2 = new CartesianComplexNumber(1,-3);
        cart3 = (CartesianComplexNumber)cart1.add(cart2);
        
        assertEquals(cart3.getReal(), -1, 0.001);
        assertEquals(cart3.getImaginary(), 2, 0.001);
        
    }
    
    @Test
    public void testMinus(){
        System.out.println("minus");
        
        CartesianComplexNumber cart1 = new CartesianComplexNumber(-2,5);
        CartesianComplexNumber cart2 = new CartesianComplexNumber(1,-3);
        CartesianComplexNumber cart3 = (CartesianComplexNumber)cart1.minus(cart2);
        
        
        assertEquals(cart3.getReal(), -3, 0.001);
        assertEquals(cart3.getImaginary(), 8, 0.001);
    }
}
