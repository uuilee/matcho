package ch.laiw.matcho.domain;

import java.util.ArrayList;
import java.util.Collection;

public class MultiParticipant implements Participant {

	private Long id;
	private String teamName;
	private ArrayList<SingleParticipant> teamMember;
	private Group group;
	private Collection<Match> matchList;
	private Collection<String> categoryList;

	public MultiParticipant() {
		this.matchList = new ArrayList<Match>();
		this.categoryList = new ArrayList<String>();
	}

	public MultiParticipant(String teamName) {
		this();
		this.teamName = teamName;
	}

	public MultiParticipant(String teamName, ArrayList<SingleParticipant> teamMember) {
		this();
		this.teamName = teamName;
		this.teamMember = teamMember;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String getFirstName() {
		return teamName;
	}
	
	@Override
	public void setFirstName(String teamName) {
		this.teamName = teamName;
	}

	public ArrayList<SingleParticipant> getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(ArrayList<SingleParticipant> teamMember) {
		this.teamMember = teamMember;
	}

	@Override
	public Group getGroup() {
		return group;
	}

	@Override
	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public Collection<Match> getMatchList() {
		return matchList;
	}

	@Override
	public void setMatchList(Collection<Match> matchList) {
		this.matchList = matchList;
	}
	
	@Override
	public String toString() {
		return this.getFirstName();
	}

	@Override
	public String getLastName() {
		return "";
	}

	@Override
	public void setLastName(String lastName) {

	}

	@Override
	public Collection<String> getCategories() {
		// TODO Auto-generated method stub
		return this.categoryList;
	}

	@Override
	public void setCategories(Collection<String> categories) {
		this.categoryList = categories;
		
	}
	
}
