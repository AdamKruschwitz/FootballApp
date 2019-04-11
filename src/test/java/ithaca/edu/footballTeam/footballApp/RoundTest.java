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
        List<Team> teams1 = new ArrayList<>();
        teams1.add(new Team());
        teams1.add(new Team());

        List<Team> teams2 = new ArrayList<>();
        teams2.add(new Team());
        teams2.add(new Team());

        List<Match> matches = new ArrayList<>();
        matches.add(new Match(teams1, new Date(10000000)));
        matches.add(new Match(teams2, new Date(20000000)));

        Round test = new Round(matches, null);
    }

}
