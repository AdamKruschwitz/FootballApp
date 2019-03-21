package edu.ithaca.footballApp.code;
import org.junit.Test;
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





    //Get red cards from player


    //Get yellow cards from player

}
