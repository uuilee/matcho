package ch.laiw.matcho;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ch.laiw.matcho.InvalidScheduleInputException;
import ch.laiw.matcho.PriorityBacktrackScheduleGenerator;
import ch.laiw.matcho.ScheduleGenerationAlgorithm;
import ch.laiw.matcho.domain.Field;
import ch.laiw.matcho.domain.Group;
import ch.laiw.matcho.domain.Participant;
import ch.laiw.matcho.domain.Schedule;
import ch.laiw.matcho.domain.SingleParticipant;
import ch.laiw.matcho.verification.ScheduleVerifier;

public class TestScheduleGeneration {
	
	private static ScheduleVerifier scheduleVerifier;
	private static ScheduleGenerationAlgorithm scheduleGenerator;
	
	// Groups
	private static Group group;
	
	// Doubles
	private static Participant team1;
	private static Participant team2;
	private static Participant team3;
	private static Participant team4;
	private static Participant team5;
	private static Participant team6;
	private static Participant team7;
	private static Participant team8;
	private static Participant team9;
	
	// TODO: Generate test cases for TestScheduleGeneration
	@Before
	public void setUp() throws Exception {
		
		scheduleVerifier = new ScheduleVerifier();
		scheduleGenerator = new PriorityBacktrackScheduleGenerator();
		
		group = new Group("Hobby");
		
		team1 = new SingleParticipant("A");
		team2 = new SingleParticipant("B");
		team3 = new SingleParticipant("C");
		team4 = new SingleParticipant("D");
		team5 = new SingleParticipant("E");
		team6 = new SingleParticipant("F");
		team7 = new SingleParticipant("G");
		team8 = new SingleParticipant("H");
		team9 = new SingleParticipant("I");
	}
	
	@Test
	public void testScheduleGeneration() {
		ArrayList<Field> fieldList = new ArrayList<Field>();
		fieldList.add(new Field("Feld 1"));
		fieldList.add(new Field("Feld 2"));
		
		ArrayList<Participant> participantList = new ArrayList<Participant>();
		participantList.add(team1);
		participantList.add(team2);
		participantList.add(team3);
		participantList.add(team4);
		participantList.add(team5);
		participantList.add(team6);
		participantList.add(team7);
		participantList.add(team8);
		participantList.add(team9);
		
		group.getGroupMemberList().add(team1);
		group.getGroupMemberList().add(team2);
		group.getGroupMemberList().add(team3);
		group.getGroupMemberList().add(team4);
		group.getGroupMemberList().add(team5);
		group.getGroupMemberList().add(team6);
		group.getGroupMemberList().add(team7);
		group.getGroupMemberList().add(team8);
		group.getGroupMemberList().add(team9);
		
		ArrayList<Group> groupList = new ArrayList<Group>();
		groupList.add(group);
		
		Calendar calendar = Calendar.getInstance();
		ArrayList<Date> dateList = new ArrayList<Date>();
		calendar.set(2012, 5, 5, 20, 0, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 5, 20, 20, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 5, 20, 40, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 5, 21, 0, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 5, 21, 20, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 5, 21, 40, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 5, 22, 00, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 5, 22, 20, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 5, 22, 40, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 5, 23, 0, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 5, 23, 20, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 5, 23, 40, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 6, 00, 00, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 6, 00, 20, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 6, 00, 40, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 6, 01, 00, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 6, 01, 20, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 6, 01, 40, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 6, 02, 0, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 6, 02, 20, 0);
		dateList.add(calendar.getTime());
		calendar.set(2012, 5, 6, 02, 40, 0);
		dateList.add(calendar.getTime());
		
		// generate schedule
		try {
			Schedule schedule = scheduleGenerator.generateSchedule(participantList, groupList, false, fieldList, dateList, scheduleVerifier);
			System.out.println(schedule.getCSV());
		} catch (InvalidScheduleInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
