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

    public void generateRound(){
        int firstHalf = participants.size()/2;
        List<Team> vs1 = participants.subList(0, firstHalf-1);
        List<Team> vs2 = participants.subList(firstHalf,participants.size()-1);
        List<Match> matches = new ArrayList<>();

        for(int i = 0; i < vs1.size(); i++){
           Match match = new Match(vs1.get(i),vs2.get(i), i);
           matches.add(match);
        }








    }
}
