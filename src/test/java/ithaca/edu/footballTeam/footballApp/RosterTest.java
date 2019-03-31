package ithaca.edu.footballTeam.footballApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RosterTest {

    @Test
    void addRemovePlayerTest(){
        Roster newRoster = new Roster(true);
        Player p = new Player("player1",1);

        newRoster.addPlayer(p);
        assertEquals(1,newRoster.getPlayerCount());

        newRoster.removePlayer();
        assertEquals(0,newRoster.getPlayerCount());

    }

    @Test
    void rosterIsValidTest(){
        Roster validRoster = new Roster(true);
        validRoster.fillWithValidPlayers();
        assertEquals(true, validRoster.isEligible() );


        Roster invalidRoster = new Roster(false);
        assertEquals(false, invalidRoster.isEligible());

    }
}
