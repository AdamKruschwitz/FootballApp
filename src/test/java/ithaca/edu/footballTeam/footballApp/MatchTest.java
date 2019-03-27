package ithaca.edu.footballTeam.footballApp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class MatchTest {

    @Test
    void MatchConstructorTest() {
        Roster activeRoster = new Roster(true);
        List<Player> players = new ArrayList<Player>();
        for(int i = 0; i<11; i++){
            Player p = new Player();
            activeRoster.addPlayer(p);
        }

        Team validTeam = new Team(activeRoster,"valid Team");

        List<Team> teams = new ArrayList<>();
        teams.add(validTeam);
        Date startTime = new Date(10000000);
        Match test = new Match(teams, startTime);
        Assert.assertEquals(test.startTime, startTime);
        Assert.assertEquals(test.teams, teams);
        teams.remove(0);
        Assert.assertNotEquals(test.teams, teams);
    }

}
