package ithaca.edu.footballTeam.footballApp;

import java.util.List;

public class League {
    private String leagueName;
    private int leagueID;
    private List<Team> participants;
    private List<Round> leagueRounds;
    //private Leaderboard scoreboard;

    public  League(String leagueName, int leagueID, List<Team> participants){

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
