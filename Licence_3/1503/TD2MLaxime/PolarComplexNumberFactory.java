/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
public class PolarComplexNumberFactory implements ComplexNumberAbstractFactory {
    public PolarComplexNumber createComplexNumberFromCartesian(double real, double imaginary){
        PolarComplexNumber cn = new PolarComplexNumber(0,0);
        cn.setReal(real);
        cn.setImaginary(imaginary);
        return cn;
    }
    public PolarComplexNumber createComplexNumberFromPolar(double modulus, double argument){
        return new PolarComplexNumber(modulus, argument);
    }
    
}
