package edu.ithaca.footballApp.code;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {
    //Add card to player and create player
    @Test
    public void cardsTest() {
        RedCard testCard = new RedCard(0, "Un-sportsmanlike");
        Player testPlayer = new Player("Bob", 5);
        testPlayer.addRedCard(testCard);
        assertEquals(testPlayer.getRedCardsForMatch(0).get(0).getReason(), "Un-sportsmanlike");
    }

    //Get all red cards from player for a given match
    @Test
    public void getRedCardsTest(){
        //Create a player and add a bunch of red cards
        Player testPlayer = new Player("Bob", 5);
        testPlayer.addRedCard(new RedCard(0, "R1"));
        testPlayer.addRedCard(new RedCard(2, "R2"));
        testPlayer.addRedCard(new RedCard(1, "R3"));
        testPlayer.addRedCard(new RedCard(2, "R4"));
        testPlayer.addRedCard(new RedCard(3, "R5"));
        testPlayer.addRedCard(new RedCard(5, "R6"));
        testPlayer.addRedCard(new RedCard(2, "R7"));
        testPlayer.addRedCard(new RedCard(2, "R8"));
        List<Card> matchCards = testPlayer.getRedCardsForMatch(2);
        assertEquals(matchCards.get(0).getReason(), "R2");
        assertEquals(matchCards.get(1).getReason(), "R4");
        assertEquals(matchCards.get(2).getReason(), "R7");
        assertEquals(matchCards.get(3).getReason(), "R8");
    }


    //Get all yellow cards from player for a given match
    @Test
    public void getYellowCardsTest(){
        //Create a player and add a bunch of red cards
        Player testPlayer = new Player("Bob", 5);
        testPlayer.addYellowCard(new YellowCard(0, "R1"));
        testPlayer.addYellowCard(new YellowCard(2, "R2"));
        testPlayer.addYellowCard(new YellowCard(1, "R3"));
        testPlayer.addYellowCard(new YellowCard(2, "R4"));
        testPlayer.addYellowCard(new YellowCard(3, "R5"));
        testPlayer.addYellowCard(new YellowCard(5, "R6"));
        testPlayer.addYellowCard(new YellowCard(2, "R7"));
        testPlayer.addYellowCard(new YellowCard(2, "R8"));
        List<Card> matchCards = testPlayer.getYellowCardsForMatch(2);
        assertEquals(matchCards.get(0).getReason(), "R2");
        assertEquals(matchCards.get(1).getReason(), "R4");
        assertEquals(matchCards.get(2).getReason(), "R7");
        assertEquals(matchCards.get(3).getReason(), "R8");

    }

    //Check that player eligibility works
    @Test
    public void eligibilityTest(){
        //Create player and test before and after redcard
        Player testPlayer = new Player("Bob", 5);
        assertEquals(true, testPlayer.isEligible());
        testPlayer.addRedCard(new RedCard(0, "R1"));
        assertEquals(false, testPlayer.isEligible());
    }

}
