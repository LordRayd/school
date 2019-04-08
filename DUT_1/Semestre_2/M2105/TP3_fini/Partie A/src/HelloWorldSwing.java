import javax.swing.*;
public class HelloWorldSwing {
/**
* Create the GUI and show it.  For thread safety,
* this method should be invoked from the
* event - dispatching thread.
*/
private static void createAndShowGUI(String[] message) {
  //Create and set up the window.
  JFrame frame = new JFrame("HelloWorldSwing"); //Creation de la fenetre
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Permet de fermer totalement la fenetre
  //Add the ubiquitous "Hello World" label.
  JLabel label;
  for(int i = 0; i < message.length ; i++){
    frame.getContentPane().setLayout(new java.awt.FlowLayout()); //Affiche dans l'ordre les labels 
    label = new JLabel(message[i]);  //Creation de l'étiquette "Hello world" qui permet d'afficher dans la fenetre
    frame.getContentPane().add(label); //Ajoute l'etiquette label à la fenetre
  }
  //Display the window.
  frame.pack(); // Adapte la taille de la fenêtre à son contenu
  frame.setVisible(true); //Rend visible à l'utlisateur
  }
  public static void main(String[] args) {
    //Schedule a job for the event - dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI(args);
      }
    });
  }
}
