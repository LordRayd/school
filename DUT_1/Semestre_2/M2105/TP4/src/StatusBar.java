import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe Interface graphique
 * @author Furno - Le Berre -- Groupe A
 * @version 1.0
 */
public class StatusBar extends JPanel{
	
	
	private JLabel nameLabel;
	private JLabel dateLabel;
	
	/**
	 * 
	 * @param nom
	 * @param date
	 */
	public StatusBar(String nom, Date date){
		super();
	    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	    nameLabel = new JLabel("Bonjour " + nom + " !");
	    dateLabel = new JLabel(f.format(date));
	    setLayout(new BorderLayout());;
	    add(nameLabel,BorderLayout.WEST);
	    add(dateLabel,BorderLayout.EAST);
	    setVisible(true);
	}
	/**
	 * 
	 * @param nom
	 */
	public void setAction(String nom){
		this.nameLabel.setText(nom);
	}
}