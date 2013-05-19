package ch.laiw.matcho.gui;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import ch.laiw.matcho.domain.Field;
import ch.laiw.matcho.domain.Schedule;

public class ScheduleTableModel extends AbstractTableModel implements TableModelListener {

	private DateFormat dateFormat = DateFormat.getInstance();
	private Calendar calendar = Calendar.getInstance();
	private ArrayList<Field> fieldList;
	private ArrayList<Date> dateList;
	private Schedule schedule;

	public ScheduleTableModel() {
		calendar.set(2011, 4, 28, 9, 0);
		fieldList = new ArrayList<Field>();

		dateList = new ArrayList<Date>();
		schedule = new Schedule(fieldList, dateList);
	}

	public ScheduleTableModel(ArrayList<Date> dateList, ArrayList<Field> fieldList) {
		calendar.set(2011, 4, 28, 9, 0);
		this.fieldList = fieldList;
		this.dateList = dateList;
		this.schedule = new Schedule(fieldList, dateList);
	}

	public ScheduleTableModel(Schedule schedule) {
		this.fieldList = schedule.getFieldList();
		this.dateList = schedule.getDateList();
		// TODO: fill complete table
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Time";
		default:
			return fieldList.get(column - 1).getFieldIdentifier();
		}
	}

	@Override
	public int getRowCount() {
		return dateList.size() + 1;
	}

	@Override
	public int getColumnCount() {
		return fieldList.size() + 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex < getRowCount() - 1) {
			switch (columnIndex) {
			case 0:
				return dateList.get(rowIndex);
			default:
				Date date = dateList.get(rowIndex);
				Field field = fieldList.get(rowIndex);
				return schedule.getMatch(date, field);
			}
		} else {
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return (column == 0);
	}

	@Override
	public Class getColumnClass(int column) {
		switch (column) {
		case 0:
			return Date.class;
		default:
			return Object.class;
		}
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
		switch (column) {
		case 0:
			Date date;
			try {
				date = dateFormat.parse((String) value);
				dateList.set(row, date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:

		}
		// check if the last row is modified
		if (row == dateList.size() - 1) {
			if (isRowEmpty(row)) {
				// don't do anything
			} else {
				dateList.add(new Date());
			}
			// if the current row is not the last row and the row has been emptied, remove it from the table
		} else {
			if (isRowEmpty(row)) {
				dateList.remove(row);
			} else {
				// don't do anything
			}
		}
	}

	private boolean isRowEmpty(int rowIndex) {
		return ((dateList.get(rowIndex) == null));
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		fireTableStructureChanged();
	}

}
