package ch.laiw.matcho.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GroupPanel {

	private static JPanel groupPanel;
	private static JTable groupTable;
	
	public static synchronized JPanel getInstance() {
		if (groupTable == null) {
			createTable();
		}
		if (groupPanel == null) {
			createPanel();
		}
		return groupPanel;
	}
	
	private static void createTable() {
		groupTable = new JTable(new GroupTableModel());
	}
	
	private static void createPanel() {
		groupPanel = new JPanel();
		groupPanel.setLayout(new GridLayout(1, 2));
		JScrollPane groupScrollPane = new JScrollPane(groupTable);
		groupPanel.add(groupScrollPane);
	}
	
	public static synchronized void setModel(GroupTableModel model) {
		if (groupTable == null) {
			createTable();
		}
		groupTable.setModel(model);
	}
	
}
