package ch.laiw.matcho.application;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;

import ch.laiw.matcho.gui.TournamentApplicationFrame;

public class TournamentApplication {

	// Frame
	JFrame frame;

	/**
	 * This method creates the GUI. Note that Java Swing is not thread-safe,
	 * however JComponents can be composed and modified, as long as they are not
	 * realized.
	 * http://java.sun.com/products/jfc/tsc/articles/threads/threads1.html
	 */
	private void createGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		frame = TournamentApplicationFrame.getInstance();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width / 2, screenSize.height / 2);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);  
	}


	// run the program
	public static void main(String[] args) {
		// Load configuration
		
		// Load static data
		
		// Create GUI
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TournamentApplication tournamentApplication = new TournamentApplication();
				tournamentApplication.createGUI();
			}
		});
	}
}
