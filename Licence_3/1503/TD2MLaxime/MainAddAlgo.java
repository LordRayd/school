
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;

/**
 * Algorithm d'ajout
 */
public class MainAddAlgo {

    /**
     * Main
     *
     * @param args arguments.
     */
    public static void main(String[] args) {
        ComplexNumberAbstractFactory factory = new CartesianComplexNumberFactory();
        final ComplexNumber cn1 = factory.createComplexNumberFromCartesian(3, 6);
        final ComplexNumber cn2 = factory.createComplexNumberFromCartesian(2, 8);
        final ComplexNumber cnSum = cn1.add(cn2);

        JFrame frame = new JFrame("MainAddAlgo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JCNCartesianAlgorithmPanel cartesianAlgorithmPanel = new JCNCartesianAlgorithmPanel();
        cartesianAlgorithmPanel.setValues(cn1, cn2, cnSum);

        JCNPolarAlgorithmPanel polarAlgorithmPanel = new JCNPolarAlgorithmPanel();
        polarAlgorithmPanel.setValues(cn1, cn2, cnSum);
        cartesianAlgorithmPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        polarAlgorithmPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        frame.getContentPane().add(cartesianAlgorithmPanel, BorderLayout.NORTH);
        frame.getContentPane().add(polarAlgorithmPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
    
    
}
