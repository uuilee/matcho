package ch.laiw.matcho.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FieldPanel {

	private static JPanel fieldPanel;
	private static JTable fieldTable;
	
	public static synchronized JPanel getInstance() {
		if (fieldTable == null) {
			createTable();
		}
		if (fieldPanel == null) {
			createPanel();
		}
		return fieldPanel;
	}
	
	private static void createTable() {
		fieldTable = new JTable();
	}
	
	private static void createPanel() {
		fieldPanel = new JPanel();
		fieldPanel.setLayout(new GridLayout(1, 2));
		JScrollPane fieldScrollPane = new JScrollPane(fieldTable);
		fieldPanel.add(fieldScrollPane);
	}
	
	public static synchronized void setModel(FieldTableModel model) {
		if (fieldTable == null) {
			createTable();
		}
		fieldTable.setModel(model);
	}
	
}
