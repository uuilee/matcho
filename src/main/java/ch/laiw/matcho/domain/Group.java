package ch.laiw.matcho.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Group {

	private String groupName;
	private Collection<Participant> groupMemberList;
	private Collection<Match> matchList;
	
	public Group() {
		this.groupMemberList = new ArrayList<Participant>();
		this.matchList = new ArrayList<Match>();
	}
	
	public Group(String groupName) {
		this();
		this.groupName = groupName;
	}
	
	public Group(Group group) {
		this.groupName = group.getGroupName();
		this.groupMemberList = new ArrayList<Participant>(group.getGroupMemberList());
		this.matchList = new ArrayList<Match>(group.getMatchList());
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Collection<Participant> getGroupMemberList() {
		return groupMemberList;
	}

	public void setGroupMemberList(Collection<Participant> groupMemberList) {
		this.groupMemberList = groupMemberList;
	}

	public Collection<Match> getMatchList() {
		return matchList;
	}

	public void setMatchList(Collection<Match> matchList) {
		this.matchList = matchList;
	}

	@Override
	public String toString() {
		return this.getGroupName();
	}
}
