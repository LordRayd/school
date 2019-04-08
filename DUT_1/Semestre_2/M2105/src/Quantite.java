import javax.swing.JPanel;

public class Quantite extends JPanel {

	private InterfaceGraphique iG;
	
	public Quantite(InterfaceGraphique iG){
		this.setiG(iG);
	}

	public InterfaceGraphique getiG() {
		return iG;
	}

	public void setiG(InterfaceGraphique iG) {
		this.iG = iG;
	}
	
	
}
