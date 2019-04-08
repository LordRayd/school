/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
public class Test {
    public static void main(String[] args) {

        CartesianComplexNumber ccn1 = new CartesianComplexNumber(5,10);
        System.out.println("r : "+ccn1.getReal()+" i : "+ccn1.getImaginary());
        
        ccn1.setModulus(2);
        System.out.println("r : "+ccn1.getReal()+" i : "+ccn1.getImaginary());
        
        System.out.println("modulus : "+ccn1.getModulus());
        
        CartesianComplexNumber instance = new CartesianComplexNumber(5,10);
        double expResult = 0.0;
        instance.setModulus(0);
        double result = instance.getModulus();
        System.out.println(result);
        
    }
}
