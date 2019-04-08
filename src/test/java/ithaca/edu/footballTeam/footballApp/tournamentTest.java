package ithaca.edu.footballTeam.footballApp;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class tournamentTest {

    @Test
    public void showTeamsTest(){
        List<Team> teams = new ArrayList<>();

        Roster activeRoster = new Roster();
        List<Player> players = new ArrayList<Player>();
        for(int i = 0; i<11; i++){
            Player p = new Player("Player"+i,i);
            activeRoster.addPlayer(p);
        }

        for (int i = 0; i < 8; i++) {
            Team team = new Team(activeRoster,"Team"+i);
            team.updateRank(i+1);
            teams.add(team);
        }
        Tournament tournament = new Tournament("European Cup",teams);
        System.out.println("Before");
        tournament.showTeams();
        tournament.removeTeam("Team1");
        Team everton = new Team(activeRoster,"EvertonFC");
        tournament.addTeam(everton);
        System.out.println("After");
        tournament.showTeams();

    }

    @Test
    public void tournamentConstructorTest(){
        List<Team> teams = new ArrayList<>();
        List<Team> teams2 = new ArrayList<>();
        List<Team> teams4 = new ArrayList<>();
        Map<String, Team> teams3 = new HashMap<>();

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
            teams3.put(team.getTeamName(),team);
        }

        for (int i = 0; i < 7; i++) {
            Team team = new Team(activeRoster,"Team"+i);
            team.updateRank(i+1);
            teams4.add(team);
        }

        assertThrows(IllegalArgumentException.class, ()-> new Tournament("American Cup",teams2));
        Tournament tournament1 = new Tournament("European Cup",teams);
        assertThrows(NullPointerException.class, ()-> tournament1.getTeam("EvetonFC"));
        Team team = tournament1.getTeam("Team1");
        assertEquals("Team1",team.getTeamName());
        Tournament tournament3 = new Tournament("World Cup",teams3);
        System.out.println("Hash Map Teams");
        tournament3.showTeams();
        System.out.println("Matches for current round of "+tournament3.getTournamentID()+" are: ");
        tournament3.showMatchesForCurrentRound();
        System.out.println("\n");
        assertThrows(IllegalArgumentException.class, ()-> new Tournament("Jamaica Cup",teams4));



    }

    @Test
    public void runRoundTest(){

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
        System.out.println("\nRound"+t1.getRoundNUm());
        t1.showTeams();
        t1.showMatchesForCurrentRound();
        t1.runRound();
        System.out.println("\nRound"+t1.getRoundNUm());
        t1.showTeams();
        t1.showMatchesForCurrentRound();
        t1.runRound();
    }

    /*@Test
    public void runRoundTest(){
        List<Team> teams = new ArrayList<>();
        List<Team> teams2 = new ArrayList<>();

        Roster activeRoster = new Roster();
        List<Player> players = new ArrayList<Player>();
        for(int i = 0; i<11; i++){
            Player p = new Player("Player"+i,i);
            activeRoster.addPlayer(p);
        }

        for (int i = 0; i < 8; i++) {
            Team team = new Team(activeRoster,"Team"+i);
            teams.add(team);
        }

        Tournament t1 = new Tournament("American Cup",teams);
        t1.runRound();
    }*/

}
