package ithaca.edu.footballTeam.footballApp;

import ithaca.edu.footballTeam.footballApp.Team;

import java.util.HashMap;
import java.util.Map;

public class Tournament {

    private Map<String, Team> teams;
    private String tournamentID;

    public Tournament(String ID){
        this.tournamentID= ID;
        this.teams = new HashMap<String,Team>();

    }

    public void addTeam(Team team){
        if(team.isValid()) {
            teams.put(team.getTeamName(), team);
        }
        else{
            throw new IllegalArgumentException("This team is not valid");
        }
    }

    public void removeTeam(String teamName){
        Team teamToRemove = teams.get(teamName);
        if(teamToRemove!=null){
            teams.remove(teamName);
        }else{
            throw new NullPointerException("This team does not exist in this tournament");
        }
    }

}