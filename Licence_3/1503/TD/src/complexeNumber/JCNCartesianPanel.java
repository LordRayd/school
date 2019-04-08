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
 * JCNCartesianPanel est un JPanel permettant d'afficher et d'éditer la forme
 * cartésienne d'un nombre complexe.
 * Representer tel que :
 * ------------------------------------------
 * |Reel :  |  valeur | Imaginaire | valeur |
 * ------------------------------------------
 * @author e1604902 Samuel LE BERRE -- OCTOBRE 2018
 * @version 1.1
 */
public class JCNCartesianPanel extends JPanel implements Observer {

    /**
     * Zone d'édition de la partie réelle du nombre complexe affiché.
     */
    private JTextField realTextField;
    /**
     * Zone d'édition de la partie imaginaire du nombre complexe affiché.
     */
    private JTextField imaginaryTextField;
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
                    double real = Double.parseDouble(realTextField.getText());
                    double imaginary = Double.parseDouble(imaginaryTextField.getText());
                    complexNumber.setReal(real);
                    complexNumber.setImaginary(imaginary);
                } catch (NumberFormatException nfex) {
                    nfex.printStackTrace();
                }
            }
        }
    };

    /**
     * Constructeur d'objets de classe JCNCartesianPanel
     */
    public JCNCartesianPanel() {
        this.complexNumber = null;
        GridLayout gridLayout = new GridLayout(1, 4);
        setLayout(gridLayout);
        
        JLabel realLabel = new JLabel("Réel : ");
        this.realTextField = new JTextField();
        JLabel imaginaryLabel = new JLabel("Imaginaire : ");
        this.imaginaryTextField = new JTextField();
        
        this.add(realLabel);
        this.add(realTextField);
        this.add(imaginaryLabel);
        this.add(imaginaryTextField);
        
        realTextField.addActionListener(updateComplexNumberAction);
        imaginaryTextField.addActionListener(updateComplexNumberAction);
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
            realTextField.setText("");
            realTextField.setEnabled(false);
            imaginaryTextField.setText("");
            imaginaryTextField.setEnabled(false);
        } else {
            realTextField.setText(Double.toString(complexNumber.getReal()));
            realTextField.setEnabled(true);
            imaginaryTextField.setText(Double.toString(complexNumber.getImaginary()));
            imaginaryTextField.setEnabled(true);
        }
    }
    
    /**
     * Retourne le champ de saisie du reel
     * @return  Le champ de saisie
     */
    public JTextField getRealTextField(){
        return this.realTextField;
    }
    
    /**
     * Retourne le champ de saisie de l imaginaire
     * @return Le champ de saisie
     */
    public JTextField getImaginaryTextField(){
        return this.imaginaryTextField;
    }
    
    /**
     * Retourne le nombre complexe édité
     * @return Le nombre complexe
     */
    public ComplexNumber getComplexNumber(){
        return this.complexNumber;
    }

    /**
     * Affecte au nombre complexe les valeurs passes en paramètre
     * @param r Le reel
     * @param i L imaginaire
     */
    public void setComplexNumber(double r, double i){
        this.complexNumber.setReal(r);
        this.complexNumber.setImaginary(i);
    }
    
    /**
     * 
     * @param o 
     * @param o1 
     */
    @Override
    public void update(Observable o, Object o1) {
        this.complexNumber = (ComplexNumber) o;
        this.updateDisplay();
    }
    
}
