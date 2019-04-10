package ithaca.edu.footballTeam.footballApp;
import org.junit.Test;
import ithaca.edu.footballTeam.footballApp.Leaderboard;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LeaderboardTest {

    @Test
    public void leaderBoardAddGetTeamsTest(){
        Roster roster = new Roster();
        roster.fillWithValidPlayers();
        List<Team> teamList =  new ArrayList<>();
        teamList.add(new Team(roster, "Team1"));
        Leaderboard leaderboard = new Leaderboard(teamList);
        assertEquals(0,leaderboard.getTeamPoints("Team1"));
        assertThrows(IllegalArgumentException.class, () ->leaderboard.getTeamPoints("team2"));

    }

    @Test
    public void leaderBoardAddPointsTest(){
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
        Leaderboard leaderboard = new Leaderboard(teamList);
        Match match = new Match(team1, team2,1);
        match.setTeam1Score(2);
        match.setTeam2Score(5);
        leaderboard.updateLeaderBoard(match);
        Match match1 = new Match(team3, team4,2);
        match1.setTeam1Score(3);
        match1.setTeam2Score(3);
        leaderboard.updateLeaderBoard(match1);

        assertEquals(0, leaderboard.getTeamPoints(team1.getTeamName()));
        assertEquals(3, leaderboard.getTeamPoints(team2.getTeamName()));
        assertEquals(1,leaderboard.getTeamPoints(team3.getTeamName()));
        assertEquals(1, leaderboard.getTeamPoints(team4.getTeamName()));
        assertThrows(IllegalArgumentException.class, () -> leaderboard.getTeamPoints("team 5"));



    }


}

