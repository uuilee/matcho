package ch.laiw.matcho;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ch.laiw.matcho.PriorityBacktrackScheduleGenerator;
import ch.laiw.matcho.ScheduleGenerationAlgorithm;
import ch.laiw.matcho.domain.Field;
import ch.laiw.matcho.domain.Group;
import ch.laiw.matcho.domain.Participant;
import ch.laiw.matcho.domain.SingleParticipant;
import ch.laiw.matcho.verification.ScheduleVerifier;

public class TestGroupDraw {

	private static ScheduleVerifier scheduleVerifier;
	private static ScheduleGenerationAlgorithm scheduleGenerator;

	@Before
	public void setUp() {
		// initialize
		scheduleVerifier = new ScheduleVerifier();
		scheduleGenerator = new PriorityBacktrackScheduleGenerator();
	}

	@Test
	public void testGroupingMenSingles() {
		// get participants
		ArrayList<Participant> participantList = new ArrayList<Participant>();
		participantList.add(new SingleParticipant("An Nhiên"));
		participantList.add(new SingleParticipant("Binh Lai"));
		participantList.add(new SingleParticipant("Binh Lam"));
		participantList.add(new SingleParticipant("Dat"));
		participantList.add(new SingleParticipant("Duc Tuan"));
		participantList.add(new SingleParticipant("Khanh"));
		participantList.add(new SingleParticipant("Liem"));
		participantList.add(new SingleParticipant("Mäthu"));
		participantList.add(new SingleParticipant("Minh"));
		participantList.add(new SingleParticipant("Nghi"));
		participantList.add(new SingleParticipant("Nguyen"));
		participantList.add(new SingleParticipant("Phong"));
		participantList.add(new SingleParticipant("Quoc Thinh"));
		participantList.add(new SingleParticipant("Si"));
		participantList.add(new SingleParticipant("Stefan"));
		participantList.add(new SingleParticipant("Thien"));
		participantList.add(new SingleParticipant("Thomas"));
		participantList.add(new SingleParticipant("Toan"));
		participantList.add(new SingleParticipant("Tuan"));
		participantList.add(new SingleParticipant("Van Tuan"));
		participantList.add(new SingleParticipant("Vuong"));
		participantList.add(new SingleParticipant("Willy"));
		participantList.add(new SingleParticipant("Wing"));

		// get groups
		ArrayList<Group> groupList = new ArrayList<Group>();
		groupList.add(new Group("A"));
		groupList.add(new Group("B"));
		groupList.add(new Group("C"));
		groupList.add(new Group("D"));

		// get fields
		ArrayList<Field> fieldList = new ArrayList<Field>();
		fieldList.add(new Field("Field 1"));
		fieldList.add(new Field("Field 2"));
		fieldList.add(new Field("Field 3"));
		fieldList.add(new Field("Field 4"));
		fieldList.add(new Field("Field 5"));
		fieldList.add(new Field("Field 6"));
		fieldList.add(new Field("Field 7"));
		fieldList.add(new Field("Field 8"));

		// draw grouping
		scheduleGenerator.drawGrouping(participantList, groupList);
		for (Group group : groupList) {
			System.out.print(group.getGroupName() + ": " + group.getGroupMemberList());
			System.out.println();
		}

		//scheduleGenerator.generateSchedule(participantList, groupList, true, fieldList, dateList, scheduleVerifier);

	}

	@Test
	public void testGroupingDoubles() {
		// get participants
		ArrayList<Participant> participantList = new ArrayList<Participant>();
		participantList.add(new SingleParticipant("Amy & Binh"));
		participantList.add(new SingleParticipant("Angry Birds"));
		participantList.add(new SingleParticipant("Bänänäää"));
		participantList.add(new SingleParticipant("BiVi"));
		participantList.add(new SingleParticipant("Boi&Girl"));
		participantList.add(new SingleParticipant("Bunny & Pony"));
		participantList.add(new SingleParticipant("Ech ond die zwe detäne"));
		participantList.add(new SingleParticipant("Huong & Teak"));
		participantList.add(new SingleParticipant("Ich Aff' Du Tiger"));
		participantList.add(new SingleParticipant("Just4Fun"));
		participantList.add(new SingleParticipant("K&K"));
		participantList.add(new SingleParticipant("KUSADASI"));
		participantList.add(new SingleParticipant("le jöng"));
		participantList.add(new SingleParticipant("Mäthu & Tien"));
		participantList.add(new SingleParticipant("Mỹ Nhiên"));
		participantList.add(new SingleParticipant("Neighbours"));
		participantList.add(new SingleParticipant("Over The Rainbow"));
		participantList.add(new SingleParticipant("Pucca & Garu"));
		participantList.add(new SingleParticipant("Stängeli"));
		participantList.add(new SingleParticipant("XueTi & Tuan"));
		participantList.add(new SingleParticipant("Fischöl"));
		participantList.add(new SingleParticipant("Team LiLi"));
		participantList.add(new SingleParticipant("The Racqueteers"));
		participantList.add(new SingleParticipant("Vy + Jan"));

		// get groups
		ArrayList<Group> groupList = new ArrayList<Group>();
		groupList.add(new Group("A"));
		groupList.add(new Group("B"));
		groupList.add(new Group("C"));
		groupList.add(new Group("D"));

		// get fields
		ArrayList<Field> fieldList = new ArrayList<Field>();
		fieldList.add(new Field("Field 1"));
		fieldList.add(new Field("Field 2"));
		fieldList.add(new Field("Field 3"));
		fieldList.add(new Field("Field 4"));
		fieldList.add(new Field("Field 5"));
		fieldList.add(new Field("Field 6"));
		fieldList.add(new Field("Field 7"));
		fieldList.add(new Field("Field 8"));

		// draw grouping
		scheduleGenerator.drawGrouping(participantList, groupList);
		for (Group group : groupList) {
			System.out.print(group.getGroupName() + ": " + group.getGroupMemberList());
			System.out.println();
		}

		//scheduleGenerator.generateSchedule(participantList, groupList, true, fieldList, dateList, scheduleVerifier);

	}

}
