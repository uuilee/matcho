package ch.laiw.matcho.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.ScrollPaneConstants;

import util.WrapLayout;

public class FieldMatchPanel {

	private static JPanel fieldMatchPanel;
	private static JPanel panelField;
	private static JScrollPane scrollPaneField;
	private static JTable table;
	private static JScrollPane scrollPane;

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static synchronized JPanel getInstance() {

		if (fieldMatchPanel == null) {
			fieldMatchPanel = new JPanel();
			fieldMatchPanel.setLayout(new GridLayout(1, 2));
			
			scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			fieldMatchPanel.add(scrollPane);
			
			panelField = new JPanel();
			panelField.setLayout(new WrapLayout(WrapLayout.LEFT));
			scrollPane.setViewportView(panelField);
			
			
			scrollPaneField = new JScrollPane();
			fieldMatchPanel.add(scrollPaneField);
			
			table = new JTable();
			scrollPaneField.setViewportView(table);
		}
		return fieldMatchPanel;
	}

	
	public static synchronized TableModelListener getTableModelListener() {
		return new FieldMatchPanelTableModelListener();
	}
	
	private static class FieldMatchPanelTableModelListener implements TableModelListener {
		@Override
		public void tableChanged(TableModelEvent e) {
			FieldTableModel fieldTableModel = (FieldTableModel) e.getSource();
			getPanelField().removeAll();
			for (int i = 0; i < fieldTableModel.getRowCount() -1; ++i) {
				String fieldId = (String) fieldTableModel.getValueAt(i, 0);
				JPanel fieldMatchUnitPanel = new FieldMatchUnitPanel(fieldId).getFieldMatchPanel();
				fieldMatchUnitPanel.setSize(100, 100);
				getPanelField().add(fieldMatchUnitPanel);
			}
			getPanelField().validate();
		}
		
	}

	public static JPanel getPanelField() {
		return panelField;
	}

	public static JScrollPane getScrollPaneField() {
		return scrollPaneField;
	}

}
