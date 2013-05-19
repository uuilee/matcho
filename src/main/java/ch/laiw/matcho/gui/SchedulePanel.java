package ch.laiw.matcho.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SchedulePanel {

	private static JPanel schedulePanel;
	private static JTable scheduleTable;
	
	public static synchronized JPanel getInstance() {
		if (scheduleTable == null) {
			createTable();
		}
		if (schedulePanel == null) {
			createPanel();
		}
		return schedulePanel;
	}
	
	private static void createTable() {
		scheduleTable = new JTable();
	}
	
	private static void createPanel() {
		schedulePanel = new JPanel();
		schedulePanel.setLayout(new BorderLayout());
//		JPanel buttonPanel = new JPanel();
//		JButton addColumnButton = new JButton("Add field");
//		JButton anotherButton = new JButton("Another button");
//		JButton yetAnotherButton = new JButton("Yet another button");
//		buttonPanel.add(addColumnButton);
//		buttonPanel.add(anotherButton);
//		buttonPanel.add(yetAnotherButton);
//		schedulePanel.add(buttonPanel, BorderLayout.PAGE_START);
		
		
		JScrollPane scheduleScrollPane = new JScrollPane(scheduleTable);
		schedulePanel.add(scheduleScrollPane, BorderLayout.CENTER);
	}
	
	public static synchronized void setModel(ScheduleTableModel model) {
		if (scheduleTable == null) {
			createTable();
		}
		scheduleTable.setModel(model);
	}
}
