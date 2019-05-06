package ithaca.edu.footballTeam.footballApp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TournamentRoundIT {

    //Represent the use case of running a round in the tournament
    @Test

    public void runRoundIT() {


        List<Team> teams = new ArrayList<>();
        Roster activeRoster = new Roster();
        List<Player> players = new ArrayList<Player>();
        for (int i = 0; i < 11; i++) {
            Player p = new Player("Player" + i, i);
            activeRoster.addPlayer(p);
        }

        for (int i = 0; i < 14; i++) {
            Team team = new Team(activeRoster, "Team" + i);
            team.updateRank(i + 1);
            teams.add(team);
        }

        Tournament t1 = new Tournament("American", teams);


        if (t1.getCurrRound().getCurrentMatches() == null) {
            throw new NullPointerException("There are no matches to run");
        } else {

            for (int i = 0; i < t1.getCurrRound().getCurrentMatches().size(); i++) {
                Match currMatch = t1.getCurrRound().getCurrentMatches().get(i);

                currMatch.setTeam1Score(3);

                currMatch.setTeam2Score(1);
            }

            assertEquals("Team0",t1.getCurrRound().getCurrentMatches().get(0).getWinner().getTeamName());
            assertEquals("Team1",t1.getCurrRound().getCurrentMatches().get(1).getWinner().getTeamName());
            assertEquals("Team2",t1.getCurrRound().getCurrentMatches().get(2).getWinner().getTeamName());
            assertEquals("Team3",t1.getCurrRound().getCurrentMatches().get(3).getWinner().getTeamName());

            t1.goToNextRound(t1.getCurrRound().getCurrentMatches());

            assertEquals("Team0",t1.getCurrRound().getCurrentMatches().get(0).getTeam1().getTeamName());
            assertEquals("Team3",t1.getCurrRound().getCurrentMatches().get(0).getTeam2().getTeamName());
            assertEquals("Team1",t1.getCurrRound().getCurrentMatches().get(1).getTeam1().getTeamName());
            assertEquals("Team2",t1.getCurrRound().getCurrentMatches().get(1).getTeam2().getTeamName());
        }
    }

}
