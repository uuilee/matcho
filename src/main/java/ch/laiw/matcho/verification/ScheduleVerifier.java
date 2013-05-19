package ch.laiw.matcho.verification;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ch.laiw.matcho.domain.Field;
import ch.laiw.matcho.domain.Match;
import ch.laiw.matcho.domain.Participant;
import ch.laiw.matcho.domain.Schedule;

public class ScheduleVerifier {

	public ScheduleVerifier() {

	}

	public boolean verifyNoColision(Schedule schedule) {
		// for every date, check that no duplicate participant exist
		for (Map<Field, Match> coincidentMatches : schedule.getSchedule().values()) {
			Set<Participant> activeParticipantList = new HashSet<Participant>();
			for (Match match : coincidentMatches.values()) {
				if (match != null) {
					if (activeParticipantList.contains(match.getParticipantA())) {
						System.out.println("Collision detected with participant " + match.getParticipantA() + " at " + match.getStartDate());
						return false;
					} else {
						activeParticipantList.add(match.getParticipantA());
					}
					if (activeParticipantList.contains(match.getParticipantB())) {
						System.out.println("Collision detected with participant " + match.getParticipantB() + " at " + match.getStartDate());
						return false;
					} else {
						activeParticipantList.add(match.getParticipantB());
					}
				}
			}
		}
		return true;
	}

	public boolean verifyComplete(Schedule schedule, Collection<Match> matchList) {
		for (Match match : matchList) {
			Date date = match.getStartDate();
			if (schedule.getSchedule().containsKey(date) && schedule.getSchedule().get(date).containsKey(match.getField())
					&& schedule.getSchedule().get(date).get(match.getField()) != null
						&& schedule.getSchedule().get(date).get(match.getField()).equals(match)) {
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean verifyValid(Schedule schedule, Collection<Match> matchList) {
		return (verifyComplete(schedule, matchList) && verifyNoColision(schedule));
	}
}
