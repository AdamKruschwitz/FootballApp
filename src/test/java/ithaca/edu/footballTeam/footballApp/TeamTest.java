package ithaca.edu.footballTeam.footballApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {

    @Test
    void ValidTeamTest() {
        Roster activeRoster = new Roster(true, 11);
        Team validTeam = new Team(activeRoster,"valid Team");
        assertTrue(validTeam.isTeamEligible());

        Roster inactiveRoster = new Roster(false,9);
        assertThrows(IllegalArgumentException.class, () -> new Team(inactiveRoster, "inactiveTeam"));
    }




}
