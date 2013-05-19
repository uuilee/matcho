package ch.laiw.matcho.domain;

import java.util.ArrayList;

public class Field implements Comparable<Field> {

	private String fieldIdentifier;
	private ArrayList<Match> matchList;
	
	public Field() {
		matchList = new ArrayList<Match>();
	}
	
	public Field(String fieldIdentifier) {
		matchList = new ArrayList<Match>();
		this.fieldIdentifier = fieldIdentifier;
	}
	
	public Field(String fieldIdentifier, ArrayList<Match> matchList) {
		this.fieldIdentifier = fieldIdentifier;
		this.matchList = matchList;
	}
	
	public String getFieldIdentifier() {
		return fieldIdentifier;
	}

	public void setFieldIdentifier(String fieldIdentifier) {
		this.fieldIdentifier = fieldIdentifier;
	}

	public ArrayList<Match> getMatchList() {
		return matchList;
	}

	public void setMatchList(ArrayList<Match> matchList) {
		this.matchList = matchList;
	}

	@Override
	public String toString() {
		return this.getFieldIdentifier();
	}

	@Override
	public int compareTo(Field field) {
		return this.getFieldIdentifier().compareTo(field.getFieldIdentifier());
	}
}
