package ithaca.edu.footballTeam.footballApp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertTrue;

public class LeagueIntegrationIT {


    /**
     * This is the run league use case, as well as update the leaderboard
     */
    @Test
    public void leagueIT(){
        Roster roster = new Roster();
        roster.fillWithValidPlayers();
        Team team1 = new Team(roster, "Team 1");
        Team team2 = new Team(roster, "Team 2");
        Team team3 = new Team(roster, "Team 3");
        Team team4 = new Team(roster, "Team 4");
        List<Team> teamList =  new ArrayList<>();
        teamList.add(team1);
        teamList.add(team2);
        teamList.add(team3);
        teamList.add(team4);
        League league = new League("American league",1,teamList);
        Iterator<Match> itr = league.generateLeagueMatches();
        Iterator<Map.Entry<String, Integer>> scoreBoard = null;
        int score = 0;
        while (itr.hasNext()){
            Match match = itr.next();
            match.setTeam1Score(score);
            match.setTeam2Score(score+1);
            //Score board is an iterator ordered by best team to worst team in terms of points in descending order
            scoreBoard = league.updateLeaderBoard();
            score++;
        }

        while (scoreBoard.hasNext()){
            Map.Entry<String, Integer> team = scoreBoard.next();
            System.out.println("Team Name " + team.getKey() + " Score " + team.getValue());
        }


    }



}
