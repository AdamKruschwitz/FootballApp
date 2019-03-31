package ithaca.edu.footballTeam.footballApp;

import ithaca.edu.footballTeam.footballApp.Team;

import java.util.HashMap;
import java.util.Map;

public class Tournament {

    private Map<String, Team> teams;
    private String tournamentName;

    public Tournament(String name){
        this.tournamentName = name;
        this.teams = new HashMap<String,Team>();

    }

    public void addTeam(Team team){

        teams.put(team.getTeamName(), team);

    }

    public void removeTeam(String teamName){
        Team teamToRemove = teams.get(teamName);
        if(teamToRemove!=null){
            teams.remove(teamName);
        }else{
            throw new NullPointerException("This team does not exist in this tournament");
        }
    }
    public String getTournamentID(){
        return tournamentName;
    }

    public Team getTeam(String teamName){
        Team toReturn = teams.get(teamName);
        return toReturn;
    }

}