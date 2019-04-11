package ithaca.edu.footballTeam.footballApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TournamentMain {

    public static void main(String[] args) {
        List<Team> teams = new ArrayList<>();
        List<Team> teams2 = new ArrayList<>();
        Map<String, Team> teams3 = new HashMap<>();

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
            teams3.put(team.getTeamName(), team);
        }

        Tournament t1 = new Tournament("American",teams);

    }
}

