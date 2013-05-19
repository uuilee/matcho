package ch.laiw.matcho;

import java.util.Collection;
import java.util.Date;

import ch.laiw.matcho.domain.Field;
import ch.laiw.matcho.domain.Group;
import ch.laiw.matcho.domain.Participant;
import ch.laiw.matcho.domain.Schedule;
import ch.laiw.matcho.verification.ScheduleVerifier;

public interface ScheduleGenerationAlgorithm {

	public Schedule generateSchedule(Collection<Participant> participantList, Collection<Group> groupList, boolean drawGroup, Collection<Field> fieldList, Collection<Date> dateList, ScheduleVerifier scheduleVerifier) throws InvalidScheduleInputException;
	
	public void drawGrouping(Collection<Participant> participantList, Collection<Group> groupList);
}
