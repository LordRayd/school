
import java.util.Observer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
public interface ComplexNumber {
    
    public double getReal();
    public void setReal(double r);
    public double getImaginary();
    public void setImaginary(double i);
    
    public double getModulus();
    public void setModulus(double m);
    public double getArgument();
    public void setArgument(double a);
    
    public void addObserver(Observer o);
    public void deleteObserver(Observer o);
    public ComplexNumber add(ComplexNumber cn);
    public ComplexNumber minus(ComplexNumber cn);
}
