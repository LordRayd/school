/**
 * Compilateur PTS Version 0
 * F. Raimbault
 */
package pts.erreur;

/**
 * Types d'erreurs signalées par le compilateur
 */
public enum TypeErreurs {
  SYSTEME, INTERNE, PARAMETRE, COMPILATION;
  
  public String toString(){
    return "erreur de "+this.name();
  }
}
