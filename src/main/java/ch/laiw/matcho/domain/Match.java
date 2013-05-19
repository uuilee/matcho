package ch.laiw.matcho.domain;

import java.util.Date;

import util.StringUtilities;


public class Match {
	
	private Participant participantA;
	private Participant participantB;
	private Group group;
	private Date startDate;
	private Field field;
	private int scoreA;
	private int scoreB;
	
	public Match() {
		
	}
	
	public Match(Participant participantA, Participant participantB) {
		this.participantA = participantA;
		this.participantB = participantB;
	}
	
	public Match(Participant participantA, Participant participantB, Group group) {
		this.participantA = participantA;
		this.participantB = participantB;
		this.group = group;
	}
	
	public Participant getParticipantA() {
		return participantA;
	}

	public void setParticipantA(Participant participantA) {
		this.participantA = participantA;
	}

	public Participant getParticipantB() {
		return participantB;
	}

	public void setParticipantB(Participant participantB) {
		this.participantB = participantB;
	}
	

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public int getScoreA() {
		return scoreA;
	}

	public void setScoreA(int scoreA) {
		this.scoreA = scoreA;
	}

	public int getScoreB() {
		return scoreB;
	}

	public void setScoreB(int scoreB) {
		this.scoreB = scoreB;
	}
	
	public String getVS() {
		StringBuilder result = new StringBuilder();
		result.append(getParticipantA().toString());
		result.append(" vs. ");
		result.append(getParticipantB().toString());
		return result.toString();
	}
	
	@Override public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(getGroup().getGroupName());
		result.append(": ");
		result.append(StringUtilities.cutAndFillString(getParticipantA().toString(), 6));
		result.append(" - ");
		result.append(StringUtilities.cutAndFillString(getParticipantB().toString(), 6));
		return result.toString();
	}
	
}
