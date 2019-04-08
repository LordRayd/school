package complexeNumber;

/**
 * Interface de la factory de nombre complexe
 * @author e1604902 Samuel LE BERRE -- SEPTEMBRE 2018
 * @version 1.0
 */
public interface ComplexNumberAbstractFactory {
    /**
     * Permet la creation du nombre complexe à l'aide d'un nombre complexe cartesien
     * @param real Le reel du nombre complexe que l'on souhaite créer
     * @param imaginary L'imaginaire du nombre complexe que l'on souhaite créer
     * @return Le nouveau nombre complexe
     */
    ComplexNumber createComplexNumberFromCartesian(double real, double imaginary);
    /**
     * Permet la creation du nombre complexe à l'aide d'un nombre complexe polaire
     * @param modulus Le module du nombre complexe que l'on souhaite créer
     * @param argument L'argument du nombre complexe que l'on souhaite créer
     * @return Le nouveau nombre complexe complexe
     */
    ComplexNumber createComplexNumberFromPolar(double modulus, double argument);
}