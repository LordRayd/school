import view.InterfaceGraphique;

public class Launcher {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(
				new Runnable(){
					public void	run(){
						new InterfaceGraphique("Faire le menage");
					}
				}
		);

	}

}
