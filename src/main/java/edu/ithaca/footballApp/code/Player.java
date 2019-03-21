package edu.ithaca.footballApp.code;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> redCards;
    private List<Card> yellowCards;
    private String name;
    private int number;


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
        return matchYellowCards;

    }

}
