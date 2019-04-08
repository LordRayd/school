/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
public class CartesianComplexNumberFactory implements ComplexNumberAbstractFactory{
    public CartesianComplexNumber createComplexNumberFromCartesian(double real, double imaginary){
        return new CartesianComplexNumber(real, imaginary);
    }
    public CartesianComplexNumber createComplexNumberFromPolar(double modulus, double argument){
        CartesianComplexNumber cn = new CartesianComplexNumber(0,0);
        cn.setModulus(modulus);
        cn.setArgument(argument);
        return cn;
    }
    
}
