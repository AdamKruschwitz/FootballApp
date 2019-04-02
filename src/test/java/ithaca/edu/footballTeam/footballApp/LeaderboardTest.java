package ithaca.edu.footballTeam.footballApp;
import org.junit.Test;
import ithaca.edu.footballTeam.footballApp.Leaderboard;

import static org.junit.Assert.assertEquals;


public class LeaderboardTest {

    @Test
    public void teamStringTest(){
        Leaderboard newLeaderboardTest = new Leaderboard();
        assertEquals("teamA 42", newLeaderboardTest.leaderboard());
        assertEquals("teamB 60", newLeaderboardTest.leaderboard());
    }


}
