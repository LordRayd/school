package model;

import java.awt.Dimension;
import java.awt.print.PrinterException;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ClosableTabListener;
import controller.MenuBarListener;
import controller.ToolBarListener;
import view.ButtonTab;
import view.GUI;
import view.JScrollPaneToSave;

/**
 * This class will be used to save, open, print, make new etc...
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class OpenAndSave {

	/**
	 * This is the GUI of the application
	 */
	private GUI gui;
	/**
	 * This is the JTabbedPane where the tabs will be put
	 */
	private JTabbedPane tabbedPane;
	/**
	 * This String will make the currentPath to store where the user had saved his files
	 */
	private String currentPath;

	/**
	 * This is the constructor, it initialize the attribute with the toolBar in parameter
	 * @param toolBar the toolBarListener where the class is used
	 */
	public OpenAndSave(ToolBarListener toolBar){
		if(toolBar != null){
			this.gui = toolBar.getGui();
			this.tabbedPane = this.gui.getTabbedPane();
		}
		currentPath = ".";
	}

	/**
	 * This is the constructor, it initialize the attribute with the menuBar in parameter
	 * @param menuBar the MenuBarListener where this class is used
	 */
	public OpenAndSave(MenuBarListener menuBar){
		if(menuBar != null){
			this.gui = menuBar.getFrame();
			this.tabbedPane = this.gui.getTabbedPane();
		}
		currentPath = ".";
	}

	/**
	 * This procedure will be used to make new Tabs from file
	 */
	public void openFileInTab(){
		File path = openFileChooser();
		if(path != null){
			String title = path.getName().split("[.]")[0];
			if(tabbedPane.indexOfTab(title) == -1){
				makeTextPaneTab(title);
				JScrollPaneToSave scrollText =  (JScrollPaneToSave)tabbedPane.getComponentAt(tabbedPane.indexOfTab(title));
				scrollText.setSavePath(path.toString());
				JTextPane textPane = (JTextPane)scrollText.getViewport().getView();
				textPane.setText(RWFile.readFile(path.toString()));
				currentPath = path.getParent();
				gui.getActionBar().getAction().setText("Ouvert");
			}
		}
	}

	/**
	 * This method will make a new tab in the JTabbedPane with JTextPane for Component
	 * @param title the name for the Tab
	 */
	public void makeTextPaneTab(String title){
		JScrollPaneToSave scrollText = new JScrollPaneToSave();
		JTextPane pane = new JTextPane();
		pane.setPreferredSize(new Dimension(tabbedPane.getSize()));
		// /!\/!\/!\/!\/!\/!\/!\/!\/!\/!\/!\Voir pour changer le nom avec l'enregistrement /!\/!\/!\/!\/!\/!\/!\/!\/!\	
		scrollText.setViewportView(pane);
		scrollText.setVerticalScrollBarPolicy(JScrollPaneToSave.VERTICAL_SCROLLBAR_ALWAYS);
		scrollText.setHorizontalScrollBarPolicy(JScrollPaneToSave.HORIZONTAL_SCROLLBAR_ALWAYS);
		tabbedPane.add(title, scrollText);
		tabbedPane.setTabComponentAt(tabbedPane.indexOfTab(title), new ButtonTab(tabbedPane, title));
		pane.addKeyListener(new ClosableTabListener(tabbedPane));
		tabbedPane.requestFocus();
	}

	/**
	 * This procedure will be used to change the name of the tab (when we save a tab in another path for example)
	 * @param title the title to put
	 */
	public void changeTitleTab(String title){
		if(tabbedPane != null){
			if(title != null){
				if(tabbedPane.indexOfTab(title) == -1){
					tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), title);
					tabbedPane.setTabComponentAt(tabbedPane.indexOfTab(title), new ButtonTab(tabbedPane, title));

				}else if(!tabbedPane.getTitleAt(tabbedPane.getSelectedIndex()).equals(title)){
					tabbedPane.remove(tabbedPane.indexOfTab(title));
					tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), title);
					tabbedPane.setTabComponentAt(tabbedPane.indexOfTab(title), new ButtonTab(tabbedPane, title));

				}
			}
		}
	}

	/**
	 * This method will save the content of a tab, it will only save it in the currentPath set in the JScrollPaneToSave
	 * @param path The path were we will save the text
	 */
	public void save(String path){
		if(path != null){
			if(tabbedPane.getSelectedComponent() instanceof JScrollPaneToSave){
				JScrollPaneToSave scrollText = (JScrollPaneToSave)tabbedPane.getSelectedComponent();
				if(scrollText.getViewport().getView() instanceof JTextPane){
					JTextPane textPane = (JTextPane)scrollText.getViewport().getView();
					RWFile.writeFile(textPane.getText(), path);
					gui.getActionBar().getAction().setText("<html>Fichier &eacute;cras&eacute;</html>");
				}
			}
		}
	}

	/**
	 * This method will open a JFileChooser the save the JScrollPaneToSave, it will ask if the user wants to overwrite if the file already exists
	 * if the currentPath of a JScrollPaneToSave is null the method will be called
	 * @return the new SavePath that will be put in the JScrollPaneToSave
	 */
	public String saveAs(){
		String savePath = null;
		if(tabbedPane.getSelectedComponent() instanceof JScrollPaneToSave){
			JScrollPaneToSave scrollText = (JScrollPaneToSave)tabbedPane.getSelectedComponent();
			if(scrollText.getViewport().getView() instanceof JTextPane){
				JTextPane textPane = (JTextPane)scrollText.getViewport().getView();
				File file = saveFileChooser();
				if(file != null){
					int choice = JOptionPane.NO_OPTION;
					if (file.exists()) {
						choice = JOptionPane.showConfirmDialog(null, "This file already exists, overwrite it?");
						if(file.getName() != null && choice == JOptionPane.YES_OPTION){
							String title = file.getName().split("[.]")[0];
							changeTitleTab(title);
							RWFile.writeFile(textPane.getText(), file.toString());
							gui.getActionBar().getAction().setText("<html>Fichier &eacute;cras&eacute;</html>");
							currentPath = file.getParent();
							savePath = file.toString();
						}

					}else if (!file.exists()){
						if(file.getName() != null){
							String title = file.getName().split("[.]")[0];
							changeTitleTab(title);
							RWFile.writeFile(textPane.getText(), file.toString());
							gui.getActionBar().getAction().setText("<html>Fichier enregistr&eacute;</html>");
							currentPath = file.getParent();
							savePath = file.toString();
						}
					}
				}
			}
		}
		return savePath;
	}

	/**
	 * This method will call the print method in the JTextPane
	 * It will check if the tab is a printable tab and it will change the ActionBar if the print has been made
	 */
	public void print(){
		if(tabbedPane.getSelectedComponent() instanceof JScrollPaneToSave){
			JScrollPaneToSave scrollText = (JScrollPaneToSave)tabbedPane.getSelectedComponent();
			if(scrollText.getViewport().getView() instanceof JTextPane){
				JTextPane textPane = (JTextPane)scrollText.getViewport().getView();
				try{
					boolean printing = textPane.print();
					if(printing){
						gui.getActionBar().getAction().setText("<html>Imprim&eacute;</html>");
					}
				}catch(PrinterException e){
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * This private method call the JFileChooser to open a file as default its set for SQL file
	 * @return the File opened
	 */
	private File openFileChooser(){
		File path = null;
		JFileChooser chooser = new JFileChooser(currentPath);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("SQL", "sql");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(gui);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			if(chooser.getSelectedFile().exists()){
				path = chooser.getSelectedFile();
			}
		}
		return path;
	}

	/**
	 * This private method will call the JFileChooser to save
	 * @return the File where the file is saved
	 */
	private File saveFileChooser(){
		// parent component of the dialog		 
		JFileChooser fileChooser = new JFileChooser(currentPath);
		fileChooser.setDialogTitle("Specify a file to save");   
		File fileToSave = null;
		int userSelection = fileChooser.showSaveDialog(gui);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			fileToSave = fileChooser.getSelectedFile();
		}
		return fileToSave;
	}
}