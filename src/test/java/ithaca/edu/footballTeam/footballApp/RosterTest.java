package ithaca.edu.footballTeam.footballApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RosterTest {

    @Test
    void addRemovePlayerTest(){
        Roster newRoster = new Roster();
        Player p = new Player("player1",1);

        newRoster.addPlayer(p);
        assertEquals(1,newRoster.getPlayerCount());

        newRoster.removePlayer(0);
        assertEquals(0,newRoster.getPlayerCount());

    }

    @Test
    void rosterIsValidTest(){
        Roster validRoster = new Roster();
        validRoster.fillWithValidPlayers();
        assertEquals(true, validRoster.isEligible());


        Roster invalidRoster = new Roster();
        //Fix this test at some point
        assertEquals(false, invalidRoster.isEligible());

    }
     @Test
    void sortPlayerNamesTest(){
        Roster validRoster = new Roster();
        Player PlayerOne = new Player("Adrian", 1);
        Player PlayerTwo = new Player("Brian", 2);
        Player PlayerThree = new Player("Charlie", 3);

        validRoster.addPlayer(PlayerOne);
        validRoster.addPlayer(PlayerThree);
        validRoster.addPlayer(PlayerTwo);

        assertEquals(validRoster.players.indexOf(PlayerThree),1 );
        validRoster.sortPlayerNames();
         assertEquals(validRoster.players.indexOf(PlayerThree),2 );



     }
}
