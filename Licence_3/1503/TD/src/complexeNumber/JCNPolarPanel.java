package complexeNumber;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.Action;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

/**
 * JCNPolarPanel est un JPanel permettant d'afficher et d'éditer la forme
 * polaire d'un nombre complexe.
 * Representer tel que :
 * ------------------------------------------
 * |Module :  |  valeur | Argument | valeur |
 * ------------------------------------------
 * @author e1604902 Samuel LE BERRE -- OCTOBRE 2018
 * @version 1.1
 */
public class JCNPolarPanel extends JPanel implements Observer{

    /**
     * Zone d'édition du module du nombre complexe affiché.
     */
    private JTextField modulusTextField;
    /**
     * Zone d'édition de l'argument du nombre complexe affiché.
     */
    private JTextField argumentTextField;
    /**
     * Nombre complexe édité.
     */
    private ComplexNumber complexNumber;
    
    /**
     * Action de mise à jour du nombre complexe affiché.
     */
    Action updateComplexNumberAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (complexNumber != null) {
                try {
                    double modulus = Double.parseDouble(modulusTextField.getText());
                    double argument = Double.parseDouble(argumentTextField.getText());
                    complexNumber.setModulus(modulus);
                    complexNumber.setArgument(argument);
                } catch (NumberFormatException nfex) {
                    nfex.printStackTrace();
                }
            }
        }
    };

    /**
     * Constructeur d'objets de classe JCNPolarPanel
     */
    public JCNPolarPanel() {
        this.complexNumber = null;
        GridLayout gridLayout = new GridLayout(1, 4);
        setLayout(gridLayout);
        
        JLabel realLabel = new JLabel("Modulus : ");
        this.modulusTextField = new JTextField();
        JLabel imaginaryLabel = new JLabel("Argument : ");
        this.argumentTextField = new JTextField();
        
        this.add(realLabel);
        this.add(modulusTextField);
        this.add(imaginaryLabel);
        this.add(argumentTextField);
        
        this.modulusTextField.addActionListener(updateComplexNumberAction);
        this.argumentTextField.addActionListener(updateComplexNumberAction);
    }

    /**
     * Spécifie le nombre complexe édité.
     * @param complexNumber Le nombre complexe à éditer ou {@code null}.
     */
    public void setEditedComplexNumber(ComplexNumber complexNumber) {
        this.complexNumber = complexNumber;
        updateDisplay();
    }

    /**
     * Mise à jour de l'affichage.
     */
    private void updateDisplay() {
        if (complexNumber == null) {
            modulusTextField.setText("");
            modulusTextField.setEnabled(false);
            argumentTextField.setText("");
            argumentTextField.setEnabled(false);
        } else {
            modulusTextField.setText(Double.toString(complexNumber.getModulus()));
            modulusTextField.setEnabled(true);
            argumentTextField.setText(Double.toString(complexNumber.getArgument()));
            argumentTextField.setEnabled(true);
        }
    }
    
    /**
     * Renvoie la zone de saisie du module du nombre complexe
     * @return La zone de saisie du module
     */
    public JTextField getModulusTextField(){
        return this.modulusTextField;
    }
    
    /**
     * Renvoie la zone de saisie de l'argument du nombre complexe
     * @return La zone de saisie de l'argument
     */
    public JTextField getArgumentTextField(){
        return this.argumentTextField;
    }
    
    /**
     * Renvoie le nombre complexe édité
     * @return  Le nombre complexe
     */
    public ComplexNumber getComplexNumber(){
        return this.complexNumber;
    }
 
    /**
     * Change les données du nombre complexe édité par celle passées en paramètre
     * @param m Le module 
     * @param a L'argument
     */
    public void setComplexNumber(double m, double a){
        this.complexNumber.setModulus(m);
        this.complexNumber.setArgument(a);
    }

    /**
     * Mise à jour quand un observable envoie une notification de changement
     * @param o L'observable
     * @param o1 L'objet
     */
    @Override
    public void update(Observable o, Object o1) {
        this.complexNumber = (ComplexNumber) o;
        this.updateDisplay();
    }
}
