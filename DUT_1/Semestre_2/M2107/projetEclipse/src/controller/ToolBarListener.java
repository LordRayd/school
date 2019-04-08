package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

import model.OpenAndSave;
import view.GUI;
import view.JScrollPaneToSave;

/**
 * This class will listen the ToolBar its like the MenuBarListener
 * It implements the ActionListener Interface
 * @author Gurvan LORANS et Samuel LE BERRE
 *
 */
public class ToolBarListener implements ActionListener{

	/**
	 * This is the GUI of the application
	 */
	private GUI gui;
	/**
	 * This is the JTabbedPane that will be change with interaction
	 */
	private JTabbedPane tabbedPane;
	/**
	 * This is the OpenAndSave model class that contains method for save, print, etc
	 */
	private OpenAndSave openAndSave;

	/**
	 * This is the constructor for this listener
	 * @param gui The GUI of this application to allow changes on it
	 */
	public ToolBarListener(GUI gui){
		if(gui != null){
			this.gui = gui;
			this.tabbedPane = this.gui.getTabbedPane();
		}
		openAndSave  = new OpenAndSave(this);
	}

	/**
	 * The implemented method of the ActionListener interface
	 * it will check which button has been clicked and make an action accordingly of it
	 */
	@Override
	public void actionPerformed(ActionEvent e){

		if(e.getSource() == this.gui.getToolBar().getNewFile()){
			int i = 1;
			while(tabbedPane.indexOfTab("Sans Titre "+String.valueOf(i)) != -1){
				i++;
			}		
			openAndSave.makeTextPaneTab("Sans Titre "+String.valueOf(i));
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
		}

		if(e.getSource() == this.gui.getToolBar().getSave()){
			if(tabbedPane != null && tabbedPane.getTabCount()>0){
				if(tabbedPane.getSelectedComponent() instanceof JScrollPaneToSave){
					JScrollPaneToSave scrollText = (JScrollPaneToSave)tabbedPane.getSelectedComponent();
					if(scrollText.getSavePath() == null){
						scrollText.setSavePath(openAndSave.saveAs());
						System.out.println(scrollText.getSavePath());
					}else{
						openAndSave.save(scrollText.getSavePath());
					}
				}
			}
		}

		if(e.getSource() == this.gui.getToolBar().getSaveAs()){
			if(tabbedPane != null){
				openAndSave.saveAs();
			}
		}

		if(e.getSource() == this.gui.getToolBar().getOpen()){	
			openAndSave.openFileInTab();
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
		}

		if(e.getSource() == this.gui.getToolBar().getPrint()){	
			openAndSave.print();
		}
	}
	
	/**
	 * Get the GUI of the Application
	 * @return the GUI of the Application
	 */
	public GUI getGui() {
		return gui;
	}
}