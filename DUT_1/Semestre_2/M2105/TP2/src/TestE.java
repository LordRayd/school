/**
* Classe test partie E TP2 IHM
* @author Tristan Furno - Samuel LeBerre
*/
import java.util.Scanner;
import java.io.*;
import java.lang.*;
public class TestE{
  public static void main(String[] args){
    Voiture voiture1 = new Voiture("Opel", "Meriva", 140);
    System.out.println(voiture1.toString());

    Parking parking1 = new Parking();
    System.out.println(parking1.toString());

    try{
      parking1.garer(voiture1, 0);
      System.out.println(parking1.toString());
    } catch(ExceptionParking e){
      System.out.println(e.getMessage());
    }
    try{
      parking1.garer(voiture1, 3);
      System.out.println(parking1.toString());
    } catch(ExceptionParking e){
      System.out.println(e.getMessage());
    }
    try{
      parking1.garer(voiture1, 0);
      System.out.println(parking1.toString());
    } catch(ExceptionParking e){
      System.out.println(e.getMessage());
    }



    try{
      parking1.sortir(0);
      System.out.println(parking1.toString());
    } catch(ExceptionParking e){
      System.out.println(e.getMessage());
    }

    try{
      parking1.sortir(3);
      System.out.println(parking1.toString());
    } catch(ExceptionParking e){
      System.out.println(e.getMessage());
    }

    try{
      parking1.sortir(0);
      System.out.println(parking1.toString());
    } catch(ExceptionParking e){
      System.out.println(e.getMessage());
    }
  }
}
