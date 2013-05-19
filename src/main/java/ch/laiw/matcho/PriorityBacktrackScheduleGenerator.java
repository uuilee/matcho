package ch.laiw.matcho;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import ch.laiw.matcho.domain.Field;
import ch.laiw.matcho.domain.Group;
import ch.laiw.matcho.domain.Match;
import ch.laiw.matcho.domain.Participant;
import ch.laiw.matcho.domain.Schedule;
import ch.laiw.matcho.verification.ScheduleVerifier;

public class PriorityBacktrackScheduleGenerator extends BaseScheduleGenerationAlgorithm {

	@Override
	public Schedule generateSchedule(Collection<Participant> participantList, Collection<Group> groupList, boolean drawGrouping, Collection<Field> fieldList,
			Collection<Date> dateList, ScheduleVerifier scheduleVerifier) throws InvalidScheduleInputException {

		if (participantList == null || groupList == null || fieldList == null || dateList == null || scheduleVerifier == null) {
			throw new InvalidScheduleInputException("One of the input parameter is null");
		}
		
		int numParticipants = participantList.size();
		int numGroups = groupList.size();
		int numFields = fieldList.size();
		int numDates = dateList.size();

		// validate input
		if (numParticipants < 2 || numGroups < 1 || numFields < 1 || numDates < 1) {
			throw new InvalidScheduleInputException(
					"At least of the input sizes is to small." +
					"\nThe number of participants (" + numParticipants + ") must be > 1." +
					"\nThe number of groups (" + numGroups + ") must be > 0." +
					"\nThe number of fields (" + numFields + ") must be > 0." +
					"\nThe number of dates (" + numDates + ") must be > 0.");
		}
		if (numParticipants < 2 * numGroups) {
			throw new InvalidScheduleInputException(
					"The number of groups (" + numGroups + ") should be smaller than half of the number of participants (" + numParticipants + ").");
		}

		// draw groups
		if (drawGrouping) {
			this.drawGrouping(participantList, groupList);
		}
		for (Participant participant : participantList) {
			boolean inGroup = false;
			for (Group group : groupList) {
				if (group.getGroupMemberList().contains(participant)) {
					inGroup = true;
				}
			}
			if (!inGroup) {
				throw new InvalidScheduleInputException("Participant " + participant + " is not assigned to a group.");
			}
			
		}
		

		// create match list
		Collection<Match> matchList = generateMatchList(groupList);
		int numMatches = matchList.size();
		int numSlots = (numFields * numDates);
		System.out.println("Number of matches: " + numMatches);
		if (numMatches > numSlots) {
			throw new InvalidScheduleInputException("The number of matches (" + numMatches + ") exceeds the number of free slots (" + numSlots
					+ ") in the schedule.");
		}

		// create schedule
		Schedule nextSchedule = new Schedule(fieldList, dateList);
		PriorityQueue<Match> nextMatchList = new PriorityQueue<Match>(numMatches, new MatchComparator(nextSchedule));
		for (Match match : matchList) {
			nextMatchList.add(match);
		}
		Schedule schedule = backtrackSchedule(nextSchedule, new LinkedList<Date>(dateList), new LinkedList<Field>(fieldList), matchList, nextMatchList,
				scheduleVerifier);

		return schedule;
	}

	protected Schedule backtrackSchedule(Schedule schedule, Queue<Date> dateList, Queue<Field> fieldList, Collection<Match> originalMatchList,
			Collection<Match> matchList, ScheduleVerifier scheduleVerifier) {
		System.out.println(schedule);
		if (scheduleVerifier.verifyValid(schedule, originalMatchList)) {
			return schedule;
		} else if (scheduleVerifier.verifyNoColision(schedule)) {
			for (Match match : matchList) {
				// getting a copy of the current data
				Schedule nextSchedule = new Schedule(schedule);

				// add match
				nextSchedule.addMatch(match);

				// create new matchList
				PriorityQueue<Match> nextMatchList = new PriorityQueue<Match>(matchList.size(), new MatchComparator(nextSchedule));
				for (Match m : matchList) {
					nextMatchList.add(m);
				}
				nextMatchList.remove(match);

				// generate backtrack branches
				Schedule newSchedule = backtrackSchedule(nextSchedule, dateList, fieldList, originalMatchList, nextMatchList, scheduleVerifier);
				if (newSchedule != null) {
					return newSchedule;
				}
			}
		}
		return null;
	}

}
