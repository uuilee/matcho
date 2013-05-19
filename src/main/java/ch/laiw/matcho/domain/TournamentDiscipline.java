package ch.laiw.matcho.domain;

import java.util.ArrayList;
import java.util.Collection;

public class TournamentDiscipline {
	public static final String BADMINTON = "Badminton";
	
	public static final String VOLLEYBALL = "Volleyball";
	
	public static Collection<String> getTournamentDisciplineList() {
		ArrayList<String> tournamentTypeList = new ArrayList<String>();
		tournamentTypeList.add(BADMINTON);
		tournamentTypeList.add(VOLLEYBALL);
		return tournamentTypeList;
	}
}


