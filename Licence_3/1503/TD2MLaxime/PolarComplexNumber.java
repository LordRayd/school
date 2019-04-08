/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
import java.util.Observable;

public class PolarComplexNumber extends Observable implements ComplexNumber {

    double modulus;
    double argument;

    public PolarComplexNumber(double modulus, double argument) {
        this.modulus = modulus;
        this.argument = argument;
    }

    public double getReal() {
        return this.computeReal(this.getModulus(), this.getArgument());
    }

    public void setReal(double r) {
        double imag = this.getImaginary();
        this.setModulus(Math.sqrt(
                (Math.pow(r, 2))
                + (Math.pow(imag, 2))
        ));

        double arg;
        if (r >= 0) {
            arg = Math.asin(imag / this.getModulus());
        } else {
            arg = Math.PI - Math.asin(imag / this.getModulus());
        }
        this.setArgument(arg);
        setChanged();
        notifyObservers();
        clearChanged();
    }

    public double getImaginary() {
        return this.computeImaginary(this.getModulus(), this.getArgument());
    }

    public void setImaginary(double i) {
        double real = this.computeReal(this.getModulus(), this.getArgument());
        this.setModulus(Math.sqrt(
                (Math.pow(real, 2))
                + (Math.pow(i, 2))
        ));

        double arg;
        if (real >= 0) {
            arg = Math.asin(i / this.getModulus());
        } else {
            arg = Math.PI - Math.asin(i / this.getModulus());
        }
        this.setArgument(arg);
        setChanged();
        notifyObservers();
        clearChanged();
    }

    public double getModulus() {
        return this.modulus;
    }

    public void setModulus(double m) {
        this.modulus = m;
        setChanged();
        notifyObservers();
        clearChanged();
    }

    public double getArgument() {
        return this.argument;
    }

    public void setArgument(double a) {
        this.argument = a;
        setChanged();
        notifyObservers();
        clearChanged();
    }

    double computeReal(double m, double a) {
        return m * Math.cos(a);
    }

    double computeImaginary(double m, double a) {
        return m * Math.sin(a);
    }

    @Override
    public ComplexNumber add(ComplexNumber cn) {
        double real1 = this.getReal();
        double real2 = cn.getReal();

        double imag1 = this.getImaginary();
        double imag2 = cn.getImaginary();

        PolarComplexNumber ret = new PolarComplexNumber(0, 0);
        ret.setReal(real1 + real2);
        ret.setImaginary(imag1 + imag2);
        return ret;
    }

    @Override
    public ComplexNumber minus(ComplexNumber cn) {
        double real1 = this.getReal();
        double real2 = cn.getReal();

        double imag1 = this.getImaginary();
        double imag2 = cn.getImaginary();

        PolarComplexNumber ret = new PolarComplexNumber(0, 0);
        ret.setReal(real1 - real2);
        ret.setImaginary(imag1 - imag2);
        return ret;
    }
    
    
}
