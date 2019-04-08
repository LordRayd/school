/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
public class ComplexNumberFactory {
    CartesianComplexNumber createComplexNumberFromCartesian(double real, double imaginary){
        CartesianComplexNumber ret = new CartesianComplexNumber(real, imaginary);
        return ret;
    }
    
    PolarComplexNumber createComplexNumberFromPolar(double modulus, double argument){
        PolarComplexNumber ret = new PolarComplexNumber(modulus, argument);
        return ret;
    }
}
