package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Accueil;
import view.Acheter;
import view.AuMagasin;
import view.InterfaceGraphique;
import view.MesOutils;
import view.MesProduits;
import view.MesUstensils;
import view.NettoyageEnCours;
import view.Parametre;
import view.Quantite;
import view.Surface;

public class ButtonControler implements ActionListener{

	private InterfaceGraphique iG;

	public ButtonControler(InterfaceGraphique iG){
		this.iG = iG;
	}

	@Override
	public void actionPerformed(ActionEvent clic) {

		//================= FROM ACCUEIL ===================================================== FAIT|||||||||||||
		if(clic.getSource() == this.getiG().getAccueil().getFaireMenage()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setSurface(new Surface(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getSurface());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}
		if(clic.getSource() == this.getiG().getAccueil().getMesOutils()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setMesOutils(new MesOutils(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getMesOutils());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}
		if(clic.getSource() == this.getiG().getAccueil().getParametre()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setParametre(new Parametre(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getParametre());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}
		if(clic.getSource() == this.getiG().getAccueil().getAuMagasin()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setAuMagasin(new AuMagasin(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getAuMagasin());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}

		//================= FROM PARAMETRE ==================================================== FAIT|||||||||||||
		if(clic.getSource() == this.getiG().getParametre().getRetour()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setAccueil(new Accueil(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getAccueil());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}
		if(clic.getSource() == this.getiG().getParametre().getValider()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setAccueil(new Accueil(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getAccueil());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}

		//================= FROM SURFACE ======================================================== FAIT|||||||||||||
		if(clic.getSource() == this.getiG().getSurface().getRetour()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setAccueil(new Accueil(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getAccueil());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}
		if(clic.getSource() == this.getiG().getSurface().getValider()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setQuantite(new Quantite(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getQuantite());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}

		//================= FROM QUANTITE ======================================================== FAIT|||||||||||||
		if(clic.getSource() == this.getiG().getQuantite().getRetour()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setSurface(new Surface(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getSurface());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}
		if(clic.getSource() == this.getiG().getQuantite().getValider()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setNettoyageEnCours(new NettoyageEnCours(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getNettoyageEnCours());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}

		//================ FROM NETTOYAGEENCOURS ============================================================ FAIT|||||||||||||
		if(clic.getSource() == this.getiG().getNettoyageEnCours().getRetour()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setQuantite(new Quantite(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getQuantite());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}
		if(clic.getSource() == this.getiG().getNettoyageEnCours().getArret()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setAccueil(new Accueil(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getAccueil());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}

		//================ FROM MESOUTILS ========================================================= FAIT|||||||||||||
		if(clic.getSource() == this.getiG().getMesOutils().getRetour()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setAccueil(new Accueil(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getAccueil());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}
		if(clic.getSource() == this.getiG().getMesOutils().getUstensils()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setMesUstensils(new MesUstensils(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getMesUstensils());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}
		if(clic.getSource() == this.getiG().getMesOutils().getProduits()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setMesProduits(new MesProduits(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getMesProduits());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}

		//================ FROM MESUSTENSILS ======================================================== FAIT|||||||||||||
		if(clic.getSource() == this.getiG().getMesUstensils().getRetour()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setMesOutils(new MesOutils(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getMesOutils());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}
		if(clic.getSource() == this.getiG().getMesUstensils().getModifier()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setMesUstensils(new MesUstensils(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getMesUstensils());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}
		if(clic.getSource() == this.getiG().getMesUstensils().getAjouter()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setMesUstensils(new MesUstensils(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getMesUstensils());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}

		//================ FROM MESPRODUITS ============================================================ FAIT|||||||||||||
		if(clic.getSource() == this.getiG().getMesProduits().getRetour()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setMesOutils(new MesOutils(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getMesOutils());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}
		if(clic.getSource() == this.getiG().getMesProduits().getModifier()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setMesProduits(new MesProduits(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getMesProduits());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}
		if(clic.getSource() == this.getiG().getMesProduits().getAjouter()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setMesProduits(new MesProduits(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getMesProduits());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}

		//================ FROM AUMAGASIN ============================================================ FAIT|||||||||||||
		if(clic.getSource() == this.getiG().getAuMagasin().getRetour()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setAccueil(new Accueil(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getAccueil());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}
		if(clic.getSource() == this.getiG().getAuMagasin().getValider()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setAcheter(new Acheter(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getAcheter());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}

		//================ FROM ACHETER ============================================================ FAIT|||||||||||||
		if(clic.getSource() == this.getiG().getAcheter().getRetour()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setAuMagasin(new AuMagasin(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getAuMagasin());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
			this.getiG().repaint();
		}
		if(clic.getSource() == this.getiG().getAcheter().getConfirmer()){
			this.getiG().remove(this.getiG().getPanelVisible());
			this.getiG().setAccueil(new Accueil(this.getiG()));
			this.getiG().setPanelVisible(this.getiG().getAccueil());
			this.getiG().add(this.getiG().getPanelVisible());
			this.getiG().validate();
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
