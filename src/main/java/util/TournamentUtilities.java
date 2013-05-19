package util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import ch.laiw.matcho.domain.Field;
import ch.laiw.matcho.domain.Group;
import ch.laiw.matcho.domain.Participant;
import ch.laiw.matcho.domain.SingleParticipant;

public class TournamentUtilities {

	public static Collection<Date> generateDates(int startYear, int startMonth, int startDate, int startHourOfDay, int startMinute, int intervalUnit, int interval, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(startYear, startMonth, startDate, startHourOfDay, startMinute);
		ArrayList<Date> result = new ArrayList<Date>();
		for (int i = 0; i < num; ++i) {
			result.add(calendar.getTime());
			calendar.add(intervalUnit, interval);
		}
		return result;
	}

	public static Collection<Participant> generateParticipants(int num) {
		ArrayList<Participant> result = new ArrayList<Participant>();
		for (int i = 0; i < num; ++i) {
			result.add(new SingleParticipant("P" + i));
		}
		return result;
	}
	
	public static Collection<Group> generateGroups(int num) {
		ArrayList<Group> result = new ArrayList<Group>();
		for (int i = 0; i < num; ++i) {
			result.add(new Group("G" + i));
		}
		return result;
	}
	
	public static Collection<Field> generateFields(int num) {
		ArrayList<Field> result = new ArrayList<Field>();
		for (int i = 0; i < num; ++i) {
			result.add(new Field("F" + i));
		}
		return result;
	}
}
