package ithaca.edu.footballTeam.footballApp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player  {
    private List<Card> redCards;
    private List<Card> yellowCards;
    public String name;
    private int number;
    private int goalsScored;
    private int numOfAssists;



    public Player(String playerName, int number) {
        this.redCards = new ArrayList<>();
        this.yellowCards = new ArrayList<>();
        this.name = playerName;
        this.number = number;
    }


    public void addRedCard(RedCard red){
        this.redCards.add(red);
    }

    public void addYellowCard(Card yellow){
        yellowCards.add(yellow);
    }

    public List<Card> getRedCardsForMatch(int matchID){
        List<Card> matchRedCards = new ArrayList<>();
        for (int i = 0; i < this.redCards.size(); i++) {
            if(this.redCards.get(i).getMatch() == matchID){
                matchRedCards.add(this.redCards.get(i));
            }
        }
        return matchRedCards;
    }

    public List<Card> getYellowCardsForMatch(int matchID){
        List<Card> matchYellowCards = new ArrayList<>();
        for (int i = 0; i < this.yellowCards.size(); i++) {
            if(this.yellowCards.get(i).getMatch() == matchID){
                matchYellowCards.add(this.yellowCards.get(i));
            }
        }
        return matchYellowCards;

    }

    public boolean isEligible(){
        if(redCards.size() > 0){
            return false;
        }
        return true;
    }

    public void removeRedCard(){

    }

    /**
     * Increments the total number of goals scored by the player by 1
     */
    public void addGoal(){this.goalsScored++;}

    /**
     * Increments the total number of assists the player has by 1
     */
    public void addAssist(){ this.numOfAssists++;}

    /**
     * Gets the total number of goals scored by the player
     * @return int
     */
    public int getGoalsScored(){return this.goalsScored;}

    /**
     * Gets the total number of assists the player has
     * @return int
     */
    public int getNumOfAssists(){return this.numOfAssists;}

    /**
     * Gets the player's name
     * @return String
     */
    public String getPlayerName(){ return this.name; }

    public int getNumber(){return this.number;}
}
