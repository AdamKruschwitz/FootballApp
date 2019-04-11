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
        // Team isValid just returns true regardless will update this when we write the proper function

        if(team.isTeamEligible()) {
            teamsWaitlist.put(team.getTeamName(), team);
        }
        else{
            throw new IllegalArgumentException("Team is not valid");
        }


        teamsWaitlist.put(team.getTeamName(), team);

    }
}
