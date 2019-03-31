package ithaca.edu.footballTeam.footballApp;

import java.util.Map;

public class Commissioner {
    private String name;

    public Commissioner(String name){
        this.name = name;
    }

    public void approveTeam(String teamName, Map<String, Team> teamsWaitlist, Map<String, Tournament> tournamentList){

        Team teamToAdd = (Team) teamsWaitlist.get(teamName);
        if(teamToAdd!=null) {
            String desiredTournamentID = teamToAdd.getTournamentID();

            //Map key = tournament name, value = tournament object
            Tournament tournamentToUpdate = (Tournament) tournamentList.get(desiredTournamentID);
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
