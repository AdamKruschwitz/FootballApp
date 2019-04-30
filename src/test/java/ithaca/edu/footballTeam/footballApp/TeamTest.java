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
        for (int i = 0; i < 11; i++) {
            Player p = new Player(Integer.toString(i), i);
            activeRoster.addPlayer(p);
        }

        Team validTeam = new Team(activeRoster, "valid Team");
        assertTrue(validTeam.isTeamEligible());

        Roster inactiveRoster = new Roster();
        //Fix this
        assertThrows(IllegalArgumentException.class, () -> new Team(inactiveRoster, "inactiveTeam"));
    }

    @Test
    void comparingTwoTeamsTest() {
        Roster activeRoster = new Roster();
        activeRoster.fillWithValidPlayers();
        Team team1 = new Team(activeRoster, "Team 1");
        Team team2 = new Team(activeRoster, "Team 2");

        team1.addToScoredGoals(10);
        team1.addToScoredOnGoals(2);

        team2.addToScoredGoals(10);
        team2.addToScoredOnGoals(5);

        assertEquals(1, team1.compareTo(team2));
        assertEquals(-1, team2.compareTo(team1));
    }

        @Test
        public void resetStatsTest(){
            Roster roster = new Roster();
            List<Player> players = new ArrayList<Player>();
            for (int i = 0; i < 11; i++) {
                Player p = new Player(Integer.toString(i), i);
                roster.addPlayer(p);
            }

            Team validTeam = new Team(roster, "valid Team");
            Player player1 = roster.getPlayer(0);

            validTeam.addAssist();
            validTeam.addToScoredGoals(10);
            player1.addGoal();
            player1.addGoal();
            player1.addAssist();

            assertEquals(10, validTeam.getTotalGoalsScored());
            assertEquals(1, validTeam.getTotalAssists());

            assertEquals(1, player1.getNumOfAssists());
            assertEquals(2, player1.getGoalsScored());

            player1.resetStats();
            validTeam.resetStats();

            assertEquals(0, validTeam.getTotalAssists());
            assertEquals(0, validTeam.getTotalGoalsScored());

            assertEquals(0, player1.getGoalsScored());
            assertEquals(0, player1.getNumOfAssists());


        }


    }

