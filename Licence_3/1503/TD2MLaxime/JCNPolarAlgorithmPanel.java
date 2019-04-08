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

public class JCNPolarAlgorithmPanel extends JPanel implements Observer{

    JCNPolarPanel polarPanel = new JCNPolarPanel();
    JCNPolarPanel polarPanel2 = new JCNPolarPanel();
    JCNPolarPanel polarPanel3 = new JCNPolarPanel();

    public JCNPolarAlgorithmPanel() {
        
        polarPanel3.imaginaryTextField.setEditable(false);
        polarPanel3.realTextField.setEditable(false);
        
        setLayout(new GridLayout(4, 1));
        add(new JLabel("Forme Polaire"));
        add(polarPanel, BorderLayout.NORTH);
        add(polarPanel2, BorderLayout.CENTER);
        add(polarPanel3, BorderLayout.SOUTH);
    }

    public void setValues(ComplexNumber cn1, ComplexNumber cn2, ComplexNumber cnSum) {
        cn1.addObserver(polarPanel);
        cn1.addObserver(this);
        cn2.addObserver(polarPanel2);
        cn2.addObserver(this);
        cnSum.addObserver(polarPanel3);
        polarPanel.setEditedComplexNumber(cn1);
        polarPanel2.setEditedComplexNumber(cn2);
        polarPanel3.setEditedComplexNumber(cnSum);
        
    }

        
    public static void main(String[] args) {
        new JCNPolarAlgorithmPanel();
    }

    @Override
    public void update(Observable o, Object arg) {
        ComplexNumber cnSum = polarPanel.getComplex().add(polarPanel2.getComplex());
        polarPanel3.setEditedComplexNumber(cnSum);
    }

}
