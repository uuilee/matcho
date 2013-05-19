package ch.laiw.matcho.domain;

public class TournamentCategories {

	public static String[] getTournamentCategories(String tournamentType) {
		if (tournamentType.equals(TournamentDiscipline.BADMINTON)) {
			return new String[]{"Ladies' Singles", "Ladies' Doubles", "Men's Singles", "Men's Doubles", "Mixed Doubles"};
		} else if (tournamentType.equals(TournamentDiscipline.VOLLEYBALL)) {
			return new String[]{"Ladies", "Men", "Mixed"};
		} else {
			return new String[]{};
		}
	}
}
