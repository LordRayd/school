package complexeNumber;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

/**
 * Affiche trois JCNCartesianPanel empilé les uns sur les autres.
 * Sous-classes de JPanel. Implemente l'interface Observer.
 * Représenter tel que :
 * ------------------------------------------
 * |Reel :  |  valeur | Imaginaire | valeur |
 * ------------------------------------------
 * |Reel :  |  valeur | Imaginaire | valeur |
 * ------------------------------------------
 * |Reel :  |  valeur | Imaginaire | valeur |
 * ------------------------------------------
 * @author e1604902 Samuel LE BERRE -- OCTOBRE 2018
 * @version 1.1
 */
public class JCNCartesianAlgorithmPanel extends JPanel implements Observer{

    /**
     * Le premier panneau affichant le premier nombre complexe
     * sous sa forme cartésienne
     */
    private JCNCartesianPanel cartesianPanel1;
    /**
     * Le deuxième panneau affichant le deuxième nombre complexe
     * sous sa forme cartésienne
     */
    private JCNCartesianPanel cartesianPanel2;
    /**
     * Le troisième panneau affichant le troisième nombre complexe
     * sous sa forme cartésienne
     */
    private JCNCartesianPanel cartesianPanel3;    
    
    /**
     * Constructeur d'objets de classe JCNcartesianAlgorithmPanel
     */
    public JCNCartesianAlgorithmPanel() {
        GridLayout gridLayout = new GridLayout(3, 1);
        this.setLayout(gridLayout);
        
        this.cartesianPanel1 = new JCNCartesianPanel();
        this.cartesianPanel2 = new JCNCartesianPanel();
        this.cartesianPanel3 = new JCNCartesianPanel();

        //Rendre ineditable le troisième panneau d'affichage
        this.cartesianPanel3.getRealTextField().setEditable(false);
        this.cartesianPanel3.getImaginaryTextField().setEditable(false);
        
        //Ligne 1
        this.add(this.cartesianPanel1);
        //Ligne 2
        this.add(this.cartesianPanel2);
        //Ligne 3
        this.add(this.cartesianPanel3);
        
    }

    /**
     * Affecte les nombres complexes de l'objet avec ceux passés en paramètre
     * @param cn1 Le premier nombre complexe
     * @param cn2 Le deuxième nombre complexe
     * @param cnSum Le troisième nombre complexe qui est la somme des deux premiers
     */
    public void setValues(ComplexNumber cn1, ComplexNumber cn2, ComplexNumber cnSum){        
        this.cartesianPanel1.setEditedComplexNumber(cn1);
        cn1.addObserver(this.cartesianPanel1);
        cn1.addObserver(this);

        this.cartesianPanel2.setEditedComplexNumber(cn2);
        cn2.addObserver(this.cartesianPanel2);
        cn2.addObserver(this);
        
        this.cartesianPanel3.setEditedComplexNumber(cnSum);
    }
    
    /**
     * Mise à jour du nombre complexe cnSum lorsqu'un observable est modifié
     * @param o L'observable qui a changé
     * @param o1 Un argument donné dans la méthode notifyObservers
     */
    @Override
    public void update(Observable o, Object o1) {
        ComplexNumber cnSum = cartesianPanel1.getComplexNumber().add(cartesianPanel2.getComplexNumber());
        cartesianPanel3.setEditedComplexNumber(cnSum);
    }
    
    /**
     * Renvoie le premier panneau
     * @return Le premier panneau
     */
    public JCNCartesianPanel getCartesianPanel1(){
        return this.cartesianPanel1;
    }

    /**
     * Renvoie le deuxième panneau
     * @return Le deuxxième panneau
     */
    public JCNCartesianPanel getCartesianPanel2(){
        return this.cartesianPanel2;
    }

    /**
     * Renvoie le troisième panneau
     * @return Le troisième panneau
     */
    public JCNCartesianPanel getCartesianPanel3(){
        return this.cartesianPanel3;
    }
    
    /**
     * Main
     * @param args arguments.
     */
    /*public static void main(String[] args) {
        JFrame frame = new JFrame("JCNcartesianAlgorithmPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CartesianComplexNumber complexNumber1 = new CartesianComplexNumber(1, 1);
        CartesianComplexNumber complexNumber2 = new CartesianComplexNumber(3, 2);
        CartesianComplexNumber complexNumber3 = (CartesianComplexNumber)complexNumber1.add(complexNumber2);
        
        JCNCartesianAlgorithmPanel cartesianPanel = new JCNCartesianAlgorithmPanel();
        cartesianPanel.setValues(complexNumber1, complexNumber2, complexNumber3);
        
        frame.getContentPane().add(cartesianPanel,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }*/
}