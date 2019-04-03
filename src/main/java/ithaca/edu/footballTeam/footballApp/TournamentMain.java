package ithaca.edu.footballTeam.footballApp;

import java.util.ArrayList;
import java.util.List;

public class TournamentMain {

    public static void main(String[] args) {
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
    }
}

