package ithaca.edu.footballTeam.footballApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class League {
    private String leagueName;
    private int leagueID;
    private List<Team> participants;
    private List<Round> leagueRounds;
    private boolean inSeason;
    //private Leaderboard scoreboard;

    /**
     *
     * @param leagueName name of the league
     * @param leagueID id of the league
     * @param participants participants of the league
     *
     * Paticipant list size must be even and participant teams must be eligible to play with valid active rosters
     */

    public  League(String leagueName, int leagueID, List<Team> participants){
        if(participantsValid(participants) && participants.size() % 2 == 0){
            this.leagueID = leagueID;
            this.leagueName = leagueName;
            this.participants = participants;
        }
        else {
            throw new IllegalArgumentException("Invalid team in participants or invalid participants size");
        }

    }

    /**
     *
     * @param participants list of participating teams
     * @return boolean if the participating teams are all valid
     */

    public static boolean participantsValid(List<Team> participants){
        for(int i = 0; i < participants.size(); i++){
            if(participants.get(i).isTeamEligible()){
                return false;
            }
        }
        return true;

    }

    /**
     *
     * @param participants participating teams for this round
     * Teams must be valid and team numbers have to be even
     * This creates all of the matches for the games to be played within a league season
     */

    public List<Match> generateLeagueMatches(List<Team> participants){
        List<Match> leagueMatches;
        if(participantsValid(participants)) {
             leagueMatches = new ArrayList<>();
            for (int i = 0; i < participants.size(); i++) {
                for(int j =1; j < participants.size(); j++){
                    Match match = new Match(participants.get(i), participants.get(j), i + j);
                    leagueMatches.add(match);
                }
            }
        }
        else {
            throw new IllegalArgumentException("Participating teams does not have an even number");
        }
        return leagueMatches;
    }





}
