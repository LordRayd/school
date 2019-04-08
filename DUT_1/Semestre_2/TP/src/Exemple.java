import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exemple {

	public static void main(String[] args) {
		
		JPanel panel = new JPanel();
		
		/* On ajoute un gridbagLauout au panel */
		panel.setLayout(new GridBagLayout());
		
		/* Le gridBagConstraints va définir la position et la taille des éléments */
		GridBagConstraints gc = new GridBagConstraints();
		
		/* le parametre fill sert à définir comment le composant sera rempli GridBagConstraints.BOTH permet d'occuper tout l'espace disponible
		 * horizontalement et verticalement GridBagConstraints.HORIZONTAL maximise horizontalement GridBagConstraints.VERTICAL maximise verticalement
		 */
		gc.fill = GridBagConstraints.BOTH;
		
		/* insets définir la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
		gc.insets = new Insets(5, 5, 5, 5);
		
		/* ipady permet de savoir où on place le composant s'il n'occupe pas la totalité de l'espace disponnible */
		gc.ipady = gc.anchor = GridBagConstraints.CENTER;

		/* weightx définit le nombre de cases en abscisse */
		gc.weightx = 3;
		
		/* weightx définit le nombre de cases en ordonnée */
		gc.weighty = 3;
		
		/* pour dire qu'on ajoute un composant en position (i, j), on définit gridx=i et gridy=j */
		gc.gridx = 0;
		gc.gridy = 0;
		
		/* On ajoute le composant au panel en précisant le GridBagConstraints */
		panel.add(new JButton("0,0"), gc);
		gc.gridx = 1;
		gc.gridy = 0;
		panel.add(new JButton("1,0"), gc);
		gc.gridx = 2;
		gc.gridy = 0;
		panel.add(new JButton("2,0"), gc);
		gc.gridx = 0;
		gc.gridy = 1;
		panel.add(new JButton("0,1"), gc);
		gc.gridx = 1;
		gc.gridy = 1;
		
		/* On peut définit un composant qui prend plusieurs cases à l'aide de gridwidth */
		gc.gridwidth = 2;
		panel.add(new JButton("1,1"), gc);
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridwidth = 3;
		panel.add(new JButton("0,3"), gc);
		
		/* Définition de la fenêtre */
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(panel);
		f.setSize(500, 300);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}