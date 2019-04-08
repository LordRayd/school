/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class JCNCartesianAlgorithmPanel extends JPanel implements Observer{


    JCNCartesianPanel cartesianPanel = new JCNCartesianPanel();
    JCNCartesianPanel cartesianPanel2 = new JCNCartesianPanel();
    JCNCartesianPanel cartesianPanel3 = new JCNCartesianPanel();
    
    public JCNCartesianAlgorithmPanel() {
        
        
        cartesianPanel3.imaginaryTextField.setEditable(false);
        cartesianPanel3.realTextField.setEditable(false);
        setLayout(new GridLayout(4, 1));
        add(new JLabel("Forme Cartésienne"));
        add(cartesianPanel);
        add(cartesianPanel2);
        add(cartesianPanel3);
    }

    public void setValues(ComplexNumber cn1, ComplexNumber cn2, ComplexNumber cnSum) {
        
        cn1.addObserver(cartesianPanel);
        cn1.addObserver(this);
        cn2.addObserver(cartesianPanel2);
        cn2.addObserver(this);
        cartesianPanel.setEditedComplexNumber(cn1);
        cartesianPanel2.setEditedComplexNumber(cn2);
        cartesianPanel3.setEditedComplexNumber(cnSum);
        
    }
    
    /**
    * Action de mise à jour du nombre complexe affiché.
    */
    Action updateComplexNumberAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e){
            ComplexNumber cnSum = cartesianPanel.getComplex().add(cartesianPanel2.getComplex());
            cartesianPanel3.setEditedComplexNumber(cnSum);
        }
    };


    public static void main(String[] args) {
        new JCNCartesianAlgorithmPanel();
    }

    @Override
    public void update(Observable o, Object arg) {
        ComplexNumber cnSum = cartesianPanel.getComplex().add(cartesianPanel2.getComplex());
        cartesianPanel3.setEditedComplexNumber(cnSum);
    }

}
