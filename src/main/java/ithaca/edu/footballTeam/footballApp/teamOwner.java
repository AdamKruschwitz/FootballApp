package ithaca.edu.footballTeam.footballApp;

import java.util.Map;

public class teamOwner {

    private String name;
    private Team team;

    public teamOwner(String name, Team team){
        this.name = name;
        this.team = team;
    }

    public teamOwner(String name){
        this.name = name;
    }

    public void registerTeam(Team team, Map teamsWaitlist){

        teamsWaitlist.put(team.getTeamName(), team);
    }
}
