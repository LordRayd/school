/**
 * Compilateur PTS Version 0
 * F. Raimbault
 */
package pts.symb;

import java.util.Hashtable;

/**
 * Table des symboles implantée par une table de hachage. Une table est crée
 * pour chaque nouveau bloc. La gestion des niveaux de portée se fait à l'aide
 * d'un chainage avec la table du bloc englobant (gestion en pile).
 */
public class TableSymboles {

    /**
     * table de hachage associant un identificateur à un symbole
     */
    private Hashtable<String,Symbole> table;

    /**
     * lien vers la table des symboles du niveau précédent
     */
    private TableSymboles precedante;

    /**
     * niveau d'imbrication des blocs = nombre de tables de symboles empilées 
     */
    private static int niveau=0;
    
    /**
     * Constructeur
     */
    public TableSymboles() {
        table = new Hashtable<String,Symbole>();
    }

    /**
     * création et chainage d'une table des symboles pour un nouveau bloc
     * @return nouvelle table
     */
    public TableSymboles entrerBloc() {
        TableSymboles suivante = new TableSymboles();
        suivante.precedante = this;
        niveau += 1;
        //System.out.println("niveau apres entrerBloc()="+niveau);
        return suivante;
    }

    /**
     * suppression de la table des symboles du bloc courant
     * @return la table du bloc englobant
     */
    public TableSymboles sortirBloc() {
        niveau -= 1;
        //System.out.println("niveau apres sortirBloc()="+niveau);
        return precedante;
    }

    /**
     * Ajout d'un symbole dans la table des symbole du bloc courant
     * @param i l'identificateur du symbole à ajouter
     */
    public Symbole definir(String i) {
        Symbole symb= new Symbole(i,niveau);
        //System.out.println("definition de "+i+" au niveau "+niveau);
        table.put(i,symb);
        return symb;
    }

    /**
     * Recherche du symbole associé à un identificateur dans le bloc courant
     * puis dans les blocs englobants s'il n'est pas trouvé
     * @param i identificateur à recherche
     * @return le symbole associé à i ou null s'il n'a pas été trouvé
     */
    public Symbole referencer(String i) {
        Symbole symb = table.get(i);
        if (symb != null)
            return symb;
        else if (precedante != null)
            return precedante.referencer(i);
        else
            return null;
    }

    /**
     * Test de présence d'un identificateur dans la table des symboles du bloc
     * courant
     * @param i identificateur à recherche
     * @return vrai ssi i a été trouvé dans la table du bloc courant
     */
    public boolean contient(String i) {
        return table.containsKey(i);
    }

}