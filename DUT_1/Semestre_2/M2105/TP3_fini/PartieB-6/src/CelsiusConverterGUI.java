import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CelsiusConverterGUI extends JFrame {

  private JLabel celsiusLabel;
  private JLabel fahrenheitLabel;
  private JButton celsiusButton;
  private JButton fahrenheitButton;
  private JTextField celsiusTextField;
  private JTextField fahrenheitTextField;
  
  /** Creates new form CelsiusConverterGUI */
  public CelsiusConverterGUI() {
    initComponents();
  }

  /** This method is called from within the constructor to
  * initialize the form.
  */
  private void initComponents() {
    //---------- OPTION FRAME -----------------------------
    setDefaultCloseOperation (EXIT_ON_CLOSE);
    setTitle("Celsius <=> Fahrenheit Converter");
    setSize(500,200);
    setLocationRelativeTo(null);
    //----------- TEXTFIELD -------------------------------
    celsiusTextField = new JTextField();
    fahrenheitTextField = new JTextField();
    //----------- ETIQUETTE C -----------------------------
    celsiusLabel = new JLabel();
    celsiusLabel.setText("Celsius");
    //----------- ETIQUETTE F -----------------------------
    fahrenheitLabel = new JLabel();
    fahrenheitLabel.setText("Fahrenheit");
    //----------- BOUTON C -> F ---------------------------
    celsiusButton = new JButton();
    celsiusButton.setText("C => F");
    Color colorCelsiusLabel = new Color(111,120,126);
    celsiusButton.setBackground(colorCelsiusLabel);
    celsiusButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        celsiusButtonActionPerformed(evt);
      }
    });
    //----------- BOUTON F -> C ---------------------------
    fahrenheitButton = new JButton();
    fahrenheitButton.setText("F => C");
    Color colorFahrenheitLabel = new Color(2,76,128);
    fahrenheitButton.setBackground(colorFahrenheitLabel);
    fahrenheitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        fahrenheitButtonActionPerformed(evt);
      }
    });
    //----------- OPTION PANEL ----------------------------
    JPanel pan = new JPanel();
    pan.setBackground(Color.WHITE);
    setContentPane(pan);               
    setVisible(true);
    //----------- CREATION GRID ET AJOUT COMPOSANT --------
    getContentPane().setLayout(new GridLayout(3,2));
    add(celsiusTextField);
    add(celsiusLabel);
    add(fahrenheitTextField);
    add(fahrenheitLabel);
    add(celsiusButton);
    add(fahrenheitButton);
  }

  /**
   * 
   * @param evt 
   */
  private void celsiusButtonActionPerformed(ActionEvent evt) {
    //Parse degrees Celsius as a double and convert to Fahrenheit
    int tempFahr = (int)((Double.parseDouble(celsiusTextField.getText()))* 1.8+ 32);
    String ret = ""+tempFahr;
    fahrenheitTextField.setText(ret);
  }

  /**
   * 
   * @param evt 
   */
  private void fahrenheitButtonActionPerformed(ActionEvent evt) {
    //Parse degrees Celsius as a double and convert to Fahrenheit
    int tempCels = (int)((Double.parseDouble((fahrenheitTextField.getText()))-32)/1.8);
    String ret = ""+tempCels;
    celsiusTextField.setText(ret);
  }

  /**
  * @param args the command line arguments
  */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new CelsiusConverterGUI().setVisible(true);
      }
    });
  }
}
