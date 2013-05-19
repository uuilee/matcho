package ch.laiw.matcho.gui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class ParticipantTablePopupMenu {
	private static JPopupMenu swingInstance;
	
	public static synchronized JPopupMenu getSwingInstance() {
		if (swingInstance == null) {
			swingInstance = new JPopupMenu();
			JMenuItem newParticipant = new JMenuItem("New Participant");
			JMenuItem deleteParticipant = new JMenuItem("Delete Participant");
			swingInstance.add(newParticipant);
			swingInstance.add(deleteParticipant);
		}
		return swingInstance;
	}

}