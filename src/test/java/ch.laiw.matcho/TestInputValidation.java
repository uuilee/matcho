package ch.laiw.matcho;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import util.TournamentUtilities;
import ch.laiw.matcho.InvalidScheduleInputException;
import ch.laiw.matcho.PriorityBacktrackScheduleGenerator;
import ch.laiw.matcho.ScheduleGenerationAlgorithm;
import ch.laiw.matcho.domain.Field;
import ch.laiw.matcho.domain.Group;
import ch.laiw.matcho.domain.Participant;
import ch.laiw.matcho.verification.ScheduleVerifier;

public class TestInputValidation {
	
	private ScheduleGenerationAlgorithm scheduleGenerator;
	private ScheduleVerifier scheduleVerifier;
	
	@Before
	public void setUp() {
		scheduleGenerator = new PriorityBacktrackScheduleGenerator();
		scheduleVerifier = new ScheduleVerifier();
	}
	
	@Test(expected=InvalidScheduleInputException.class)
	public void testNullInput() throws InvalidScheduleInputException {
		scheduleGenerator.generateSchedule(null, null, false, null, null, null);
	}
	
	@Test(expected=InvalidScheduleInputException.class)
	public void testTooSmallInput() throws InvalidScheduleInputException {
		Collection<Participant> participantList = TournamentUtilities.generateParticipants(0);
		Collection<Group> groupList = TournamentUtilities.generateGroups(0);
		Collection<Field> fieldList = TournamentUtilities.generateFields(0);
		Collection<Date> dateList = TournamentUtilities.generateDates(2012, 5, 28, 9, 0, Calendar.MINUTE, 15, 10);

		scheduleGenerator.generateSchedule(participantList, groupList, true, fieldList, dateList, scheduleVerifier);
	}

	
	@Test(expected=InvalidScheduleInputException.class)
	public void testTooFewParticipantsTooManyGroups() throws InvalidScheduleInputException {
		Collection<Participant> participantList = TournamentUtilities.generateParticipants(0);
		Collection<Group> groupList = TournamentUtilities.generateGroups(7);
		Collection<Field> fieldList = TournamentUtilities.generateFields(4);
		Collection<Date> dateList = TournamentUtilities.generateDates(2012, 5, 28, 9, 0, Calendar.MINUTE, 15, 3);

		scheduleGenerator.generateSchedule(participantList, groupList, true, fieldList, dateList, scheduleVerifier);
	}
}
