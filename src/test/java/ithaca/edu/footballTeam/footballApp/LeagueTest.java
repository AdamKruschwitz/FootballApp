package ithaca.edu.footballTeam.footballApp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LeagueTest {



    @Test
    void checkIfTeamIsValidAfterCardTest(){
        Roster initiallyActiveRoster = new Roster();
        initiallyActiveRoster.fillWithValidPlayers();
        Team validTeam = new Team(initiallyActiveRoster, "invalid Team");
        List<Team> invalidTeamList = new ArrayList<Team>();
        invalidTeamList.add(validTeam);
        invalidTeamList.add(validTeam);
        assertTrue(League.participantsValid(invalidTeamList));
        RedCard red = new RedCard(2,"attacked ref");
        initiallyActiveRoster.getPlayer(1).addRedCard(red);
        assertFalse(League.participantsValid(invalidTeamList));

    }

    @Test
    void addRemoveTeamTest(){
        Roster activeRoster = new Roster();
        activeRoster.fillWithValidPlayers();
        Team validTeam = new Team(activeRoster, "valid Team");
        Team validTeam2 = new Team(activeRoster, "valid Team2");
        List<Team> TeamList = new ArrayList<Team>();
        TeamList.add(validTeam);
        League newLeague = new League("League 1", 1, TeamList);

        newLeague.addTeam(validTeam2);

        assertEquals("valid Team2", newLeague.removeTeam("valid Team2").getTeamName());
        assertEquals(null, newLeague.removeTeam("valid Team2"));


    }



<<<<<<< HEAD
    }

    @Test
    void checkWeekendMatches(){
        //initialize and create a league with teams inside of it
        Roster activeRoster = new Roster();
        activeRoster.fillWithValidPlayers();
        Team validTeam = new Team(activeRoster, "Team1");
        Team validTeam2 = new Team(activeRoster, "Team2");
        Team validTeam3 = new Team(activeRoster, "Team3");
        Team validTeam4 = new Team(activeRoster, "Team4");
        List<Team> TeamList = new ArrayList<Team>();
        TeamList.add(validTeam);
        TeamList.add(validTeam2);
        TeamList.add(validTeam3);
        TeamList.add(validTeam4);
        League newLeague = new League("Leage1",1,TeamList);
        newLeague.generateLeagueMatches();

        //generate a weekend
        List<Match> weekend = newLeague.genWeekend();

        //create an array of team names from the weekend
        Iterator<Match> itr = weekend.iterator();
        List<String> teamNames = new ArrayList<>();
        while (itr.hasNext()){
            Match match = itr.next();
            teamNames.add(match.getTeam2().getTeamName());
            teamNames.add(match.getTeam1().getTeamName());
        }

        //Check to make sure the total number of teams is equal to the original number of teams
        assertEquals(TeamList.size(), teamNames.size());

        //Check to make sure that the team names only appear once
        int count = 0;
        while(count < TeamList.size()){
            int numInstances = 0;
            Team team = TeamList.get(count);
            for(int i = 0; i < teamNames.size(); i++){
                String name = teamNames.get(i);
                if(name == team.getTeamName()){
                    numInstances++;
                }
            }
            assertEquals(1,numInstances);
            count++;
        }
    }
=======
>>>>>>> master
}
