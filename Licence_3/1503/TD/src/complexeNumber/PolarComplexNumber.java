package complexeNumber;

import java.util.Observable;
import java.util.UUID;

/**
 * La classe cree et gere les nombres complexe sous leurs formes polaire.
 * Sous-Classes d'Observable. Implemente la class ComplexNumber
 * @author e1604902 Samuel LE BERRE -- SEPTEMBRE 2018
 * @version 1.1
 */
public class PolarComplexNumber extends Observable implements ComplexNumber {

    /**
     * Le module du nombre complexe polaire
     */
    private double modulus;
    /**
     * L'argument du nobmre complexe polaire
     */
    private double argument;
    
    /**
     *
     */
    private UUID id;
    
    /**
     * Constructeur vide de la classe
     */
    public PolarComplexNumber(){
        super();
        id = UUID.randomUUID();
    }
    
    /**
     * Constructeur de la classe qui affecte le module et l'argument passé en paramètre
     * @param m Le module 
     * @param a L'argument
     */
    public PolarComplexNumber(double m, double a){
        this.modulus = m;
        this.argument = a;
        id = UUID.randomUUID();
    }
    
    /**
     * Methode qui retourne une description du nombre complexe sous sa forme polaire
     * Exemple : module x e(argument i)
     * @return La decription
     */
    @Override
    public String toString(){
        return new String(getModulus() + " x e("+getArgument() + " i)");
    }
    
    /**
     * Recupere le reel du nombre complexe
     * @return Le reel
     */
    @Override
    public double getReal() {
        return this.getModulus() * Math.sin(this.getArgument());
    }

    /**
     * Modifie la partie reel du nombre polaire, modifie donc le module et l'argument pour que
     * getReal renvoie le nouveau reel, et en notifie les observers.
     * @param r Le reel
     */
    @Override
    public void setReal(double r) {
        this.setModulus(Math.sqrt(r*r+this.getImaginary()*this.getImaginary()));
        if(r >= 0){
            this.setArgument(Math.asin(this.getImaginary()/this.getModulus()));
        }else{
            this.setArgument(Math.PI - Math.asin(this.getImaginary()/this.getModulus()));
        }
        setChanged();
        notifyObservers();
    }

    /**
     * Recupere l imaginaire du nombre complexxe
     * @return L imaginaire
     */
    @Override
    public double getImaginary() {
        return this.getModulus() * Math.cos(this.getArgument());
    }

    /**
     * Modifie le module et l'argument pour que getImaginary renvoie le nouvelle imaginaire 
     * et en notifie les observers.
     * @param i L'imaginaire
     */
    @Override
    public void setImaginary(double i) {
        double real = this.getModulus() * Math.cos(this.getArgument());
        this.setModulus(Math.sqrt((Math.pow(real, 2)) + (Math.pow(i, 2))));
        setChanged();
        notifyObservers();
    }

    /**
     * Recupere le modulus du nombre complexe
     * @return Le modulus
     */
    @Override
    public double getModulus() {
        return this.modulus;
    }

    /**
     * Attribut le module passe en paramètre au nombre complexe et en notify les observers
     * @param m Le module
     */
    @Override
    public void setModulus(double m) {
        this.modulus = m;
        setChanged();
        notifyObservers();
    }

    /**
     * Recupere l argument du nombre complexe
     * @return L argument
     */
    @Override
    public double getArgument() {
        return this.argument;
    }

    /**
     * Attribut l'argument passe en paramètre au nombre complexe et en notify les observers
     * @param a L'argument
     */
    @Override
    public void setArgument(double a) {
        this.argument = a;
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
        PolarComplexNumber ret= new PolarComplexNumber();
        
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
        PolarComplexNumber ret= new PolarComplexNumber();
        
        double r = this.getReal() - cN.getReal();
        double i = this.getImaginary() - cN.getImaginary();
        
        ret.setReal(r);
        ret.setImaginary(i);
        
        return ret;
      }
    
}