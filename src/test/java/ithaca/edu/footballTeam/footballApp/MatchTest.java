package ithaca.edu.footballTeam.footballApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        Roster roster = new Roster();
        roster.fillWithValidPlayers();
        //System.out.println(roster.isEligible());
        Team team1 = new Team(roster, "team1");
        Team team2 = new Team(roster, "team2");
        Match match = new Match(team1, team2, 0);
        // Score should start at 0
        assertEquals(0, match.getTeam1Score());
        assertEquals(0, match.getTeam2Score());

        // Team1 Goal
        match.addGoal(0);
        assertEquals(1, match.getTeam1Score());

        // Team2 Goal
        match.addGoal(1);
        assertEquals(1, match.getTeam2Score());

        // Batch goals and team total goals
        for(int i=0; i<5; i++) {
            match.addGoal(0);
        }
        assertEquals(6, match.getTeam1Score());
        assertEquals(team1.getTotalGoalsScored(), 6);

    }

    @Test
    void printTeamsTest(){
        Roster roster = new Roster();
        roster.fillWithValidPlayers();
        Team team1 = new Team( roster, "t1");
        Team team2 = new Team(roster, "t2");
        Match match = new Match(team1, team2, 1);

        System.out.println(match.showPlayersInMatch());
    }

}
