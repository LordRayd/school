package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import controller.ClosableTabListener;
import controller.ControllerDB;

/**
 * This class is the GUI of All the Application
 * Extends JFrame
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class GUI extends JFrame{

	/**
	 * This is the menubar that will be add in the GUI of the application
	 */
	private MenuBar menuBar;
	/**
	 * This is the toolbar that will be add in the GUI of the application
	 */
	private ToolBar toolBar;
	/**
	 * This is the body of the application (the contentPane without actionbar and toolbar)
	 */
	private JPanel body;
	/**
	 * This is the actionbar that will be add in the GUI of the application
	 */
	private ActionBar actionBar;
	/**
	 * This is the JTabbedPane that will be add in the GUI of the application
	 */
	private JTabbedPane tabbedPane;
	/**
	 * This is the JTree that will be add in the GUI of the application
	 */
	private LeftPane leftPane;
	/**
	 * This is the JPanel with many button that will be add in the GUI of the application
	 */
	private RightPane rightPane;
	/**
	 * This is the JSplitPane between the LeftPane and the JTabbedPane that will be add in the GUI of the application
	 */
	private JSplitPane splitPane1;
	/**
	 * This is the JSplitPane between the RightPane and the JTabbedPane that will be add in the GUI of the application
	 */
	private JSplitPane splitPane2;
	/**
	 * This is the controller for the DataBase
	 */
	private ControllerDB db;

	/**
	 * This is the constructor of the GUI
	 * @param db The Controller for the DataBase
	 */
	public GUI(ControllerDB db){
		this.db =db;
		initComponent();
		initFrame();
		addComponent();
		pack();
		setLocationRelativeTo(null);
	}

	/**
	 * This method will initialize the settings for the Frame 
	 */
	public void initFrame(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Database Editor");
		setLayout(new BorderLayout());
		setResizable(true);
		setJMenuBar(menuBar);
		setPreferredSize(new Dimension(800,600));
		setVisible(true);
	}

	/**
	 * This method will initialize the component for this frame
	 */
	public void initComponent(){
		tabbedPane = new JTabbedPane();
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.addKeyListener(new ClosableTabListener(tabbedPane));
		menuBar = new MenuBar(this);
		toolBar = new ToolBar(this);
		body = new JPanel();
		body.setLayout(new BorderLayout(20,20));
		rightPane = new RightPane(this);
		actionBar = new ActionBar(this);
		leftPane = new LeftPane(this);

		//Create a split pane with the two scroll panes in it.
		splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPane, tabbedPane);
		splitPane1.setResizeWeight(0);
		splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane1, rightPane);
		splitPane2.setResizeWeight(1);
	}

	/**
	 * This method will add component in the Frame
	 */
	public void addComponent(){
		body.add(splitPane2, BorderLayout.CENTER);
		add(toolBar, BorderLayout.NORTH);
		add(body, BorderLayout.CENTER);
		add(actionBar, BorderLayout.SOUTH);
	}

	/**
	 * This is a getter
	 * @return The ToolBar of the Application
	 */
	public ToolBar getToolBar() {
		return toolBar;
	}
	/**
	 * This is a getter
	 * @return the ActionBar of the GUI
	 */
	public ActionBar getActionBar() {
		return actionBar;
	}
	/**
	 * This is a getter
	 * @return the JTabbedPane of the GUI
	 */
	public JTabbedPane getTabbedPane(){
		return tabbedPane;
	}
	/**
	 * This is a getter 
	 * @return the JTree of the GUI
	 */
	public LeftPane getLeftPane() {
		return this.leftPane;
	}
	/**
	 * This is a getter
	 * @return the RightPane of the GUI (pane of Button)
	 */
	public RightPane getRightPane() {
		return rightPane;
	}
	/**
	 * This is a getter
	 * @return the Controller of the DataBase
	 */
	public ControllerDB getDb() {
		return db;
	}
}
