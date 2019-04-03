package ithaca.edu.footballTeam.footballApp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LeagueTest {

    @Test
    void leagueConstructorTest(){
        Roster activeroster = new Roster();
        activeroster.fillWithValidPlayers();
        List<Team> validTeams = new ArrayList<Team>();
        for(int i = 0; i < 3; i++){
            Team newTeam = new Team(activeroster, "Valid Team");
            validTeams.add(newTeam);
        }
        assertThrows(IllegalArgumentException.class, () ->  new League("Valid league", 1, validTeams));




    }

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
}
