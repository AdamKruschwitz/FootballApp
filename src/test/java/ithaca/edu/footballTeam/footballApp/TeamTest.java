package ithaca.edu.footballTeam.footballApp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {

    @Test
    void ValidTeamTest() {
        Roster activeRoster = new Roster();
        List<Player> players = new ArrayList<Player>();
        for(int i = 0; i<11; i++){
            Player p = new Player(Integer.toString(i), i);
            activeRoster.addPlayer(p);
        }

        Team validTeam = new Team(activeRoster,"valid Team");
        assertTrue(validTeam.isTeamEligible());

        Roster inactiveRoster = new Roster();
        assertThrows(IllegalArgumentException.class, () -> new Team(inactiveRoster, "inactiveTeam"));
    }




}
