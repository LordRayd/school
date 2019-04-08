package complexeNumber;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Classe qui affiche les valeurs des nombres complexes dans des tableaux HTML.
 * Sous-classe de JLabel. Implemente ListCellRenderer.
 * @author e1604902 Samuel LE BERRE -- OCTOBER 2018
 * @version 1.0
 */
public class ComplexNumberListCellRenderer extends JLabel implements ListCellRenderer<ComplexNumber>{
    
    /**
     * Constructeur de la classe
     */
    public ComplexNumberListCellRenderer() {
        super();
        setOpaque(true);
    }

    /**
     * Retourne un composant qui affiche la valeur dans un tableau HTML.
     * Representer tel que :
     * --------------------------------------------
     * |Reel      |  valeur | Imaginaire | valeur |
     * --------------------------------------------
     * |Module    |  valeur | Argument   | valeur |
     * --------------------------------------------
     * @param list La liste qu'on souhaite afficher
     * @param value La valeur retourné par list.getModel().getElementAt(index)
     * @param index L'indice de la cellule
     * @param isSelected True si la cellule est selectionné
     * @param cellHasFocus True si la cellule à le focus
     * @return 
     */
    @Override
    public Component getListCellRendererComponent(JList<? extends ComplexNumber> list, ComplexNumber value, int index, boolean isSelected, boolean cellHasFocus) {
        setText("<html>"
                + "<table>"
                    + "<tr>"
                        + "<td>Reel</td>" 
                        + "<td>" + value.getReal() + "</td"
                        + "<td>Imaginary</td>" 
                        + "<td>" + value.getImaginary() + "</td"
                    + "</tr>"
                    + "<tr>"
                        + "<td>Modulus</td>" 
                        + "<td>" + value.getModulus() + "</td"
                        + "<td>Argument</td>" 
                        + "<td>" + value.getArgument() + "</td"
                    + "</tr>"
                + "</table>"
        );
        if (isSelected) {
            if(index%2==0) {
                setBackground(list.getSelectionBackground());
            } else {
                setBackground(list.getSelectionBackground().darker());
            }
            setForeground(list.getSelectionForeground());
        } else {
            if(index%2==0) {
                setBackground(list.getBackground());
            }else{
                setBackground(list.getBackground().darker());
            }
            setForeground(list.getForeground());
        }
        return this;
    }
}