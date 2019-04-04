package ithaca.edu.footballTeam.footballApp;

import java.util.List;

public class Schedule {

    public Schedule() {}

    /**
     * Returns a string of the schedule of a given tournament.
     * @param tournament
     * @return Schedule
     */
    public static String getTournamentSchedule(Tournament tournament) {
        List<Round> rounds = tournament.getRounds();
        String out = "";

        for(Round round : rounds) {
            List<Match> matches = round.getCurrentMatches();
            for(Match match : matches) {
                out += match.getTeam1().getTeamName() + " vs " + match.getTeam2().getTeamName() + ", ";
                out += match.startTime.toString();
                out += "\n";
            }
        }
        if(out.length() > 0) {
            out = out.substring(0, out.length() - 1); // Take out the last new line character
        }
        return out;
    }

}
