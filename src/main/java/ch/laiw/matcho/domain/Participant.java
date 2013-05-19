package ch.laiw.matcho.domain;

import java.util.Collection;

public interface Participant {

	public Long getId();
	
	public void setId(Long id);
	
	public String getFirstName();
	
	public void setFirstName(String name);
	
	public String getLastName();
	
	public void setLastName(String name);
	
	public Collection<String> getCategories();
	
	public void setCategories(Collection<String> categories);
	
	public Group getGroup();
	
	public void setGroup(Group group);
	
	public Collection<Match> getMatchList();
	
	public void setMatchList(Collection<Match> matchList);
}
