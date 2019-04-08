/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.Action;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

/**
 * JCNCartesianPanel est un JPanel permettant d'afficher et d'éditer la forme
 * cartésienne d'un nombre complexe.
 * <pre>
 * *--------------*--------------*--------------
 *--------------*
 * | réel : | | Imaginaire : |
 * |
 * *--------------*--------------*--------------
 *--------------*
 * </pre>
 *
 * @author Erik MAZOYER
 * @version 1.0
 */
public class JCNPolarPanel extends JPanel implements Observer {
    
    
       

    /**
     * Zone d'édition de la partie réelle du nombre complexe affiché.
     */
    public JTextField realTextField;
    /**
     * Zone d'édition de la partie imaginaire du nombre complexe affiché.
     */
    public JTextField imaginaryTextField;
    /**
     * Nombre complexe édité.
     */
    private ComplexNumber complexNumber;
    /**

    /**
     * Constructeur d'objets de classe JcartesianCNPanel
     */
    public JCNPolarPanel() {

        complexNumber = null;

        GridLayout gridLayout = new GridLayout(1, 4);
        setLayout(gridLayout);

        JLabel realLabel = new JLabel("Module : ");
        realTextField = new JTextField();
        JLabel imaginaryLabel = new JLabel("Argument : ");
        imaginaryTextField = new JTextField();
        this.add(realLabel);
        this.add(realTextField);
        this.add(imaginaryLabel);
        this.add(imaginaryTextField);
        realTextField.addActionListener(updateComplexNumberAction);
        imaginaryTextField.addActionListener(updateComplexNumberAction);

    }

    /**
     * Spécifie le nombre complexe édité.
     *
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

            realTextField.setText(Double.toString(complexNumber.getModulus()));
            realTextField.setEnabled(true);

            imaginaryTextField.setText(Double.toString(complexNumber.getArgument()));
            imaginaryTextField.setEnabled(true);
        }
    }
    
    @Override
     public void update(Observable o, Object arg){
            complexNumber = (ComplexNumber) o;
            this.updateDisplay();
     }
     
     public ComplexNumber getComplex(){
        return this.complexNumber;
    }
     
     /**
    * Action de mise à jour du nombre complexe affiché.
    */
    Action updateComplexNumberAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e){
            if(complexNumber != null) {
                try {
                    double real = Double.parseDouble(realTextField.getText());
                    double imaginary = Double.parseDouble(imaginaryTextField.getText());
                    complexNumber.setReal(real);
                    complexNumber.setImaginary(imaginary);
                } 
                catch(NumberFormatException nfex){
                    nfex.printStackTrace();
                }
            }
        }
    };

    /**
     * Main de test.
     *
     * @param args arguments.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("JCNPolarPanel");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PolarComplexNumber complexNumber = new PolarComplexNumber(5, 3);
        JCNPolarPanel polarPanel = new JCNPolarPanel();
        complexNumber.addObserver(polarPanel);

        polarPanel.setEditedComplexNumber(complexNumber);
        frame.getContentPane().add(polarPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
