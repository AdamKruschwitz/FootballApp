package ithaca.edu.footballTeam.footballApp;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class TeamMatchTest {
    @Test
    public void teamMatchWinLossTest(){
        Team t1 = new Team();
        Team t2 = new Team();
        Match testMatch = new Match(t1, t2, 0);
        testMatch.setTeam1Score(3);
        testMatch.setTeam2Score(5);
        assertEquals(t2, testMatch.getWinner());
    }

}