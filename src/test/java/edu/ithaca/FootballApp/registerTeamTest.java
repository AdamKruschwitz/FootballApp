package edu.ithaca.FootballApp;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class registerTeamTest {
    @Test
    public static void main(String[] args) {
        registerTeam test = new registerTeam();
        Map <String, Team> teamWaitlist = new HashMap<String, Team>();
        Map <String, Tournament> tournmentList = new HashMap<String, Tournament>();

        Team EvertonFC = new Team ("EvertonFC","Everton", "Desired Tournament");
        Team Testing = new Team ("Testing");
        //TeamOwner everton = new TeamOwner("Everton");
        //Commissioner mainC= new Commissioner ("Admin");
        test.registerTeam(EvertonFC,teamWaitlist);
        assertTrue(teamWaitlist.containsKey(EvertonFC.getTeamName()));
        test.approveTeam(EvertonFC,teamWaitlist,tournmentList);
        Tornament toCheck = tournmentList.get(EvertonFC.getDesiredTournament());
        Team check = toCheck.getTeam(EvertonFC);
        assertEquals(EvertonFC,check);
        assertThrows(IllegalArgumentException.class, ()-> test.registerTeam(Testing,teamWaitlist));
        assertThrows(NullPointerException.class, ()-> test.approveTeam(Testing.getTeamName,teamWaitlist,tournmentList));


    }
}
