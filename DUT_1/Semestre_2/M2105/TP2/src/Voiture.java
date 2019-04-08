/**
* Classe Voiture TP2 IHM
* @author Tristan Furno - Samuel LeBerre
*/
public class Voiture{
  /**
  * Marque de la voiture
  */
  private String marque;

  /**
  * Modele de la voiture
  */
  private String modele;

  /**
  * Puissance de la voiture
  */
  private int puissance;

  /**
  * Constructeur de la classe voiture
  * @param marque  Marque de la voiture
  * @param modele Modele de la voiture
  * @param puissance Puissance de la voiture
  */
  public Voiture(String marque, String modele, int puissance){
    if ((marque != null) && (modele !=null) && (puissance > 0)){
      this.marque = marque;
      this.modele = modele;
      this.puissance = puissance;
    }
  }

  /**
  * methode toString de la classe Voiture
  * @return Les parametres en toString
  */
  public String toString(){
    String ret = "\nVoiture : ";
    ret += "\nMarque : " + this.marque;
    ret += "\nModele : " + this.modele;
    ret += "\nPuissance : " + this.puissance;
    return ret;
  }

}
