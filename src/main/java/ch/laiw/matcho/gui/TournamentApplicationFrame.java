package ch.laiw.matcho.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TournamentApplicationFrame {

	private static JFrame tournamentApplicationFrame;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static synchronized JFrame getInstance() {
		if (tournamentApplicationFrame == null) {
			tournamentApplicationFrame = new JFrame();
			configureFrame(getInstance());
			createMenu(getInstance());
			createTabbedPane(getInstance());
			//createTable(swingInstance);
		}
		return tournamentApplicationFrame;
	}

	// Menu bar
	private static JMenuBar menuBar;
	private static JMenu tournament, edit, extras, help;
	private static JMenuItem fileNew, fileOpen, fileClose, fileSave, fileSaveAs, filePrint, fileImport, fileExport, fileExit;
	private static JMenuItem editCut, editCopy, editPaste, editSearch;
	private static JMenuItem extrasPreferences;
	private static JMenuItem helpHelp, helpAbout;
	private static JMenuItem fileNewMenuTournament;

	private TournamentApplicationFrame() {

	}

	private static void configureFrame(JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("ProScore");
	}

	private static void createMenu(JFrame frame) {
		menuBar = new JMenuBar();
		tournament = new JMenu("Tournament");
		tournament.setMnemonic(KeyEvent.VK_T);
		tournament.getAccessibleContext().setAccessibleDescription("File menu");
		fileNew = new JMenuItem("New...", KeyEvent.VK_N);
		fileNew.addActionListener(new NewFileListener());
		fileOpen = new JMenuItem("Open...", KeyEvent.VK_O);
		fileClose = new JMenuItem("Close", KeyEvent.VK_C);
		fileSave = new JMenuItem("Save", KeyEvent.VK_S);
		fileSaveAs = new JMenuItem("Save As...");
		filePrint = new JMenuItem("Print...", KeyEvent.VK_P);
		fileImport = new JMenuItem("Import...", KeyEvent.VK_I);
		fileExport = new JMenuItem("Export...", KeyEvent.VK_E);
		fileExit = new JMenuItem("Exit");
		tournament.add(fileNew);
		tournament.add(fileOpen);
		tournament.addSeparator();
		tournament.add(fileClose);
		tournament.addSeparator();
		tournament.add(fileSave);
		tournament.add(fileSaveAs);
		tournament.addSeparator();
		tournament.add(filePrint);
		tournament.addSeparator();
		tournament.add(fileImport);
		tournament.add(fileExport);
		tournament.addSeparator();
		tournament.add(fileExit);

		edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		edit.getAccessibleContext().setAccessibleDescription("Edit menu");
		editCut = new JMenuItem("Cut", KeyEvent.VK_X);
		editCopy = new JMenuItem("Copy", KeyEvent.VK_C);
		editPaste = new JMenuItem("Paste", KeyEvent.VK_P);
		editSearch = new JMenuItem("Search...", KeyEvent.VK_S);
		edit.add(editCut);
		edit.add(editCopy);
		edit.add(editPaste);
		edit.addSeparator();
		edit.add(editSearch);

		extras = new JMenu("Extras");
		extras.setMnemonic(KeyEvent.VK_X);
		extras.getAccessibleContext().setAccessibleDescription("Extras menu");
		extrasPreferences = new JMenuItem("Preferences", KeyEvent.VK_P);
		extras.add(extrasPreferences);

		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		help.getAccessibleContext().setAccessibleDescription("Help menu");
		helpHelp = new JMenuItem("Help", KeyEvent.VK_H);
		helpAbout = new JMenuItem("About", KeyEvent.VK_A);
		helpAbout.addActionListener(new HelpAboutListener());
		help.add(helpHelp);
		help.addSeparator();
		help.add(helpAbout);

		menuBar.add(tournament);
		menuBar.add(edit);
		menuBar.add(extras);
		menuBar.add(help);

		frame.setJMenuBar(menuBar);
	}

	private static JScrollPane createTable() {
		String[] columnNames = { "First Name", "Last Name", "Sport", "Score", "Rank" };

		Object[][] data = { { "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) }, { "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) }, { "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) } };

		JTable table = new JTable(5, 10);
		//		JTableHeader tableHeader = new J
		//		table.getTableHeader().set
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		return scrollPane;
	}

	private static void createTabbedPane(JFrame frame) {
//		JTabbedPane tabbedPane = new JTabbedPane();
		
//		JPanel overviewPanel = new JPanel();
//		
//		ParticipantPanel.setModel(new ParticipantTableModel(participantList));
//		JPanel participantPanel = ParticipantPanel.getInstance();
//		
//		GroupPanel.setModel(new GroupTableModel(groupList));
//		JPanel groupPanel = GroupPanel.getInstance();
//		
//		FieldPanel.setModel(new FieldTableModel(fieldList));
//		JPanel fieldPanel = FieldPanel.getInstance();
//		
//		SchedulePanel.setModel(new ScheduleTableModel(dateList, fieldList));
//		JPanel schedulePanel = SchedulePanel.getInstance();
//
//		tabbedPane.setTabPlacement(JTabbedPane.LEFT);
//
//		tabbedPane.addTab("Overview", overviewPanel);
//		tabbedPane.add("Participants", participantPanel);
//		tabbedPane.add("Groups", groupPanel);
//		tabbedPane.add("Fields", fieldPanel);
//		tabbedPane.add("Schedule", schedulePanel);

	}

	// Listeners
	private static class HelpAboutListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JDialog aboutFrame = AboutJDialog.getSwingInstance();
			aboutFrame.setLocationRelativeTo(tournamentApplicationFrame);
			aboutFrame.setVisible(true);
		}

	}
	
	private static class NewFileListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			NewTournamentFrame.setTournamentApplicationFrame(tournamentApplicationFrame);
			JFrame newTournamentFrame = NewTournamentFrame.getInstance();
			newTournamentFrame.setSize(400, 300);
			newTournamentFrame.setLocationRelativeTo(tournamentApplicationFrame);
			newTournamentFrame.setVisible(true);
		}

	}
	
	private static class ImportListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			NewTournamentFrame.setTournamentApplicationFrame(tournamentApplicationFrame);
			JFrame newTournamentFrame = NewTournamentFrame.getInstance();
			newTournamentFrame.setSize(400, 300);
			newTournamentFrame.setLocationRelativeTo(tournamentApplicationFrame);
			newTournamentFrame.setVisible(true);
		}

	}

	
}
