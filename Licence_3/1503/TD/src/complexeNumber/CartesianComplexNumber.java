package complexeNumber;

import java.util.Observable;
import java.util.UUID;

/**
 * La classe cree et gere les nombres complexe sous leurs formes cartesienne.
 * Sous-Classes d'Observable. Implemente la class ComplexNumber
 * @author e1604902 Samuel LE BERRE -- SEPTEMBRE 2018
 * @version 1.1
 */
public class CartesianComplexNumber extends Observable implements ComplexNumber{

    /**
     * Le reel du nombre complexe sous sa forme cartesienne
     */
    private double real;
    /**
     * L imaginaire du nombre complexe sous sa forme cartesienne
     */
    private double imaginary;
    
    /**
     *
     */
    private UUID id;
    
    /**
     * Constructeur vide de la classe
     */
    public CartesianComplexNumber() {
        super();
        id = UUID.randomUUID();
    }
    
    /**
     * Constructeur qui permet de creer un nombre complexe en lui donnant un reel et un imaginaire
     * @param r Le reel
     * @param i L imaginaire
     */
    public CartesianComplexNumber(double r,double i){
        super();
        this.real = r;
        this.imaginary = i;
        id = UUID.randomUUID();
    }
    
    /**
     * Methode qui retourne une description du nombre complexe sous sa forme cartesienne
     * Exemple : reel + imaginaire i
     * @return La decription
     */
    @Override
    public String toString(){
        return new String(getReal() + " + "+getImaginary() + " i");
    }
    
    /**
     * Recupere le reel du nombre complexe
     * @return La valeur que possede le reel
     */
    @Override
    public double getReal() {
        return this.real;
    }

    /**
     * Attribut le reel passe en paramètre au nombre complexe et en notify les observers
     * @param r Le reel à attribuer 
     */
    @Override
    public void setReal(double r) {
        this.real = r;
        setChanged();
        notifyObservers();
    }

    /**
     * Recupere l imaginaire du nombre complexxe
     * @return L imaginaire
     */
    @Override
    public double getImaginary() {
       return this.imaginary;
    }

    /**
     * Attribut l imaginaire passe en parametre au nombre complex et en notifie les observers
     * @param i L imaginaire
     */
    @Override
    public void setImaginary(double i) {
        this.imaginary = i;
        setChanged();
        notifyObservers();
    }

    /**
     * Recupere le modulus du nombre complexe
     * @return Le modulus
     */
    @Override
    public double getModulus() {
       double r = this.real * this.real;
       double i = this.imaginary * this.imaginary;
       return Math.sqrt(r + i);
    }

    /**
     * Attribut les valeurs du reel et de l'imaginaire pour que le modulus du 
     * nombre complexe soit egal a celui donne en parametre. Notifie au observers le changement
     * @param m Le modulus
     */
    @Override
    public void setModulus(double m) {
        double a = this.getArgument();
        double r = 0.0;
        double i = 0.0;
        if((Object)a != null){
            r = m * Math.cos(a);
            i = m * Math.sin(a);
        }else{
            r = m * Math.cos(0);
            i = m * Math.sin(0);
        }
        this.setReal(r);
        this.setImaginary(i);
        setChanged();
        notifyObservers();
    }

    /**
     * Recupere l argument du nombre complexe
     * @return L argument
     */
    @Override
    public double getArgument() {
       double argument = 0.0;
       if(this.real >= 0){
           argument = Math.asin((double)(this.imaginary/this.getModulus()));
       }else{
           argument = Math.PI - Math.asin((double)(this.imaginary/this.getModulus()));
       }
       return argument;
    }

    /**
     * Attribut les valeurs du reel et de l'imaginaire pour que l argument du 
     * nombre complexe soit egal a celui donne en parametre. Notifie les observers du changement.
     * @param a L argument
     */
    @Override
    public void setArgument(double a) {
        double r = 0.0;
        double i = 0.0;
        double m = this.getModulus();
        if((Object)m != null){
            r = m * Math.cos(a);
            i = m * Math.sin(a);
        }  
        this.setReal(r);
        this.setImaginary(i);
        setChanged();
        notifyObservers();
    }
    
    /**
     *
     * @return
     */
    @Override
    public UUID getId(){
        return this.id;
    }

    /**
     * Additionne le nombre complexe a un autre nombre complexe passe en parametre
     * et retourne le nouveau nombre complexe cree.
     * @param cN Le nombre complexe a additionner
     * @return Le nouveau nombre complexe
     */
    @Override
    public ComplexNumber add(ComplexNumber cN) {
        CartesianComplexNumber ret= new CartesianComplexNumber();
        
        double r = this.getReal() + cN.getReal();
        double i = this.getImaginary() + cN.getImaginary();
        
        ret.setReal(r);
        ret.setImaginary(i);
        
        return ret;
    }

    /**
     * Soustrait le nombre complexe a un autre nombre complexe passe en parametre
     * et retourne le nouveau nombre complexe cree.
     * @param cN Le nombre complexe a soustraire
     * @return Le nouveau nombre complexe
     */
    @Override
    public ComplexNumber minus(ComplexNumber cN) {
        CartesianComplexNumber ret= new CartesianComplexNumber();
        
        double r = this.getReal() - cN.getReal();
        double i = this.getImaginary() - cN.getImaginary();
        
        ret.setReal(r);
        ret.setImaginary(i);
        
        return ret;
    }
}