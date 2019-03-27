package ithaca.edu.footballTeam.footballApp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class RoundTest {
    @Test
    void roundConstructorTest() {
        Roster activeRoster = new Roster(true);
        List<Player> players = new ArrayList<Player>();
        for(int i = 0; i<11; i++){
            Player p = new Player();
            activeRoster.addPlayer(p);
        }

        Team validTeam = new Team(activeRoster,"valid Team");
        Team validTeam2 = new Team(activeRoster,"validTeam2");
        Team validTeam3 = new Team(activeRoster,"validTeam3");
        Team validTeam4 = new Team(activeRoster,"validTeam4");

        List<Team> teams1 = new ArrayList<>();
        teams1.add(validTeam);
        teams1.add(validTeam2);

        List<Team> teams2 = new ArrayList<>();
        teams2.add(validTeam3);
        teams2.add(validTeam4);

        List<Match> matches = new ArrayList<>();
        matches.add(new Match(teams1, new Date(10000000)));
        matches.add(new Match(teams2, new Date(20000000)));

        Round test = new Round(matches, null);
    }

}
