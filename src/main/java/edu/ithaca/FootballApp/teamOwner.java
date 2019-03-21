package edu.ithaca.FootballApp;

import java.util.Map;

public class teamOwner {

    private String name;
    private Team team;

    public teamOwner(String name, Team team){
        this.name = name;
        this.team = team;
    }

    public void registerTeam(Team team, Map teamsWaitlist){
        if(team.IsValid()) {
            teamsWaitlist.put(team.teamName, team);
        }
        else{
            throw new IllegalArgumentException("Team is not valid");
        }
    }
}
