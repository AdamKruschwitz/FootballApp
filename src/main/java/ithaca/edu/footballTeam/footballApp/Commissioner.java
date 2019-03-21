package ithaca.edu.footballTeam.footballApp;

import java.util.Map;

public class Commissioner {
    private String name;

    public Commissioner(String name){
        this.name = name;
    }

    public void approveTeam(String teamName, Map teamsWaitlist, Map tournamentList){

        Team teamToAdd = teamsWaitlist.get(teamName);
        if(teamToAdd!=null) {
            String desiredTournament = teamToAdd.getDesiredTournament();
            //Map key = tournament name, value = tournament object
            Tournament tournamentToUpdate = tournamentList.get(desiredTournament);
            if(tournamentToUpdate!=null){
                tournamentToUpdate.addTeam(teamToAdd);
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
