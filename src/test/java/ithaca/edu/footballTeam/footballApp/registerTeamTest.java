package ithaca.edu.footballTeam.footballApp;

<<<<<<< HEAD:src/test/java/ithaca/edu/footballTeam/footballApp/registerTeamTest.java
import edu.ithaca.footballTeam.FootballApp.Commissioner;
import edu.ithaca.footballTeam.FootballApp.teamOwner;
=======
import ithaca.edu.footballTeam.footballApp.Commissioner;
import ithaca.edu.footballTeam.footballApp.teamOwner;
>>>>>>> master:src/test/java/ithaca/edu/footballTeam/footballApp/registerTeamTest.java
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class registerTeamTest {
    @Test
    public static void main(String[] args) {
        Map <String, Team> teamWaitlist = new HashMap<String, Team>();
        Map <String, Tournament> tournmentList = new HashMap<String, Tournament>();

        Team EvertonFC = new Team ("EvertonFC","Everton", "Desired Tournament");
        Team Testing = new Team ("Testing");

        teamOwner everton = new teamOwner("Everton",EvertonFC);
        Commissioner mainC= new Commissioner ("Admin");
        everton.registerTeam(EvertonFC,teamWaitlist);
        mainC.approveTeam("EvertonFC",teamWaitlist,tournmentList);

        Tournament toCheck = tournmentList.get(EvertonFC.getDesiredTournament());
        Team toFind = toCheck.getTeam(EvertonFC.getTeamName());

        assertEquals(EvertonFC,toCheck);
        assertTrue(teamWaitlist.containsKey(EvertonFC.getTeamName()));
        assertThrows(IllegalArgumentException.class, ()-> everton.registerTeam(Testing,teamWaitlist));
        assertThrows(NullPointerException.class, ()-> mainC.approveTeam(Testing.getTeamName,teamWaitlist,tournmentList m));


    }
}
