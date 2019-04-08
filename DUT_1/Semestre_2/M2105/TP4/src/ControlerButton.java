import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * Classe Interface graphique
 * @author Furno - Le Berre -- Groupe A
 * @version 1.0
 */
public class ControlerButton implements ActionListener{

	private StatusBar statusBar;
	private ToolBar toolBar;
	private InformationPanel iP;
	private InterfaceGraphique iG;
	private Eleve eleveCourant;
	/**
	 * 
	 * @param iG
	 */
	public ControlerButton(InterfaceGraphique iG){
		this.statusBar = iG.getStatusBar();
		this.toolBar = iG.getToolBar();
		this.iP = iG.getInformationPanel();
		this.iG = iG;
	}

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent clic){

		if(clic.getSource() == toolBar.getRemoveButton()){
			for(Eleve eleve : iG.getListeEleve()){
				String message = JOptionPane.showInputDialog(null, "Nom de l'eleve a supprimer");
				message = message.toUpperCase();
				if(message.equals(eleve.getNom())){
					iG.getListeEleve().remove(eleve);
				}
			}
		}

		if(clic.getSource() == toolBar.getNewButton()){
			boolean sexe = true;
			if(iP.getHomme().isSelected() == true){
				sexe = true;
			}
			if(iP.getFemme().isSelected() == true){
				sexe = false;
			}
			boolean annee1 = false;
			if(iP.getPremiereACB().isSelected() == true){
				annee1 = true;
			}
			boolean annee2 = false;
			if(iP.getDeuxiemeACB().isSelected() == true){
				annee2 = true;
			}
			this.setEleveCourant(new Eleve(iP.getNomJTF().getText(),iP.getPrenomJTF().getText(),iP.getDateNaissanceJTF().getText(),iP.getCourrielJTF().getText(),sexe,annee1,annee2));
			iG.getListeEleve().add(this.getEleveCourant());
		}

		if(clic.getSource() == toolBar.getSaveButton()){
			getEleveCourant().setNom(iP.getNomJTF().getText());
			getEleveCourant().setPrenom(iP.getPrenomJTF().getText());
			getEleveCourant().setDateDeNaissance(iP.getDateNaissanceJTF().getText());
			getEleveCourant().setCourriel(iP.getCourrielJTF().getText());
			if(iP.getHomme().isSelected() == true){
				getEleveCourant().setSexe(true);
			}
			if(iP.getFemme().isSelected() == true){
				getEleveCourant().setSexe(false);
			}
			if(iP.getPremiereACB().isSelected() == true){
				getEleveCourant().setAnnee1(true);
			} else {
				getEleveCourant().setAnnee1(false);
			}
			if(iP.getDeuxiemeACB().isSelected() == true){
				getEleveCourant().setAnnee2(true);
			} else {
				getEleveCourant().setAnnee2(false);
			}
		}

		if(clic.getSource() == toolBar.getSaveAsButton()){
			for(Eleve eleve : iG.getListeEleve()){
				System.out.println(eleve.getNom());
				System.out.println(eleve.getPrenom());
				System.out.println(eleve.getDateDeNaissance());
				System.out.println(eleve.getCourriel());
				System.out.println(eleve.isSexe());
				System.out.println(eleve.isAnnee1());
				System.out.println(eleve.isAnnee2());
			}
		}

		if(clic.getSource() == toolBar.getLoadButton()){
			String message = JOptionPane.showInputDialog(null, "Nom de l'eleve");
			message = message.toUpperCase();
			String nom="";
			String prenom="";
			String date="";
			String courriel="";
			boolean sexe=true;
			boolean annee1=false;
			boolean annee2=false;
			for(Eleve eleve : iG.getListeEleve()){
				if(message.equals(eleve.getNom())){
					this.setEleveCourant(eleve);
					nom = eleve.getNom();
					prenom = eleve.getPrenom();
					date = eleve.getDateDeNaissance();
					courriel = eleve.getCourriel();
					sexe = eleve.isSexe();
					annee1 = eleve.isAnnee1();
					annee2 = eleve.isAnnee2();
				}
			}
			iP.getNomJTF().setText(nom);
			iP.getPrenomJTF().setText(prenom);
			iP.getDateNaissanceJTF().setText(date);
			iP.getCourrielJTF().setText(courriel);
			if(sexe == true){
				iP.getHomme().setSelected(true);
			} else {
				iP.getFemme().setSelected(true);
			}
			if(annee1 == true){
				iP.getPremiereACB().setSelected(true);
			} else {
				iP.getPremiereACB().setSelected(false);
			}
			if(annee2 == true){
				iP.getDeuxiemeACB().setSelected(true);
			} else {
				iP.getDeuxiemeACB().setSelected(false);
			}
		}
	}

	public Eleve getEleveCourant(){
		return this.eleveCourant;
	}

	public void setEleveCourant(Eleve eleveCourant) {
		this.eleveCourant = eleveCourant;
	}


}
