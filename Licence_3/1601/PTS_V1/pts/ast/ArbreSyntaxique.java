/**
 * Compilateur PTS Version 0
 * F. Raimbault
 */
package pts.ast;

import java.io.FileWriter;
import java.io.IOException;

import pts.erreur.Erreur;
import pts.erreur.Messages;

/**
 * Arbre syntaxique abstrait produit par l'analyseur syntaxique. 
 * Tous les noeuds ont un nombre de fils CONSTANT (donc éventuellement à null) 
 * sauf s'il s'agit du dernier fils qui peut etre omis dans ce cas.
 */
public class ArbreSyntaxique {

    /** racine de l'AST */
    public Noeud racine;
 
    /**
     * Construction à partir de la racine 
     * @param n
     */
    public ArbreSyntaxique(Noeud n) {
        racine = n;
     }

    /**
     * chaine pour affichage sous forme textuelle
     */
    public String toString() {
        return racine.dump("");
    }
    
    /**
     * Affichage par gv apres création et exécution d'un fichier dot 
     * @param rep répertoire ou créer les fichiers .dot et .pdf
     * @param fich nom du fichier .dot 
     */
    public void toDot(String rep, String fich) {
        FileWriter fichier = null;
        String nomfich_dot= rep + "/" + fich + ".dot";
        String nomfich_pdf= rep + "/" + fich + ".pdf";
        try {
            fichier = new FileWriter(nomfich_dot);
        } catch (IOException e) {
            Erreur.systeme(Messages.DOT_OPEN,nomfich_dot);
        }
        try {
            fichier.write("digraph "+fich+" {\n");
            fichier.write("size=\"20,20\"\n");
            fichier.write("node [shape=plaintext]\n");
            fichier.write("edge [dir=none]\n");
            fichier.write(racine.toDot());
            fichier.write("}\n");
            fichier.close();
        } catch (IOException e) {
            Erreur.systeme(Messages.DOT_WRITE,nomfich_dot);
        }
        try {
			Runtime.getRuntime().exec("dot -Tpdf -o " + nomfich_pdf + " " + nomfich_dot).waitFor();
        } catch (Exception e) {
		    Erreur.systeme(Messages.DOT_EXEC,nomfich_dot);
		}
        try {
            Runtime.getRuntime().exec("nohup okular " + nomfich_pdf).waitFor();
		} catch (Exception e) {
		    Erreur.systeme(Messages.OKULAR_ERROR,nomfich_pdf);
		}
    }

}