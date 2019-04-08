package complexeNumber;
/**
 *
 * @author e1604902 Samuel LE BERRE -- SEPTEMBRE 2018
 * @version 1.0
 */
public class PolarComplexNumberFactory implements ComplexNumberAbstractFactory{

    /**
     * Permet la creation du nombre complexe polaire à l'aide d'un nombre compkexe cartesien
     * @param real Le reel du nombre polaire que l'on souhaite créer
     * @param imaginary L'imaginaire du nombre polaire que l'on souhaite créer
     * @return Le nouveau nombre complexe polaire
     */
    @Override
    public PolarComplexNumber createComplexNumberFromCartesian(double real, double imaginary) {
        CartesianComplexNumber cartesian = new CartesianComplexNumber(real, imaginary);
        PolarComplexNumber polar = new PolarComplexNumber(cartesian.getModulus(),cartesian.getArgument());
        return polar;
    }

    /**
     * Permet la creation du nombre complexe polaire à l'aide d'un nombre complexe polaire
     * @param modulus Le module du nombre polaire que l'on souhaite créer
     * @param argument L'argument du nombre polaire que l'on souhaite créer
     * @return Le nouveau nombre complexe polaire
     */
    @Override
    public PolarComplexNumber createComplexNumberFromPolar(double modulus, double argument) {
        PolarComplexNumber polar = new PolarComplexNumber();
        polar.setModulus(modulus);
        polar.setArgument(argument);
        return polar;
    }
    
}
