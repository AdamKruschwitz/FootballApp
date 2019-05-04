package ithaca.edu.footballTeam.footballApp;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class LeagueTest {



    @Test
    void checkIfTeamIsValidAfterCardTest(){
        Roster initiallyActiveRoster = new Roster();
        initiallyActiveRoster.fillWithValidPlayers();
        Team validTeam = new Team(initiallyActiveRoster, "invalid Team");
        List<Team> invalidTeamList = new ArrayList<Team>();
        invalidTeamList.add(validTeam);
        invalidTeamList.add(validTeam);
        assertTrue(League.participantsValid(invalidTeamList));
        RedCard red = new RedCard(2,"attacked ref");
        initiallyActiveRoster.getPlayer(1).addRedCard(red);
        assertFalse(League.participantsValid(invalidTeamList));

    }

    @Test
    void addRemoveTeamTest(){
        Roster activeRoster = new Roster();
        activeRoster.fillWithValidPlayers();
        Team validTeam = new Team(activeRoster, "valid Team");
        Team validTeam2 = new Team(activeRoster, "valid Team2");
        List<Team> TeamList = new ArrayList<Team>();
        TeamList.add(validTeam);
        League newLeague = new League("League 1", 1, TeamList);

        newLeague.addTeam(validTeam2);

        assertEquals("valid Team2", newLeague.removeTeam("valid Team2").getTeamName());
        assertEquals(null, newLeague.removeTeam("valid Team2"));


    }


    @Test
    void checkHasPlayedValidationCheck() {
        Map<String, Integer> playedCount = new HashMap<>();
        Roster roster = new Roster();
        roster.fillWithValidPlayers();
        Team team = new Team(roster,"Team1");
        int count = 1;
        playedCount.put(team.getTeamName(),0);
        assertFalse(League.hasPlayed(playedCount,team,count));
        playedCount.put(team.getTeamName(), count);
        assertTrue(League.hasPlayed(playedCount,team,count));

    }

    @Test
    void hasBeenPlayedValidationCheck(){
        List<Match> played = new ArrayList<>();
        Roster roster = new Roster();
        roster.fillWithValidPlayers();
        Team team = new Team(roster, "team1");
        Team team2 = new Team(roster, "team2");
        Match currentMatch = new Match(team, team2,10);
        assertFalse(League.hasBeenPlayed(played,currentMatch));
        played.add(currentMatch);
        assertTrue(League.hasBeenPlayed(played,currentMatch));
    }

    @Test
    void isEligibleValidationCheck(){
        Roster roster = new Roster();
        roster.fillWithValidPlayers();
        Team team = new Team(roster, "team1");
        Team team2 = new Team(roster, "team2");

        Match match = new Match(team, team2,10);
        List<Match> playedMatches = new ArrayList<>();
        Map<String, Integer> playedCount = new HashMap<>();
        playedCount.put(team.getTeamName(),0);
        playedCount.put(team2.getTeamName(), 0);
        int count = 1;
        assertTrue(League.isEligible(match,playedMatches,playedCount,count));

        playedCount.put(team.getTeamName(),count);
        playedCount.put(team2.getTeamName(), count);
        playedMatches.add(match);
        assertFalse(League.isEligible(match,playedMatches,playedCount,count));

    }

    //double check to make sure that each match has a unique ID
    @Test
    void allGamesPlayedCheck(){
        Map<String, Integer> playedCount = new HashMap<>();
        Roster roster = new Roster();
        roster.fillWithValidPlayers();
        Team team = new Team(roster, "team1");
        Team team2 = new Team(roster, "team2");
        Team team3 = new Team(roster, "team3");
        Team team4 = new Team(roster, "team4");

        playedCount.put(team.getTeamName(),0);
        playedCount.put(team2.getTeamName(), 0);
        playedCount.put(team3.getTeamName(),0);
        playedCount.put(team4.getTeamName(), 0);

        assertFalse(League.checkAllGamesPlayed(playedCount,1));


        playedCount.put(team.getTeamName(),1);
        playedCount.put(team2.getTeamName(), 1);
        playedCount.put(team4.getTeamName(), 1);

        assertFalse(League.checkAllGamesPlayed(playedCount,1));

        playedCount.put(team3.getTeamName(),1);

        assertTrue(League.checkAllGamesPlayed(playedCount,1));
    }

    @Test
    void checkSingleWeekendGeneration(){
        Roster roster = new Roster();
        roster.fillWithValidPlayers();
        Team team = new Team(roster, "team1");
        Team team2 = new Team(roster, "team2");
        Team team3 = new Team(roster, "team3");
        Team team4 = new Team(roster, "team4");
        List<Team> teamList = new ArrayList<>();
        teamList.add(team);
        teamList.add(team2);
        teamList.add(team3);
        teamList.add(team4);

        League testLeague = new League("League 1", 1, teamList);
        testLeague.generateLeagueMatches();

        Map<String, Integer> playedCount = new HashMap<>();
        List<Match> playedMatches = new ArrayList<>();
        int weekendCount = 1;

        playedCount = testLeague.fillWithTeams(playedCount);

        Iterator<Match> weekend = testLeague.genWeekend(playedCount,playedMatches,1);

        //each team only appears once
        //every team in participants have played
        Map<Team, Integer> teamTest = new HashMap<>();
        while (weekend.hasNext()){
            Match match = weekend.next();
            teamTest.put(match.getTeam1(),1);
            teamTest.put(match.getTeam2(),1);
        }

        Iterator it = teamTest.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            assertEquals(1, pair.getValue());
            teamList.remove(pair.getKey());
        }

        assertTrue(teamList.size() == 0);
    }

    @Test
    void checkAllWeekends(){
        Roster roster = new Roster();
        roster.fillWithValidPlayers();
        Team team = new Team(roster,  "team1");
        Team team2 = new Team(roster, "team2");
        Team team3 = new Team(roster, "team3");
        Team team4 = new Team(roster, "team4");
        List<Team> teamList = new ArrayList<>();
        teamList.add(team);
        teamList.add(team2);
        teamList.add(team3);
        teamList.add(team4);

        League testLeague = new League("League 1", 1, teamList);
        testLeague.generateLeagueMatches();
        List<Iterator<Match>> allWeekends = testLeague.genAllWeekeds();
        Iterator<Iterator<Match>> allGames = allWeekends.iterator();

        while (allGames.hasNext()){
            Iterator<Match> itr = allGames.next();
            Map<Team, Integer> teamTest = new HashMap<>();
            while (itr.hasNext()){
                Match match = itr.next();
                teamTest.put(match.getTeam1(),1);
                teamTest.put(match.getTeam2(),1);
            }
            Iterator it = teamTest.entrySet().iterator();
            List<Integer> noDuplicateChecker = new ArrayList<>();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                assertEquals(1, pair.getValue());

            }

        }


    }

    @Test
    void printLeagueMatchUps(){
        Roster roster = new Roster();
        roster.fillWithValidPlayers();
        Team team = new Team(roster,  "team1");
        Team team2 = new Team(roster, "team2");
        Team team3 = new Team(roster, "team3");
        Team team4 = new Team(roster, "team4");
        List<Team> teamList = new ArrayList<>();
        teamList.add(team);
        teamList.add(team2);
        teamList.add(team3);
        teamList.add(team4);


        League testLeague = new League("League 1", 1, teamList);
        testLeague.generateLeagueMatches();
        String matchUps = testLeague.showLeagueMatchUps();
        System.out.print(matchUps);

    }

    @Test
    void createLeagueTest(){

    }



}
