package ch.laiw.matcho.gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ch.laiw.matcho.domain.Group;

public class GroupTableModel extends AbstractTableModel {

	private String[] columnNames = { "Group Name" };
	private ArrayList<Group> groupList;
	private Group lastRow;

	public GroupTableModel() {
		groupList = new ArrayList<Group>();
		lastRow = new Group();
	}

	public GroupTableModel(ArrayList<Group> groupList) {
		this.groupList = groupList;
		lastRow = new Group();
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public int getRowCount() {
		return groupList.size() + 1;
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
				return groupList.get(rowIndex).getGroupName();
			default:
				return null;
			}
		} else {
			return null;
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
			lastRow.setGroupName((String) value);
			if (isRowEmpty(row)) {
				// don't do anything
			} else {
				groupList.add(lastRow);
				lastRow = new Group();
			}
			// if the current row is not the last row and the row has been emptied, remove it from the table
		} else {
			groupList.get(row).setGroupName((String) value);
			if (isRowEmpty(row)) {
				groupList.remove(row);
			} else {
				// don't do anything
			}
		}
	}

	private boolean isRowEmpty(int rowIndex) {
		if (rowIndex < getRowCount() - 1) {
			return ((groupList.get(rowIndex).getGroupName() == null || groupList.get(rowIndex).getGroupName().trim().equals("")));
		} else {
			return ((lastRow.getGroupName() == null || lastRow.getGroupName().trim().equals("")));
		}

	}
}
