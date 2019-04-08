package complexeNumber;

import java.util.Observer;
import java.util.UUID;

/**
 * L'interface des nombres complexes. Ils devront tous l'implémenter
 * @author e1604902 Samuel LE BERRE -- SEPTEMBRE 2018
 * @version 1.1
 */
public interface ComplexNumber{
    
    public double getReal();
    public void setReal(double r);
    public double getImaginary();
    public void setImaginary(double i);
    
    public double getModulus();
    public void setModulus(double r);
    public double getArgument();
    public void setArgument(double t);
    
    public ComplexNumber add(ComplexNumber cN);
    public ComplexNumber minus(ComplexNumber cN);
    
    public void addObserver(Observer o);
    public void deleteObserver(Observer o);
    public UUID getId();
}
