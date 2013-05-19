package ch.laiw.matcho.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import ch.laiw.matcho.domain.Field;
import ch.laiw.matcho.domain.Group;
import ch.laiw.matcho.domain.Participant;
import ch.laiw.matcho.domain.TournamentCategories;
import ch.laiw.matcho.domain.TournamentMode;
import ch.laiw.matcho.domain.TournamentDiscipline;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JList;

public class NewTournamentFrame {

	private static ArrayList<Participant> participantList;
	private static ArrayList<Group> groupList;
	private static ArrayList<Field> fieldList;
	private static ArrayList<Date> dateList;

	private static JFrame newTournamentFrame;
	private static JFrame tournamentApplicationFrame;

	private static JSeparator tournamentSeparator;

	private static JTextField textFieldName;
	private static JLabel lblName;
	private static JLabel lblDiscipline;
	private static JComboBox comboBoxDiscipline;
	private static JLabel lblMode;
	private static JComboBox comboBoxMode;
	private static DefaultComboBoxModel comboBoxModelMode;
	private static JList listCategories;
	private static DefaultListModel listModelCategories;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame getInstance() {
		if (newTournamentFrame == null) {
			newTournamentFrame = new JFrame();
			newTournamentFrame.setTitle("New Tournament");
			newTournamentFrame.setResizable(false);			
			
			JPanel bottomPanel = new JPanel();
			newTournamentFrame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
			
			JButton btnOk = new JButton("Ok");
			btnOk.addActionListener(new OkListener());
			bottomPanel.add(btnOk);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new CancelListener());
			bottomPanel.add(btnCancel);
			
			JPanel bodyPanel = new JPanel();
			newTournamentFrame.getContentPane().add(bodyPanel, BorderLayout.CENTER);
			bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
			
			JPanel panelDetails = new JPanel();
			bodyPanel.add(panelDetails);
			panelDetails.setLayout(new BorderLayout(0, 0));
			
			JLabel lblTournamentDetails = new JLabel("Tournament Details");
			panelDetails.add(lblTournamentDetails, BorderLayout.NORTH);
			
			JPanel panelDetailsBody = new JPanel();
			panelDetails.add(panelDetailsBody, BorderLayout.CENTER);
			
			lblName = new JLabel("Name");
			textFieldName = new JTextField();
			textFieldName.setColumns(25);
			lblDiscipline = new JLabel("Discipline");
			comboBoxDiscipline = new JComboBox();
			for (String type : TournamentDiscipline.getTournamentDisciplineList()) {
				comboBoxDiscipline.addItem(type);
			}
			comboBoxDiscipline.addActionListener(new TournamentDisciplineListener());
			comboBoxDiscipline.addActionListener(new TournamentDisciplineListener());
			
			lblMode = new JLabel("Mode");
			comboBoxModelMode = new DefaultComboBoxModel();
			comboBoxMode = new JComboBox(comboBoxModelMode);
			
			
			GroupLayout gl_panelDetailsBody = new GroupLayout(panelDetailsBody);
			gl_panelDetailsBody.setHorizontalGroup(
				gl_panelDetailsBody.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelDetailsBody.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelDetailsBody.createParallelGroup(Alignment.LEADING)
							.addComponent(lblName)
							.addComponent(lblDiscipline)
							.addComponent(lblMode))
						.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
						.addGroup(gl_panelDetailsBody.createParallelGroup(Alignment.LEADING, false)
							.addComponent(comboBoxMode, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboBoxDiscipline, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textFieldName))
						.addContainerGap())
			);
			gl_panelDetailsBody.setVerticalGroup(
				gl_panelDetailsBody.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelDetailsBody.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelDetailsBody.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblName)
							.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelDetailsBody.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBoxDiscipline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblDiscipline))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelDetailsBody.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBoxMode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblMode))
						.addContainerGap(69, Short.MAX_VALUE))
			);
			panelDetailsBody.setLayout(gl_panelDetailsBody);
			
			JPanel panelCategories = new JPanel();
			bodyPanel.add(panelCategories);
			panelCategories.setLayout(new BorderLayout(0, 0));
			
			JLabel lblTournamentCategories = new JLabel("Tournament Categories");
			panelCategories.add(lblTournamentCategories, BorderLayout.NORTH);
			
			JPanel panelCategoriesBody = new JPanel();
			panelCategories.add(panelCategoriesBody, BorderLayout.CENTER);
			panelCategoriesBody.setLayout(new GridLayout(1,1));
			
			listModelCategories = new DefaultListModel();
			listCategories = new JList(listModelCategories);
			listCategories.setVisibleRowCount(5);
			panelCategoriesBody.add(listCategories);
			comboBoxDiscipline.setSelectedIndex(0);
		}
		return newTournamentFrame;
	}
	
	private static class OkListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Get names and selected fields
			String tournamentName = textFieldName.getText();
			String tournamentDiscipline = comboBoxDiscipline.getSelectedItem().toString();
			String tournamentMode = comboBoxMode.getSelectedItem().toString();
			
			participantList = new ArrayList<Participant>();
			groupList = new ArrayList<Group>();
			fieldList = new ArrayList<Field>();
			dateList = new ArrayList<Date>();
			

			
			JTabbedPane tabbedPane = new JTabbedPane();
			tabbedPane.setTabPlacement(JTabbedPane.LEFT);
			
			JPanel overviewPanel = new JPanel();
			
			ParticipantPanel.setModel(new ParticipantTableModel(participantList));
			JPanel participantPanel = ParticipantPanel.getInstance();
			JPanel groupPanel = GroupPanel.getInstance();
			GroupPanel.setModel(new GroupTableModel(groupList));
			JPanel fieldPanel = FieldPanel.getInstance();
			FieldTableModel fieldTableModel = new FieldTableModel(fieldList);
			FieldPanel.setModel(fieldTableModel);
			
			tabbedPane.addTab("Overview", overviewPanel);
			tabbedPane.add("Participants", participantPanel);
			tabbedPane.add("Groups", groupPanel);
			tabbedPane.add("Fields", fieldPanel);
			
			if (TournamentMode.SCHOCH.equals(tournamentMode)) {
				JPanel matchPanel = FieldMatchPanel.getInstance();
				tabbedPane.add("Matches", matchPanel);
				fieldTableModel.addTableModelListener(FieldMatchPanel.getTableModelListener());
			} else if (TournamentMode.GROUP.equals(tournamentMode)) {
				JPanel schedulePanel = SchedulePanel.getInstance();
				ScheduleTableModel scheduleTableModel = new ScheduleTableModel(dateList, fieldList);
				SchedulePanel.setModel(scheduleTableModel);
				fieldTableModel.addTableModelListener(scheduleTableModel);
				tabbedPane.add("Schedule", schedulePanel);
			}
			
			tournamentApplicationFrame.getContentPane().add(tabbedPane);
			tournamentApplicationFrame.validate();
			newTournamentFrame.dispose();
			//
		}
	}

	private static class CancelListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			newTournamentFrame.dispose();
		}
	}

	private static class TournamentDisciplineListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String discipline = comboBoxDiscipline.getSelectedItem().toString();
			comboBoxModelMode.removeAllElements();
			for (String mode : TournamentMode.getTournamentMode(discipline)) {
				comboBoxModelMode.addElement(mode);
			}
			listModelCategories.removeAllElements();
			for (String category : TournamentCategories.getTournamentCategories(discipline)) {
				listModelCategories.addElement(category);
			}
		}
	}
	
	public static JFrame getTournamentApplicationFrame() {
		return tournamentApplicationFrame;
	}

	public static void setTournamentApplicationFrame(JFrame tournamentApplicationFrame) {
		NewTournamentFrame.tournamentApplicationFrame = tournamentApplicationFrame;
	}
}
