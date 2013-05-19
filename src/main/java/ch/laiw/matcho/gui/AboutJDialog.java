package ch.laiw.matcho.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class AboutJDialog {

	private static JDialog swingInstance;

	private static JButton closeButton;

	public static synchronized JDialog getSwingInstance() {
		if (swingInstance == null) {
			swingInstance = new JDialog();
			configureDialog(swingInstance);
			createText(swingInstance);
			createButtons(swingInstance);
		}
		return swingInstance;
	}

	private AboutJDialog() {

	}

	private static void configureDialog(JDialog dialog) {
		dialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		dialog.setTitle("About");
		dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
		dialog.setSize(300, 200);
	}

	private static void createText(JDialog dialog) {
		JTextArea aboutText = new JTextArea();
		aboutText.setText("" + "Author: Willy Lai" + "2012");
		dialog.getContentPane().add(aboutText);
	}

	private static void createButtons(final JDialog dialog) {
		closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dialog.setVisible(false);
			}
		});
	}

}
