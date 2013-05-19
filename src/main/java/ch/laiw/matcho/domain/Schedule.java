package ch.laiw.matcho.domain;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import util.StringUtilities;

public class Schedule {

	private final Map<Date, Map<Field, Match>> schedule;
	private final ArrayList<Field> fieldList;
	private final ArrayList<Date> dateList;

	public Schedule(Collection<Field> fieldList, Collection<Date> dateList) {
		this.fieldList = new ArrayList<Field>(fieldList);
		this.dateList = new ArrayList<Date>(dateList);
		Collections.sort(this.fieldList);
		Collections.sort(this.dateList);

		this.schedule = new HashMap<Date, Map<Field, Match>>();
		for (Date date : this.dateList) {
			Map<Field, Match> coincidentMatches = new HashMap<Field, Match>();
			for (Field field : this.fieldList) {
				coincidentMatches.put(field, null);
			}
			this.schedule.put(date, coincidentMatches);
		}
	}

	public Schedule(Schedule schedule) {
		this.schedule = new HashMap<Date, Map<Field, Match>>();
		for (Entry<Date, Map<Field, Match>> coincidentMatches : schedule.getSchedule().entrySet()) {
			Map<Field, Match> copyCoincidentMatches = new HashMap<Field, Match>();
			this.schedule.put(new Date(coincidentMatches.getKey().getTime()), copyCoincidentMatches);
			for (Entry<Field, Match> matches : coincidentMatches.getValue().entrySet()) {
				copyCoincidentMatches.put(matches.getKey(), matches.getValue());
			}
		}
		this.fieldList = schedule.fieldList;
		this.dateList = schedule.dateList;
	}

	public void addMatch(Match match) {
		for (Date date : dateList) {
			for (Field field : fieldList) {
				if (schedule.get(date).get(field) == null) {
					schedule.get(date).put(field, match);
					match.setField(field);
					match.setStartDate(date);
					return;
				}
			}
		}
	}

	public void addMatch(Match match, Date date, Field field) {
		if (schedule.get(date) != null) {
			if (schedule.get(date).get(field) != null) {
				schedule.get(date).put(field, match);
			}
		}
	}

	public Match getMatch(Date date, Field field) {
		return schedule.get(date).get(field);
	}

	public Map<Date, Map<Field, Match>> getSchedule() {
		return schedule;
	}

	//	public boolean canContinueOnNextDate() {
	//		dateList.size();
	//		fieldList.size();
	//		schedule.
	//		boolean result
	//	}
	//	
	//	public int


	public ArrayList<Field> getFieldList() {
		return fieldList;
	}

	public ArrayList<Date> getDateList() {
		return dateList;
	}
	
	public String getCSV() {
		DateFormat dateFormat = DateFormat.getInstance();
		StringBuilder result = new StringBuilder();
		ArrayList<Date> sortedDateList = dateList;
		ArrayList<Field> sortedFieldList = fieldList;
		
	
				result.append(";");
				for (Field field : sortedFieldList) {
					result.append(field.getFieldIdentifier());
					result.append(";");
				}
				result.append("\n");
				
				for (Date date : sortedDateList) {
					result.append(dateFormat.format(date));
					result.append(";");
					for (Field field : sortedFieldList) {
						result.append(schedule.get(date).get(field) != null ? schedule.get(date).get(field).getVS() : "");
						result.append(";");
					}
					result.append("\n");
				}
		return result.toString();
	}
	
	@Override
	public String toString() {
		DateFormat dateFormat = DateFormat.getInstance();
		StringBuilder result = new StringBuilder();
		ArrayList<Date> sortedDateList = dateList;
		ArrayList<Field> sortedFieldList = fieldList;
		for (int i = -1; i < sortedDateList.size(); ++i) {
			if (i < 0) {
				for (int j = -1; j < sortedFieldList.size(); ++j) {
					if (j < 0) {
						result.append("---------------|");
					} else {
						result.append("---------------------|");
					}

				}
				result.append("\n");
				for (int j = -1; j < sortedFieldList.size(); ++j) {
					if (j < 0) {
						result.append("               |");
					} else {
						result.append(StringUtilities.cutAndFillString(sortedFieldList.get(j).getFieldIdentifier(), 20) + " |");
					}
				}
				result.append("\n");
				for (int j = -1; j < sortedFieldList.size(); ++j) {
					if (j < 0) {
						result.append("---------------|");
					} else {
						result.append("---------------------|");
					}
				}
				result.append("\n");
			} else {
				for (int j = -1; j < sortedFieldList.size(); ++j) {
					if (j < 0) {
						result.append(StringUtilities.cutAndFillString(dateFormat.format(sortedDateList.get(i)), 14) + " |");
					} else {
						result.append(StringUtilities.cutAndFillString(
								schedule.get(sortedDateList.get(i)).get(sortedFieldList.get(j)) != null ? schedule.get(sortedDateList.get(i))
										.get(sortedFieldList.get(j)).toString() : "", 20)
								+ " |");
					}
				}
				result.append("\n");
				for (int j = -1; j < sortedFieldList.size(); ++j) {
					if (j < 0) {
						result.append("---------------|");
					} else {
						result.append("---------------------|");
					}
				}
				result.append("\n");
			}
		}

		return result.toString();
	}
}
