package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTabbedPane;

import view.ButtonTab;

/**
 * This listener will make the TabbedPane closable by click and by shortcut(CTRL + W)
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class ClosableTabListener extends KeyAdapter implements ActionListener {
	
	/**
	 * This is the TabbedPane where the tabs will be add and remove
	 */
	JTabbedPane tabbedPane;
	/**
	 * This is the type that we will add at the tab to add a close button
	 */
	ButtonTab button;
	
	/**
	 * This is the constructor, it initializes the attributes
	 * @param tabbedPane The Tabbed Pane were add the tab
	 * @param button The close Button
	 */
	public ClosableTabListener(JTabbedPane tabbedPane, ButtonTab button){
		if(tabbedPane != null){
			this.tabbedPane = tabbedPane;
		}
		if(button != null){
			this.button = button;
		}
	}
	
	/**
	 * This is the second constructor (for shortcut) then it doesn't need button
	 * @param tabbedPane The Tabbed Pane were add the tab
	 */
	public ClosableTabListener(JTabbedPane tabbedPane){
		if(tabbedPane != null){
			this.tabbedPane = tabbedPane;
		}
	}
	
	/**
	 * This is the implemented method from the ActionListener interface
	 * The action to do if the button close is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		tabbedPane.remove(tabbedPane.indexOfTabComponent(button));
	}
	
	/**
	 * This is the extends method from the KeyAdapter class
	 * It will close the selected tab when you press CTRL + W
	 */
	public void keyPressed(KeyEvent evt) {
		if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_W) {
			tabbedPane.remove(this.tabbedPane.getSelectedIndex());
		}
	}

}