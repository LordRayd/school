package complexeNumber;
/**
 * Classe de création de nombre complexe cartesien et polaire
 * Implemente l'interface ComplexNumberAbstractFactory
 * @author e1604902 Samuel LE BERRE -- SEPTEMBRE 2018
 * @version 1.0
 */
public class ComplexNumberFactory implements ComplexNumberAbstractFactory{
    
    /**
     * Permet la creation du nombre complexe cartesien à l'aide d'un autre cartesien
     * @param real Le reel du nombre cartesien que l'on souhaite créer
     * @param imaginary L'imaginaire du nombre cartesien que l'on souhaite créer
     * @return Le nouveau nombre complexe cartesien
     */
    @Override
    public CartesianComplexNumber createComplexNumberFromCartesian(double real, double imaginary){
        CartesianComplexNumber cartesian = new CartesianComplexNumber();
        cartesian.setReal(real);
        cartesian.setImaginary(imaginary);
        return cartesian;
    }
    
    /**
     * Permet la creation du nombre complexe polaire à l'aide d'un nombre complexe polaire
     * @param modulus Le module du nombre polaire que l'on souhaite créer
     * @param argument L'argument du nombre polaire que l'on souhaite créer
     * @return Le nouveau nombre complexe polaire
     */
    @Override
    public PolarComplexNumber createComplexNumberFromPolar(double modulus, double argument){
        PolarComplexNumber polar = new PolarComplexNumber();
        polar.setModulus(modulus);
        polar.setArgument(argument);
        return polar;
    }
}
