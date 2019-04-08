package complexeNumber;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

/**
 * Affiche trois JCNPolarPanel empilé les uns sur les autres.
 * Sous-classes de JPanel. Implemente l'interface Observer.
 * Representer tel que :
 * ------------------------------------------
 * |Module :  |  valeur | Argument | valeur |
 * ------------------------------------------
 * |Module :  |  valeur | Argument | valeur |
 * ------------------------------------------
 * |Module :  |  valeur | Argument | valeur |
 * ------------------------------------------
 * @author e1604902 Samuel LE BERRE -- OCTOBRE 2018
 * @version 1.1
 */
public class JCNPolarAlgorithmPanel extends JPanel implements Observer{

    /**
     * Le premier panneau affichant le premier nombre complexe
     * sous sa forme polaire.
     */
    private final JCNPolarPanel polarPanel1;
    /**
     * Le deuxième panneau affichant le deuxième nombre complexe
     * sous sa forme polaire.
     */
    private final JCNPolarPanel polarPanel2;
    /**
     * Le troisième panneau affichant le troisième nombre complexe
     * sous sa forme polaire.
     */
    private final JCNPolarPanel polarPanel3;    
    
    /**
     * Constructeur d'objets de classe JCNPolarAlgorithmPanel
     */
    public JCNPolarAlgorithmPanel() {        
        GridLayout gridLayout = new GridLayout(3, 1);
        this.setLayout(gridLayout);
        
        this.polarPanel1 = new JCNPolarPanel();
        this.polarPanel2 = new JCNPolarPanel();
        this.polarPanel3 = new JCNPolarPanel();
        this.polarPanel3.getModulusTextField().setEditable(false);
        this.polarPanel3.getArgumentTextField().setEditable(false);
        
        //Ligne 1
        this.add(this.polarPanel1);
        //Ligne 2
        this.add(this.polarPanel2);
        //Ligne 3
        this.add(this.polarPanel3);   
    }

    /**
     * Affecte les nombres complexes de l'objet avec ceux passés en paramètre
     * @param cn1 Le premier nombre complexe
     * @param cn2 Le deuxième nombre complexe
     * @param cnSum Le troisième nombre complexe qui est la somme des deux premiers
     */
    public void setValues(ComplexNumber cn1, ComplexNumber cn2, ComplexNumber cnSum){        
        this.polarPanel1.setEditedComplexNumber(cn1);
        cn1.addObserver(this.polarPanel1);
        cn1.addObserver(this);
        this.polarPanel2.setEditedComplexNumber(cn2);
        cn2.addObserver(this.polarPanel2);
        cn2.addObserver(this);
        this.polarPanel3.setEditedComplexNumber(cnSum);
    }
    
    /**
     * Mise à jour du nombre complexe cnSum lorsqu'un observable est modifié
     * @param o L'observable qui a changé
     * @param o1 Un argument donné dans la méthode notifyObservers
     */
    @Override
    public void update(Observable o, Object o1) {
        ComplexNumber cnSum = polarPanel1.getComplexNumber().add(polarPanel2.getComplexNumber());
        polarPanel3.setEditedComplexNumber(cnSum);
    }
    
    /**
     * Renvoie le premier panneau
     * @return Le premier panneau
     */
    public JCNPolarPanel getPolarPanel1(){
        return this.polarPanel1;
    }
    /**
     * Renvoie le deuxième panneau
     * @return Le deuxxième panneau
     */
    public JCNPolarPanel getPolarPanel2(){
        return this.polarPanel2;
    }
    /**
     * Renvoie le troisième panneau
     * @return Le troisième panneau
     */
    public JCNPolarPanel getPolarPanel3(){
        return this.polarPanel3;
    }
    
    /**
     * Main
     * @param args arguments.
     */
    /*public static void main(String[] args) {
        JFrame frame = new JFrame("JCNPolarAlgorithmPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        PolarComplexNumber complexNumber1 = new PolarComplexNumber(1, 1);
        PolarComplexNumber complexNumber2 = new PolarComplexNumber(3, 2);
        ComplexNumber complexNumber3 = complexNumber1.add(complexNumber2);
        
        JCNPolarAlgorithmPanel polarPanel = new JCNPolarAlgorithmPanel();
        polarPanel.setValues(complexNumber1, complexNumber2, complexNumber3);
        
        frame.getContentPane().add(polarPanel,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }*/
}