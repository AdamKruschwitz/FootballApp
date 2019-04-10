package ithaca.edu.footballTeam.footballApp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TournamentRoundIT {

    @Test
    public void runRoundIT(){

        List<Team> teams = new ArrayList<>();
        Roster activeRoster = new Roster();
        List<Player> players = new ArrayList<Player>();
        for(int i = 0; i<11; i++){
            Player p = new Player("Player"+i,i);
            activeRoster.addPlayer(p);
        }

        for (int i = 0; i < 14; i++) {
            Team team = new Team(activeRoster,"Team"+i);
            team.updateRank(i+1);
            teams.add(team);
        }

        Tournament t1 = new Tournament("American",teams);
        System.out.println("\nRound"+t1.getRoundNUm());
        t1.showTeams();
        t1.showMatchesForCurrentRound();
        t1.runRound();
        assertEquals(2,t1.getCurrRound().getCurrentMatches().size());
        assertEquals(2,t1.getRoundNUm());
        System.out.println("\nRound"+t1.getRoundNUm());
        t1.showTeams();
        t1.showMatchesForCurrentRound();
        t1.runRound();
        assertEquals(3,t1.getRoundNUm());
        System.out.println("\nRound"+t1.getRoundNUm());
        t1.showTeams();
        t1.showMatchesForCurrentRound();
        t1.runRound();
        assertEquals(3,t1.getRoundNUm());
    }

}
