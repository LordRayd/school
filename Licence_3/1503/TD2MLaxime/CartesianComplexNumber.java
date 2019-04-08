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

public class CartesianComplexNumber extends Observable implements ComplexNumber  {
    double real;
    double imaginary;
    
    public CartesianComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    
       public double getReal(){
        return this.real;
    }
    
    public void setReal(double r){
        this.real=r;
        setChanged();
	notifyObservers();
        clearChanged();
    }
    
    
    public double getImaginary(){
        return this.imaginary;
    }
    
    public void setImaginary(double i){
        this.imaginary=i;
        setChanged();
	notifyObservers();
        clearChanged();
    }
    
    public double getModulus(){
     return computeModulus(this.getReal(), this.getImaginary());
    }
    
    public void setModulus(double m){
      double arg = this.getArgument();
      this.setReal(m*Math.cos(arg));
      this.setImaginary(m*Math.sin(arg));
      setChanged();
      notifyObservers();
      clearChanged();
    }
   
    public double getArgument(){
      return computeArgument(this.getImaginary(), this.getModulus());
    }
    
    public void setArgument(double a){
      double modulus = this.getModulus();
      this.setReal(modulus*Math.cos(a));
      this.setImaginary(modulus*Math.sin(a));
      setChanged();
      notifyObservers();
      clearChanged();
    }
    
    double computeArgument(double i, double m){
      double arg;
      if(this.real>=0){
          arg =Math.asin(i/m);
      }
      else{
          arg = Math.PI-(Math.asin(i/m));          
      }
      
      return arg;
    }
    
    double computeModulus(double r, double i){
      return Math.sqrt(
             (Math.pow(r,2))
                     +
             (Math.pow(i,2))
                );
    }
    
   
    @Override
    public ComplexNumber add(ComplexNumber cn){
        CartesianComplexNumber ret =  new CartesianComplexNumber(this.getReal()+cn.getReal(),this.getImaginary()+cn.getImaginary());
        return ret;
    } 
    
    @Override
    public ComplexNumber minus(ComplexNumber cn){
        CartesianComplexNumber ret =  new CartesianComplexNumber(this.getReal()-cn.getReal(),this.getImaginary()-cn.getImaginary());
        return ret;
    }
    
    
}
