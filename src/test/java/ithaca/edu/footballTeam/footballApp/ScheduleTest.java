package ithaca.edu.footballTeam.footballApp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class ScheduleTest {
    @Test
    void GetTournamentScheduleTest() {
        Roster roster = new Roster(true);
        for(int i=0; i<11; i++) {
            roster.addPlayer(new Player("Player"+Integer.toString(i), i));
        }

        List<Match> matches = new ArrayList<>();
        matches.add(new Match(new Team(roster, "team1"), new Team(roster, "team2"), new Date(10000), 0));
        matches.add(new Match(new Team(roster, "team3"), new Team(roster, "team4"), new Date(20000), 0));

        List<Round> rounds = new ArrayList<>();
        rounds.add(new Round(matches, null));

        Tournament tournament = new Tournament(rounds);

        // Normal case
        Assert.assertEquals(
                "team1 vs team2, Wed Dec 31 19:00:10 EST 1969\n" +
                        "team3 vs team4, Wed Dec 31 19:00:20 EST 1969",
                Schedule.getTournamentSchedule(tournament)
        );

        // Tournament with no rounds
        Tournament emptyTournament = new Tournament();
        Assert.assertEquals("", Schedule.getTournamentSchedule(emptyTournament));

    }
}
