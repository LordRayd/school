import javax.swing.JFrame;
 
public class Test {
  public static void main(String[] args){

    JFrame fenetre = new JFrame();  
    //Définit un titre pour notre fenêtre
    fenetre.setTitle("Ma premiere fenetre Java");
    //Définit sa taille : 400 pixels de large et 100 pixels de haut
    fenetre.setSize(1000, 400);
    //Nous demandons maintenant à notre objet de se positionner au centre
    fenetre.setLocationRelativeTo(null);
    //Termine le processus lorsqu'on clique sur la croix rouge
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Et enfin, la rendre visible        
    fenetre.setVisible(true);

    JPanel pan = new JPanel();
    //Définition de sa couleur de fond
    pan.setBackground(Color.ORANGE);        
    //On prévient notre JFrame que notre JPanel sera son content pane
    this.setContentPane(pan);               
    this.setVisible(true);
  }       
}