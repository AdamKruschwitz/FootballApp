package edu.ithaca.FootballApp;

import java.util.Map;

public class registerTeam {

    public registerTeam(){}

    public void registerTeam(Team team, Map teamsWaitlist){
        if(teamIsValid) {
            teamsWaitlist.put(team.teamName, team);
        }
        else{
            throw new IllegalArgumentException("Team is not valid");
        }
    }

    public void approveTeam(String teamName, Map teamsWaitlist, Map tournamentList){
        Team toAdd = teamsWaitlist.get(teamName);
        if(toAdd!=null) {
            String desiredTournament = toAdd.getDesiredTournament();
            //Map key = tournament name, value = tournament object
            Tournament toUpdate = tournamentList.get(desiredTournament);
            if(toUpdate!=null){
                toUpdate.addTeam(toAdd);
            }else{
                throw new NullPointerException("Tournament does not exist");
            }

            teamsWaitlist.remove(teamName);
        }
        else{
            throw new NullPointerException("Team does not exist in waiting list");
        }
    }

}
