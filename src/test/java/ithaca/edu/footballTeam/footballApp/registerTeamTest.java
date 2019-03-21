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
    public static void main(String[] args) {
        Map <String, Team> teamWaitlist = new HashMap<String, Team>();
        Map <String, Tournament> tournmentList = new HashMap<String, Tournament>();
        Tournament t1 = new Tournament("T1");
        tournmentList.put("T1",t1);

        Roster activeRoster = new Roster(true);
        List<Player> players = new ArrayList<Player>();
        for(int i = 0; i<11; i++){
            Player p = new Player();
            activeRoster.addPlayer(p);
        }

        Team validTeam = new Team(activeRoster,"EvertonFC","T1");


        teamOwner everton = new teamOwner("Everton",validTeam);
        Commissioner mainC= new Commissioner ("Admin");
        everton.registerTeam(validTeam,teamWaitlist);
        mainC.approveTeam("EvertonFC",teamWaitlist,tournmentList);

        Tournament toCheck = tournmentList.get(validTeam.getDesiredTournament());
        Team toFind = toCheck.getTeam(validTeam.getTeamName());

        assertEquals(validTeam,toCheck);
        assertTrue(teamWaitlist.containsKey(validTeam.getTeamName()));
        assertThrows(IllegalArgumentException.class, ()-> everton.registerTeam(Testing,teamWaitlist));
        assertThrows(NullPointerException.class, ()-> mainC.approveTeam(Testing.getTeamName,teamWaitlist,tournmentList m));


    }
}