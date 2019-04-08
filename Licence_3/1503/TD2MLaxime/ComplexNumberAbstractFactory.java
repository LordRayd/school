/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
public interface ComplexNumberAbstractFactory {
        public ComplexNumber createComplexNumberFromCartesian(double real, double imaginary);
        public ComplexNumber createComplexNumberFromPolar(double modulus, double argument);
}
