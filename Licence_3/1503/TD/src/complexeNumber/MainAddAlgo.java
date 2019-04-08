package complexeNumber;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 * Classe de lancement du programme
 * @author e1604902 Samuel LE BERRE -- OCTOBER 2018
 * @version 1.0
 */
public class MainAddAlgo {

    /**
     * Methode de lancement du programme
     * @param args arguments.
     */
    public static void main(String[] args) {
        ComplexNumberAbstractFactory factory = new CartesianComplexNumberFactory();
        
        final ComplexNumber cn1 = factory.createComplexNumberFromCartesian(3,6);
        final ComplexNumber cn2 = factory.createComplexNumberFromCartesian(2,8);
        final ComplexNumber cnSum = cn1.add(cn2);
        
        JFrame frame = new JFrame("MainAddAlgo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JCNCartesianAlgorithmPanel cartesianAlgorithmPanel = new JCNCartesianAlgorithmPanel();
        cartesianAlgorithmPanel.setValues(cn1,cn2,cnSum);  
        
        JCNPolarAlgorithmPanel polarAlgorithmPanel = new JCNPolarAlgorithmPanel();
        polarAlgorithmPanel.setValues(cn1,cn2,cnSum);
        
        AlgorithmListModel listModel = new AlgorithmListModel(cn1, cn2, cnSum);
        JList<ComplexNumber> list = new JList<ComplexNumber>();
        list.setModel(listModel);
        list.setCellRenderer(new ComplexNumberListCellRenderer());
        
        JComboBox<ComplexNumber> comboBox = new JComboBox<ComplexNumber>();
        comboBox.setModel(listModel);
        
        frame.getContentPane().add(cartesianAlgorithmPanel, BorderLayout.NORTH);
        frame.getContentPane().add(comboBox, BorderLayout.WEST);
        frame.getContentPane().add(list,BorderLayout.CENTER);
        frame.getContentPane().add(polarAlgorithmPanel,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}