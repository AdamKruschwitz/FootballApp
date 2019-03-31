package ithaca.edu.footballTeam.footballApp;

import java.util.List;

public class League {
    private String leagueName;
    private int leagueID;
    private List<Team> participants;
    private List<Round> leagueRounds;
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
            throw new IllegalArgumentException("invalid participants size");
        }

    }

    public static boolean participantsValid(List<Team> participants){
        for(int i = 0; i < participants.size(); i++){
            if(participants.get(i).isTeamEligible()){
                return false;
            }
        }
        return true;

    }
}
