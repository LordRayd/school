import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonControler implements ActionListener {

	private InterfaceGraphique iG;
	
	public ButtonControler(InterfaceGraphique iG){
		this.iG = iG;
	}
	@Override
	public void actionPerformed(ActionEvent clic) {
		
		// A partir de ACCUEIL
		if(clic.getSource() == iG.getAccueil().getFaireMenage()){
			this.getiG().removeAll();
			this.getiG().setContentPane(this.getiG().getFaireMenage());
			this.getiG().repaint();
		}
		
		if(clic.getSource() == this.getiG().getAccueil().getMesOutils()){
			this.getiG().removeAll();
			this.getiG().setContentPane(this.getiG().getMesOutils());
			this.getiG().repaint();
		}
		
		if(clic.getSource() == this.getiG().getAccueil().getAuMagasin()){
			this.getiG().removeAll();
			this.getiG().setContentPane(this.getiG().getAuMagasin());
			this.getiG().repaint();
		}
		
		//A partir de FAIRE MENAGE
		if(clic.getSource() == this.getiG().getFaireMenage().getRetour()){
			this.getiG().removeAll();
			this.getiG().setContentPane(this.getiG().getAccueil());
			this.getiG().repaint();
		}
		
		if(clic.getSource() == this.getiG().getFaireMenage().getValider()){
			this.getiG().removeAll();
			this.getiG().setContentPane(this.getiG().getQuantite());
			this.getiG().repaint();
		}

	}
	public InterfaceGraphique getiG() {
		return iG;
	}
	public void setiG(InterfaceGraphique iG) {
		this.iG = iG;
	}
	
	

}
