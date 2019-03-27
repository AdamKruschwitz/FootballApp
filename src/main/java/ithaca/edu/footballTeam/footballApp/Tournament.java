package ithaca.edu.footballTeam.footballApp;

import ithaca.edu.footballTeam.footballApp.Team;

import java.util.HashMap;
import java.util.Map;

public class Tournament {

    private Map<String, Team> teams;
    private String tournamentName;
    private Round r1;
    private Round r2;
    private Round r3;
    private Round currRound;
    private Leaderboard leaderboard;

    public Tournament(String name, Map<String, Team> teams){
        this.tournamentName = name;
        this.teams = teams;
        this.r1 = new Round();
        this.r2 = new Round();
        this.r3 = new Round();
        this.currRound = r1;
        this.leaderboard = new Leaderboard();
    }

    public Tournament(String name){
        this.tournamentName = name;
        this.teams = new HashMap<String,Team>();
        this.r1 = new Round();
        this.r2 = new Round();
        this.r3 = new Round();
        this.currRound = r1;
        this.leaderboard = new Leaderboard();

    }

    /**
     * Advances the tournament to the next round
     */
    public void goToNextRound(){
        if(currRound == r1){
            currRound = r2;
        }else if(currRound == r2){
            currRound = r3;
        }else{
            throw new IllegalStateException("Tournament is already in final round");
        }
    }

    /**
     * Adds a team to the tournament
     * @param team
     */
    public void addTeam(Team team){

        teams.put(team.getTeamName(), team);

    }

    /**
     * Removes a team from the tournament based on team name
     * @param teamName
     */
    public void removeTeam(String teamName){
        Team teamToRemove = teams.get(teamName);
        if(teamToRemove!=null){
            teams.remove(teamName);
        }else{
            throw new NullPointerException("This team does not exist in this tournament");
        }
    }

    /**
     * Returns the tournamentID
     * @return tournamentID
     */
    public String getTournamentID(){
        return tournamentName;
    }

    public Team getTeam(String teamName){
        Team toReturn = teams.get(teamName);
        return toReturn;
    }

    /**
     * Prints out a visual of the current leaderboard for the tournament
     */
    public void showLeaderboard(){}

    /**
     * Updates the leaderboard for the tournament
     */
    public void updateLeaderboard() {}



}
