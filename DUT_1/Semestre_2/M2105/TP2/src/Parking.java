/**
* Classe Parking TP2 IHM
* @author Tristan Furno - Samuel LeBerre
*/
import java.io.*;
public class Parking{

  /**
  * Constante NB_PLACES
  */
  private final int NB_PLACES = 2;

  /**
  * Tableau du nombre de places dans le Parking
  */
  private Voiture[] lesPlaces;

  /**
  * Constructeur de la classe Parking
  */
  public Parking(){
    this.lesPlaces = new Voiture[NB_PLACES];
  }

  /**
  * Methode toString de la classe Parking
  * @return les informations sur la classe Parking
  */
  public String toString(){
    String ret;
    ret = "\nEtat du parking :";
    for(int i = 0; i<NB_PLACES; i++){
      if(lesPlaces[i] == null){
        ret += "\nPlace " + i + " : Libre";
      } else {
        ret += "\nPlace " + i + " : \n" + lesPlaces[i].toString();
      }
    }
    return ret;
  }

  /**
  * Verifie si le numero est valide
  * @param numPlace la place a verifier
  * @throws ExceptionParking l'ExceptionParking
  */
  private void verifNum(int numPlace) throws ExceptionParking{
    try{
      if((numPlace < 0) || (numPlace >= NB_PLACES) ){

        throw new ExceptionParking("Numero de place non valide");
      }
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

  /**
  * Methode permettant de garer une voiture
  * @param voit la voiture a garer
  * @param numPlace place ou garer la voiture
  * @throws ExceptionParking l'ExceptionParking
  */
  public void garer(Voiture voit, int numPlace) throws ExceptionParking{
    try{
      this.verifNum(numPlace);
      if(this.lesPlaces[numPlace] != null){
        throw new ExceptionParking("Place deja occupee");

      } else {
        this.lesPlaces[numPlace] = voit;
      }
    }
    catch(Exception e){
        System.out.println(e.getMessage());
      }
  }

  /**
  * Methode permettant de sortir une voiture
  * @param numPlace place ou sortir la voiture
  * @return la voiture sortie du parking
  * @throws ExceptionParking l'ExceptionParking
  */
  public Voiture sortir(int numPlace) throws ExceptionParking{
    Voiture ret = null;
    try{
      this.verifNum(numPlace);
      if(this.lesPlaces[numPlace] == null){
        throw new ExceptionParking("Pas de voiture a cette place");

      } else {
        ret = this.lesPlaces[numPlace];
        this.lesPlaces[numPlace] = null;
      }
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
    return ret;

  }
}
