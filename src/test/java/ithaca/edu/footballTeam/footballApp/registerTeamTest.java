package ithaca.edu.footballTeam.footballApp;

import ithaca.edu.footballTeam.footballApp.Commissioner;
import ithaca.edu.footballTeam.footballApp.teamOwner;
import ithaca.edu.footballTeam.footballApp.Commissioner;
import ithaca.edu.footballTeam.footballApp.teamOwner;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class registerTeamTest {

    @Test
    public void Test() {
        Map <String, Team> teamWaitlist = new HashMap<String, Team>();
        Map <String, Tournament> tournmentList = new HashMap<String, Tournament>();

        Roster activeRoster = new Roster(true);
        List<Player> players = new ArrayList<Player>();
        for(int i = 0; i<11; i++){
            Player p = new Player("player"+i,i);
            activeRoster.addPlayer(p);
        }

        Tournament t1 = new Tournament("T1");
        Tournament t2 = new Tournament("T2");
        tournmentList.put("T1",t1);
        tournmentList.put("T2",t2);

        Team validTeam = new Team(activeRoster,"EvertonFC","T1");

        teamOwner everton = new teamOwner("Everton",validTeam);
        validTeam.setOwner(everton);

        Commissioner mainC= new Commissioner ("Admin");
        everton.registerTeam(validTeam,teamWaitlist);
        assertEquals(validTeam,teamWaitlist.get(validTeam.getTeamName()));

        mainC.approveTeam(validTeam.getTeamName(),teamWaitlist,tournmentList);
        assertEquals(0,teamWaitlist.size());
        Tournament toCheck = tournmentList.get(validTeam.getTournamentID());
        Team toFind = toCheck.getTeam(validTeam.getTeamName());
        assertEquals(validTeam.getTeamName(),toFind.getTeamName());
        assertThrows(NullPointerException.class, ()-> mainC.approveTeam(validTeam.getTeamName(),teamWaitlist, tournmentList));
    }
}
