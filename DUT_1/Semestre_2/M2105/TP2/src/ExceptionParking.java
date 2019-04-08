/**
* Classe ExceptionParking TP2 IHM
* @author Tristan Furno - Samuel LeBerre
*/
import java.io.*;
public class ExceptionParking extends Throwable{
  /**
  * Constructeur de la classe ExceptionParking
  * @param messageErreur le message a afficher
  */
  public ExceptionParking(String messageErreur){
    super(messageErreur);
  }
  /**
  * On procède de la sorte pour permettre d'avoir des exceptions personalisées pour chaque type d'erreur
  */

}
