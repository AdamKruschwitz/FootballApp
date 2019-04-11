package ithaca.edu.footballTeam.footballApp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class MatchTest {
/*
    @Test
    void MatchConstructorTest() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team());
        Date startTime = new Date(10000000);
        Match test = new Match(teams, startTime);
        Assert.assertEquals(test.startTime, startTime);
        Assert.assertEquals(test.teams, teams);
        teams.remove(0);
        Assert.assertNotEquals(test.teams, teams);
    }
    */

    @Test
    void addGoalTest() {
        Team team1 = new Team(new Roster(), "team1");
        Team team2 = new Team(new Roster(), "team2");
        Match match = new Match(team1, team2, 0);
        Assert.assertEquals(0, match.getTeam1Score());
        Assert.assertEquals(0, match.getTeam2Score());
        match.addGoal(0);
        Assert.assertEquals(match.getTeam1Score(), 1);
        match.addGoal(1);
        Assert.assertEquals(match.getTeam2Score(), 1);
        for(int i=0; i<5; i++) {
            match.addGoal(0);
        }
        Assert.assertEquals(6, match.getTeam1Score());

    }

}
