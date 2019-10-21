/**
 * Compilateur PTS Version 0
 * F. Raimbault
 */
package pts.symb;

import pts.type.Type;

/**
 * Symbole correspondant à un identificateur de la table des symboles 
 */
public class Symbole {

    /**
     * identificateur associé
     */
    public String ident;

    /**
     * Type du symbole. 
     * Attribut mis à jour dans AnalyseurTypes.parcours()
     */
    public Type type;

  
    /**
     * Portée d'une variable : 0 pour une variable globale, 1 sinon.
     * Attribut mis à jour à la déclaration
     */
    private int portee;
    
    /**
     * Indicateur de portee globale
     * @return vrai ssi le symbole est déclaré au niveau 0
     */
    public boolean estGlobal(){
        return portee==0;
    }
    
    /**
     * Adresse relative d'une variable dans la pile d'exécution.
     * Attribut mis à jour dans GenerateurCode.parcours()
     */
    public int adresse;
    
    /**
     * Etiquette associée à une fonction dans le code MAP.
     * Attribut mis à jour dans GenerateurCode.parcours()
     */
    public String etiquette;
    
    /**
     * Taille occupée en mémoire.
     * Attribut mis à jour dans GenerateurCode.parcours()
     */
    public int taille;
  
    /**
     * Constructeur d'un symbole lors de sa déclaration. 
     * @param i identificateur du symbole
     * @param p portée du symbole
     */
    Symbole(String i, int p) {
        ident = i;
        portee= p;
    }

    /**
     * Chaine pour affichage textuel
     * @return la chaine 
     */
    public String toString() {
        StringBuffer s= new StringBuffer();
        s.append(ident);
        s.append('@').append(portee);
        if (type !=null) s.append(':').append(type);
        return s.toString();
    }

    /**
     * Chaine pour affichage avec dot
     * @return la chaine
     */
    public String toDot() {
        return toString();
    }

}