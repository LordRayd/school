package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.RightPaneListener;

/**
 * The Right Panel of the GUI
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class RightPane extends JScrollPane {
	
	/**
	 * This is the GUI where the RightPane will be add
	 */
	private GUI frame;
	/**
	 * This the body Panel for this class
	 */
	private JPanel body;
	/**
	 * This is the JTextField to search word
	 */
	private JTextField researchTF;
	/**
	 * This is the Panel for add and remove table
	 */
	private JPanel panelTable;
	/**
	 * This is the button for add Table
	 */
	private JButton newTable;
	/**
	 * This is the button to remove Table
	 */
	private JButton removeTable;
	/**
	 * This is the panel for the add and remove column
	 */
	private JPanel panelColumn;
	/**
	 * This is the button to add Column
	 */
	private JButton newColumn;
	/**
	 * This is the button to remove column
	 */
	private JButton removeColumn;
	/**
	 * This is the panel for add and remove line
	 */
	private JPanel panelLine;
	/**
	 * This is the button to add Line
	 */
	private JButton addLine;
	/**
	 * This is the button to remove line
	 */
	private JButton removeLine;
	/**
	 * This is the run button
	 */
	private JButton run;
	/**
	 * This is the constraint for the GridBagLayout
	 */
	private GridBagConstraints c;
	
	/**
	 * This is the constructor, it calls initComponent and addComponent
	 * @param frame the frame where the RightPane will be ad
	 */
	public RightPane(GUI frame){
		this.frame = frame;
		initComponent();
		addComponent();
		setViewportView(body);
		setPreferredSize(new Dimension(250, 350));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setViewportBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}
	
	/**
	 * This is the method to remove border in the JScrollPane
	 */
	public void removeBorder(){
		setViewportBorder(null);
	}
	
	/**
	 * This procedure will initialize the component
	 */
	public void initComponent(){
		
		RightPaneListener listener = new RightPaneListener(this.getFrame());
		
		ImageIcon deleteTableIcon = new ImageIcon(new ImageIcon("data/deleteTable.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		ImageIcon addTableIcon = new ImageIcon(new ImageIcon("data/addTable.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		ImageIcon deleteColumnIcon = new ImageIcon(new ImageIcon("data/RemoveColumn.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		ImageIcon addColumnIcon = new ImageIcon(new ImageIcon("data/PlusColumn.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));ImageIcon deleteLineIcon = new ImageIcon(new ImageIcon("data/deleteRow.png").getImage().getScaledInstance(50, 22, Image.SCALE_DEFAULT));
		ImageIcon addLineIcon = new ImageIcon(new ImageIcon("data/addRow.png").getImage().getScaledInstance(50, 22, Image.SCALE_DEFAULT));
		ImageIcon runIcon = new ImageIcon(new ImageIcon("data/RunScript.png").getImage().getScaledInstance(126, 43, Image.SCALE_DEFAULT));
		
		body = new JPanel();
		body.setLayout(new GridBagLayout());
	
		panelTable = new JPanel();
		
		newTable = new JButton(addTableIcon);
		newTable.addActionListener(listener);
		newTable.setToolTipText("Ajouter une table");
		newTable.setContentAreaFilled(false);
		newTable.setBorderPainted(false);

		removeTable = new JButton(deleteTableIcon);
		removeTable.addActionListener(listener);
		removeTable.setToolTipText("Supprimer une table");
		removeTable.setContentAreaFilled(false);
		removeTable.setBorderPainted(false);
	
		panelColumn = new JPanel();

		newColumn = new JButton(addColumnIcon);
		newColumn.addActionListener(listener);
		newColumn.setToolTipText("Ajouter une colonne");
		newColumn.setContentAreaFilled(false);
		newColumn.setBorderPainted(false);

		removeColumn = new JButton(deleteColumnIcon);
		removeColumn.addActionListener(listener);
		removeColumn.setToolTipText("Supprimer une colonne");
		removeColumn.setContentAreaFilled(false);
		removeColumn.setBorderPainted(false);
	
		panelLine = new JPanel();
		
		addLine = new JButton(addLineIcon);
		addLine.addActionListener(listener);
		addLine.setToolTipText("Ajouter une colonne");
		addLine.setContentAreaFilled(false);
		addLine.setBorderPainted(false);

		removeLine = new JButton(deleteLineIcon);
		removeLine.addActionListener(listener);
		removeLine.setToolTipText("Supprimer une colonne");
		removeLine.setContentAreaFilled(false);
		removeLine.setBorderPainted(false);
		
		
		run = new JButton(runIcon);
		run.addActionListener(listener);
		run.setContentAreaFilled(false);
		run.setBorderPainted(false);
	}
	
	/**
	 * This procedure will add the component
	 */
	public void addComponent(){
		
		panelTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE,2), "Table"));
		panelTable.add(newTable);
		panelTable.add(removeTable);
	
		panelColumn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE,2), "Colonne"));
		panelColumn.add(newColumn);
		panelColumn.add(removeColumn);
	
		panelLine.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE,2), "Ligne"));
		panelLine.add(addLine);
		panelLine.add(removeLine);

		this.c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.ipady = 30;
		body.add(panelTable, c);
		body.add(panelColumn, c);
		body.add(panelLine, c);
		c.ipady = 25;
		body.add(run, c);
	}

	/**
	 * This is a getter
	 * @return the Frame where the rightPane is add
	 */
	public GUI getFrame() {
		return frame;
	}
	/**
	 * This is a getter
	 * @return the JTextField for the search
	 */
	public JTextField getResearchTF() {
		return researchTF;
	}
	/**
	 * This is a getter
	 * @return the button to add Table
	 */
	public JButton getNewTable() {
		return newTable;
	}
	/**
	 * This is a getter 
	 * @return the button to remove a table
	 */
	public JButton getRemoveTable() {
		return removeTable;
	}
	/**
	 * This is a getter 
	 * @return the button to add a column
	 */
	public JButton getNewColumn() {
		return newColumn;
	}
	/**
	 * This is a getter 
	 * @return the button to remove a column
	 */
	public JButton getRemoveColumn() {
		return removeColumn;
	}
	/**
	 * This is a getter 
	 * @return the button to add a line
	 */
	public JButton getAddLine() {
		return addLine;
	}
	/**
	 * This is a getter 
	 * @return the button to remove a line
	 */
	public JButton getRemoveLine() {
		return removeLine;
	}
	/**
	 * This is a getter 
	 * @return the button to run a script
	 */
	public JButton getRun() {
		return run;
	}
}