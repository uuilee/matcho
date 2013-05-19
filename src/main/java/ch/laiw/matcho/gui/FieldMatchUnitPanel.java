package ch.laiw.matcho.gui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class FieldMatchUnitPanel {

	private JPanel fieldMatchPanel;
	private JTextField txtScore;
	private JTextField txtScore_1;

	public FieldMatchUnitPanel(String fieldId) {
		fieldMatchPanel = new JPanel();
		fieldMatchPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		fieldMatchPanel.setLayout(new BoxLayout(fieldMatchPanel, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		fieldMatchPanel.add(panel);
		
		JLabel lblField = new JLabel(fieldId);
		panel.add(lblField);
		
		JPanel panel_1 = new JPanel();
		fieldMatchPanel.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblParticipant = new JLabel("-");
		lblParticipant.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblParticipant);
		
		JLabel lblParticipant_1 = new JLabel("-");
		lblParticipant_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblParticipant_1);
		
		txtScore = new JTextField();
		txtScore.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore.setText("0");
		panel_1.add(txtScore);
		txtScore.setColumns(5);
		
		txtScore_1 = new JTextField();
		txtScore_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore_1.setText("0");
		panel_1.add(txtScore_1);
		txtScore_1.setColumns(5);
	}
	
	public JPanel getFieldMatchPanel() {
		return fieldMatchPanel;
	}

	public void setFieldMatchPanel(JPanel fieldMatchPanel) {
		this.fieldMatchPanel = fieldMatchPanel;
	}
}
