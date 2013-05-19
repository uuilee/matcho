package ch.laiw.matcho.domain;

public class TournamentMode {

	public static final String SCHOCH = "Schoch";
	public static final String GROUP = "Group";
	public static final String KO = "KO";
	
	public static String[] getTournamentMode(String tournamentType) {
		if (tournamentType.equals(TournamentDiscipline.BADMINTON)) {
			return new String[]{"Schoch"};
		} else if (tournamentType.equals(TournamentDiscipline.VOLLEYBALL)) {
			return new String[]{"Group", "KO"};
		} else {
			return new String[]{};
		}
	}
}
