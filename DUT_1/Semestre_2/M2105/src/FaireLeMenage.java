import javax.swing.JButton;
import javax.swing.JPanel;

public class FaireLeMenage extends JPanel {
	
	private InterfaceGraphique iG;
	private JButton retour;
	private JButton surface;
	private JButton piece;
	private JButton valider;
	
	public FaireLeMenage(InterfaceGraphique iG){
		this.setiG(iG);
		this.setRetour(new JButton("Retour"));
		this.setValider(new JButton("Valider"));
	}

	public InterfaceGraphique getiG() {
		return iG;
	}

	public void setiG(InterfaceGraphique iG) {
		this.iG = iG;
	}

	public JButton getRetour() {
		return retour;
	}

	public void setRetour(JButton retour) {
		this.retour = retour;
	}

	public JButton getValider() {
		return valider;
	}

	public void setValider(JButton valider) {
		this.valider = valider;
	}
	
}
