package ch.laiw.matcho.gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ch.laiw.matcho.domain.Field;

public class FieldTableModel extends AbstractTableModel {

	private String[] columnNames = { "Field Name" };
	private ArrayList<Field> fieldList;
	private Field lastRow;

	public FieldTableModel() {
		fieldList = new ArrayList<Field>();
		lastRow = new Field();
	}

	public FieldTableModel(ArrayList<Field> fields) {
		this.fieldList = fields;
		lastRow = new Field();
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public int getRowCount() {
		return fieldList.size() + 1;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex < getRowCount() - 1) {
			switch (columnIndex) {
			case 0:
				return fieldList.get(rowIndex).getFieldIdentifier();
			default:
				return null;
			}
		} else {
			switch (columnIndex) {
			case 0:
				return lastRow.getFieldIdentifier();
			default:
				return null;
			}
		}

	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return (column < 2);
	}

	@Override
	public Class getColumnClass(int column) {
		switch (column) {
		case 0:
			return String.class;
		default:
			return Object.class;
		}
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
		// check if the last row is modified
		if (row == getRowCount() - 1) {
			switch (column) {
			case 0:
				String fieldIdentifier = ((String) value).trim();
				lastRow.setFieldIdentifier(fieldIdentifier);
				break;
			default:

			}
			if (isRowEmpty(row)) {
				// don't do anything
			} else {
				fieldList.add(lastRow);
				lastRow = new Field();
				fireTableDataChanged();
			}
			// if the current row is not the last row and the row has been emptied, remove it from the table
		} else {
			switch (column) {
			case 0:
				String fieldIdentifier = ((String) value).trim();
				fieldList.get(row).setFieldIdentifier(fieldIdentifier);
				break;
			default:

			}
			if (isRowEmpty(row)) {
				fieldList.remove(row);
				fireTableDataChanged();
			} else {
				// don't do anything
			}
		}
	}

	private boolean isRowEmpty(int rowIndex) {
		if (rowIndex < getRowCount() -1) {
			return ((fieldList.get(rowIndex).getFieldIdentifier() == null || fieldList.get(rowIndex).getFieldIdentifier().trim().equals("")));
		} else {
			return ((lastRow.getFieldIdentifier() == null || lastRow.getFieldIdentifier().trim().equals("")));
		}
		
	}
}
