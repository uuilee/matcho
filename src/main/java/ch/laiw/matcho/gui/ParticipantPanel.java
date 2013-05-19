package ch.laiw.matcho.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ParticipantPanel {

	private static JPanel participantPanel;
	private static JTable participantTable;
	
	public static synchronized JPanel getInstance() {
		if (participantTable == null) {
			createTable();
		}
		if (participantPanel == null) {
			createPanel();
		}
		return participantPanel;
	}
	
	private static void createTable() {
		participantTable = new JTable();
	}
	
	private static void createPanel() {
		participantPanel = new JPanel();
		participantPanel.setLayout(new GridLayout(1, 2));
		JScrollPane participantScrollPane = new JScrollPane(participantTable);
		participantPanel.add(participantScrollPane);
		JPanel participantDetailPanel = new JPanel();
		participantPanel.add(participantDetailPanel);
		
//		participantTable.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				if(e.isPopupTrigger()) {
//					System.out.println("clicked");
//					JPopupMenu participantTablePopupMenu = ParticipantTablePopupMenu.getSwingInstance();
//					participantTablePopupMenu.show(e.getComponent().getParent(), e.getX(), e.getY());
//				}
//			}
//		});
		
	}
	
	public static synchronized void setModel(ParticipantTableModel model) {
		if (participantTable == null) {
			createTable();
		}
		participantTable.setModel(model);
	}
	
}
