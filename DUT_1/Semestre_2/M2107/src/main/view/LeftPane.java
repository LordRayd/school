package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EtchedBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import controller.TreeListener;

/**
 * 
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class LeftPane extends JScrollPane {

	/**
	 * The JTree for this JScrollPane (main element)
	 */
	private JTree tree;
	/**
	 * The GUI where this element is add
	 */
	private GUI frame;
	/**
	 * This is the TreeListener that will add Tab when we double-click on an element
	 */
	private TreeListener treeListener;
	/**
	 * This is node for the JTree (the name of the tree)
	 */
	private DefaultMutableTreeNode nameTree;
	/**
	 * This is the node for the Table element
	 */
	private DefaultMutableTreeNode table;
	/**
	 * This is the node for the View element
	 */
	private DefaultMutableTreeNode view;
	/**
	 * This is the node for the Trigger element
	 */
	private DefaultMutableTreeNode trigger;
	
	
	/**
	 * This is the constructor it only call initComponent and add border
	 * @param frame the frame where will be put this object
	 */
	public LeftPane(GUI frame) {
		this.frame = frame;
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.initComponent();
	}

	/**
	 * This method only implements the components for this class and add them
	 */
	public void initComponent(){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));

		this.nameTree =new DefaultMutableTreeNode("DataBase");
		this.table = new DefaultMutableTreeNode("Table");
		this.view = new DefaultMutableTreeNode("View");
		this.trigger = new DefaultMutableTreeNode("Trigger");

		this.tree = new JTree(nameTree);
		this.nameTree.add(table);
		this.nameTree.add(view);
		this.nameTree.add(trigger);
		
		pane.add(tree);
		this.treeListener = new TreeListener(this.frame,this);
		this.tree.addMouseListener(this.treeListener);
		
		pane.setBackground(Color.WHITE);
		setViewportView(pane);
		setVisible(true);
	}

	/**
	 * This is a getter
	 * @return the JTree of this class
	 */
	public JTree getTree() {
		return tree;
	}
	/**
	 * This is a getter
	 * @return the Listener for the JTree
	 */
	public TreeListener getTreeListener() {
		return treeListener;
	}
	/**
	 * This is a getter
	 * @return the node for the Table
	 */
	public DefaultMutableTreeNode getTable() {
		return table;
	}
	/**
	 * This is a getter
	 * @return the node for the View
	 */
	public DefaultMutableTreeNode getView() {
		return view;
	}
	/**
	 * This is a getter
	 * @return the node for the Trigger
	 */
	public DefaultMutableTreeNode getTrigger() {
		return trigger;
	}
}