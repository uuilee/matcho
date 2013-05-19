package ch.laiw.matcho.domain;

import java.util.ArrayList;
import java.util.Collection;

public class SingleParticipant implements Participant {

	private Long id;
	private String firstName;
	private String lastName;
	private Group group;
	private Collection<Match> matchList;
	private Collection<String> categoryList;
	
	public SingleParticipant() {
		this.matchList = new ArrayList<Match>();
		this.categoryList = new ArrayList<String>();
	}
	
	public SingleParticipant(String firstName) {
		this();
		this.firstName = firstName;
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
		return firstName;
	}

	@Override
	public void setFirstName(String name) {
		this.firstName = name;
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
		return this.lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
