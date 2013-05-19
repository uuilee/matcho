package ch.laiw.matcho.gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ch.laiw.matcho.domain.Participant;
import ch.laiw.matcho.domain.SingleParticipant;

public class ParticipantTableModel extends AbstractTableModel {

	private String[] columnNames = { "First Name", "Last Name", "Singles", "Doubles", "Games", "Score" };
	private ArrayList<Participant> participantList;
	private Participant lastRow;

	public ParticipantTableModel() {
		participantList = new ArrayList<Participant>();
		lastRow = new SingleParticipant();
	}

	public ParticipantTableModel(ArrayList<Participant> participantList) {
		this.participantList = participantList;
		lastRow = new SingleParticipant();
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public int getRowCount() {
		return participantList.size() + 1;
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
				return participantList.get(rowIndex).getFirstName();
			case 1:
				return participantList.get(rowIndex).getLastName();
			case 2:
				return "0";
			case 3:
				return "0";
			default:
				return null;
			}
		} else {
			switch (columnIndex) {
			case 0:
				return lastRow.getFirstName();
			case 1:
				return lastRow.getLastName();
			case 2:
				return "0";
			case 3:
				return "0";
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
		case 1:
			return String.class;
		case 2:

		case 3:

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
				String firstName = ((String) value).trim();
				lastRow.setFirstName(firstName);
				break;
			case 1:
				String lastName = ((String) value).trim();
				lastRow.setLastName(lastName);
				break;
			case 2:

			case 3:

			default:

			}
			if (isRowEmpty(row)) {
				// don't do anything
			} else {
				participantList.add(lastRow);
				lastRow = new SingleParticipant();
			}
			// if the current row is not the last row and the row has been emptied, remove it from the table
		} else {
			switch (column) {
			case 0:
				String firstName = ((String) value).trim();
				participantList.get(row).setFirstName(firstName);
				break;
			case 1:
				String lastName = ((String) value).trim();
				participantList.get(row).setLastName(lastName);
				break;
			case 2:

			case 3:

			default:

			}
			if (isRowEmpty(row)) {
				participantList.remove(row);
			} else {
				// don't do anything
			}
		}
	}

	private boolean isRowEmpty(int rowIndex) {
		if (rowIndex < getRowCount() - 1) {
			return ((participantList.get(rowIndex).getFirstName() == null || participantList.get(rowIndex).getFirstName().trim().equals("")) && (participantList
					.get(rowIndex).getLastName() == null || participantList.get(rowIndex).getLastName().trim().equals("")));
		} else {
			return ((lastRow.getFirstName() == null || lastRow.getFirstName().trim().equals("")) && (lastRow.getLastName() == null || lastRow.getLastName()
					.trim().equals("")));
		}
	}
}
