package complexeNumber;

/**
 * Factory de nombre complexe cartesien qui permet leur creation avec les 2 types de nombres complexes connus.
 * Implemente l'interface ComplexNumberAbstractFactory
 * @author e1604902 Samuel LE BERRE -- SEPTEMBRE 2018
 * @version 1.0
 */
public class CartesianComplexNumberFactory implements ComplexNumberAbstractFactory{

    /**
     * Permet la creation du nombre complexe cartesien à l'aide d'un autre cartesien
     * @param real Le reel du nombre cartesien que l'on souhaite créer
     * @param imaginary L'imaginaire du nombre cartesien que l'on souhaite créer
     * @return Le nouveau nombre complexe cartesien
     */
    @Override
    public CartesianComplexNumber createComplexNumberFromCartesian(double real, double imaginary) {
        CartesianComplexNumber cartesian = new CartesianComplexNumber();
        cartesian.setReal(real);
        cartesian.setImaginary(imaginary);
        return cartesian;
    }

    /**
     * Permet la creation du nombre complexe cartesien à l'aide d'un nombre complexe polaire
     * @param modulus Le module du nombre cartesien que l'on souhaite créer
     * @param argument L'argument du nombre cartesien que l'on souhaite créer
     * @return Le nouveau nombre complexe cartesien
     */
    @Override
    public CartesianComplexNumber createComplexNumberFromPolar(double modulus, double argument) {
        PolarComplexNumber polar = new PolarComplexNumber(modulus, argument);
        CartesianComplexNumber cartesian = new CartesianComplexNumber(polar.getReal(), polar.getImaginary());
        return cartesian;
    }   
}