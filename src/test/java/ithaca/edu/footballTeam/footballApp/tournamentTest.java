package ithaca.edu.footballTeam.footballApp;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

        assertThrows(IllegalArgumentException.class, ()-> new Tournament("American Cup",teams2));
        Tournament tournament1 = new Tournament("European Cup",teams);
        assertThrows(NullPointerException.class, ()-> tournament1.getTeam("EvetonFC"));
        Team team = tournament1.getTeam("Team1");
        assertEquals("Team1",team.getTeamName());
        Tournament tournament2 = new Tournament("International Cup");
        assertEquals("International Cup",tournament2.getTournamentID());

        assertThrows(NullPointerException.class, ()-> tournament2.removeTeam("EvertonFC"));


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
