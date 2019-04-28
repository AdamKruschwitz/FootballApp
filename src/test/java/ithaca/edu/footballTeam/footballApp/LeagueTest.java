package ithaca.edu.footballTeam.footballApp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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



}
