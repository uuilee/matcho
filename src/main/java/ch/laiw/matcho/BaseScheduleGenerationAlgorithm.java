package ch.laiw.matcho;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import ch.laiw.matcho.domain.Field;
import ch.laiw.matcho.domain.Group;
import ch.laiw.matcho.domain.Match;
import ch.laiw.matcho.domain.Participant;
import ch.laiw.matcho.domain.Schedule;
import ch.laiw.matcho.verification.ScheduleVerifier;

public abstract class BaseScheduleGenerationAlgorithm implements ScheduleGenerationAlgorithm {

	@Override
	public abstract Schedule generateSchedule(Collection<Participant> participantList, Collection<Group> groupList, boolean drawGrouping, Collection<Field> fieldList,
			Collection<Date> dateList, ScheduleVerifier scheduleVerifier) throws InvalidScheduleInputException;

	protected Collection<Match> generateMatchList(Collection<Group> groupList) {
		ArrayList<Match> matchList = new ArrayList<Match>();
		for (Group group : groupList) {
			ArrayList<Participant> groupMemberList = new ArrayList<Participant>(group.getGroupMemberList());
			// for every pair in a group create a match object.
			// n: # group members --> sum(n-i, i=0..n): # matches in this group
			for (int i = 0; i < groupMemberList.size(); ++i) {
				for (int j = i + 1; j < groupMemberList.size(); ++j) {
					Participant participantA = groupMemberList.get(i);
					Participant participantB = groupMemberList.get(j);
					Match match = new Match(participantA, participantB, group);
					matchList.add(match);
					participantA.getMatchList().add(match);
					participantB.getMatchList().add(match);
					group.getMatchList().add(match);
				}
			}
		}
		return matchList;
	}

	public void drawGrouping(Collection<Participant> participantList, Collection<Group> groupList) {
		Random random = new Random();
		ArrayList<Participant> drawPot = new ArrayList<Participant>(participantList);
		// calculate the minimum group size and the number of the remaining participants after a integer division
		int groupMinSize = drawPot.size() / groupList.size();
		// assign the minimum amount of participants to every group
		for (Group group : groupList) {
			for (int j = 0; j < groupMinSize; ++j) {
				Participant participant = drawPot.remove(random.nextInt(drawPot.size()));
				participant.setGroup(group);
				group.getGroupMemberList().add(participant);
			}
		}
		// assign the remaining participants to the groups starting with the first group
		for (Group group : groupList) {
			if (!drawPot.isEmpty()) {
				Participant participant = drawPot.remove(random.nextInt(drawPot.size()));
				participant.setGroup(group);
				group.getGroupMemberList().add(participant);
			}
		}
	}

	// inner comparator class that defines an ordering of every match in a match list
	protected class MatchComparator implements Comparator<Match> {

		private Map<String, Integer> participantCounts;

		public MatchComparator(Schedule schedule) {
			this.participantCounts = new HashMap<String, Integer>();
			for (Map<Field, Match> fieldMatch : schedule.getSchedule().values()) {
				for (Match match : fieldMatch.values()) {
					if (match != null) {
						String nameA = match.getParticipantA().getFirstName();
						String nameB = match.getParticipantB().getFirstName();
						if (participantCounts.containsKey(nameA)) {
							participantCounts.put(nameA, participantCounts.get(nameA) + 1);
						} else {
							participantCounts.put(nameA, 1);
						}
						if (participantCounts.containsKey(nameB)) {
							participantCounts.put(nameB, participantCounts.get(nameB) + 1);
						} else {
							participantCounts.put(nameB, 1);
						}
					}
				}
			}
		}

		@Override
		public int compare(Match m1, Match m2) {
			int score11 = participantCounts.get(m1.getParticipantA().getFirstName()) != null ? participantCounts.get(m1.getParticipantA().getFirstName()) : 0;
			int score12 = participantCounts.get(m1.getParticipantB().getFirstName()) != null ? participantCounts.get(m1.getParticipantB().getFirstName()) : 0;

			int score21 = participantCounts.get(m2.getParticipantA().getFirstName()) != null ? participantCounts.get(m2.getParticipantA().getFirstName()) : 0;
			int score22 = participantCounts.get(m2.getParticipantB().getFirstName()) != null ? participantCounts.get(m2.getParticipantB().getFirstName()) : 0;

			int score1 = score11 + score12;
			int score2 = score21 + score22;
			return score1 - score2;
		}

	}

}
