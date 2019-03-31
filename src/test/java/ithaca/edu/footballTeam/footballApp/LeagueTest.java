package ithaca.edu.footballTeam.footballApp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LeagueTest {

    @Test
    void leagueConstructorTest(){

        Roster initiallyActiveRoster = new Roster(true);
        initiallyActiveRoster.fillWithValidPlayers();
        Team validTeam = new Team(initiallyActiveRoster, "invalid Team");

        

        List<Team> invalidTeamList = new ArrayList<Team>();
        assertFalse(League.participantsValid(invalidTeamList));


        Roster activeroster = new Roster(true);
        activeroster.fillWithValidPlayers();
        List<Team> validTeams = new ArrayList<Team>();
        for(int i = 0; i < 4; i++){
            Team newTeam = new Team(activeroster, "Valid Team");
            validTeams.add(newTeam);
        }
        assertThrows(IllegalArgumentException.class, () ->  new League("Valid league", 1, validTeams));




    }
}
