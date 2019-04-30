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
        Team team3 = new Team(roster, "team3");
        Match match = new Match(team1, team2, 0);
        // Score should start at 0
        assertEquals(0, match.getTeam1Score());
        assertEquals(0, match.getTeam2Score());

        // Team1 Goal & team1 player0 Goal
        Player team1Player0 = team1.getPlayer(0);
        match.addGoal(0,0);
        assertEquals(1, match.getTeam1Score());
        assertEquals(1,team1Player0.getGoalsScored());


        // Team2 Goal & player0 Goal
        Player team2Player1 = team2.getPlayer(1);
        match.addGoal(1,1);
        assertEquals(1, match.getTeam2Score());
        assertEquals(1,team2Player1.getGoalsScored());


        // Batch goals and team total goals
        for(int i=0; i<5; i++) {
            match.addGoal(0,0);
        }
        assertEquals(6, match.getTeam1Score());
        assertEquals(team1.getTotalGoalsScored(), 6);
        assertEquals(6,team1Player0.getGoalsScored());

        //New match
        Match match2 = new Match(team1,team3,1);

        match2.addGoal(0,0);

        assertEquals(1,match2.getTeam1Score());
        //check if player goals and team gaols increment with different matches
        assertEquals(7,team1Player0.getGoalsScored());
        assertEquals(7,team1.getTotalGoalsScored());
    }

    @Test
    public void scoredOnTest(){
        Roster roster = new Roster();
        roster.fillWithValidPlayers();
        //System.out.println(roster.isEligible());
        Team team1 = new Team(roster, "team1");
        Team team2 = new Team(roster, "team2");
        Team team3 = new Team(roster, "team3");
        Match match = new Match(team1, team2, 0);

        match.addGoal(0,0);
        assertEquals(1,team2.getTotalGoalsScoredOn());

        for(int i=0; i<5; i++) {
            match.addGoal(1,0);
        }

        assertEquals(5,team1.getTotalGoalsScoredOn());
        Match match3 = new Match(team1,team3,1);
        match3.addGoal(1,0);
        assertEquals(6,team1.getTotalGoalsScoredOn());
    }

    @Test
    public void addAssistTest(){
        Roster roster = new Roster();
        roster.fillWithValidPlayers();
        //System.out.println(roster.isEligible());
        Team team1 = new Team(roster, "team1");
        Team team2 = new Team(roster, "team2");
        Team team3 = new Team(roster, "team3");
        Match match = new Match(team1, team2, 0);

        match.addAssist(0,0);

        Player player0 = team1.getPlayer(0);
        assertEquals(1,team1.getTotalAssists());
        assertEquals(1,player0.getNumOfAssists());

        for (int i = 0; i < 5; i++) {
            match.addAssist(0,0);
        }

        assertEquals(6,player0.getNumOfAssists());
        assertEquals(6,team1.getTotalAssists());

        Match match2 = new Match(team1,team3,1);

        match2.addAssist(0,0);

        assertEquals(7,player0.getNumOfAssists());
        assertEquals(7,team1.getTotalAssists());

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
