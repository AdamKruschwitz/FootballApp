package edu.ithaca.footballApp.code;

public class Card {
    private String reason;
    private int match;

    public Card(int match, String reason){
        this.reason = reason;
        this.match = match;
    }

    public String getReason(){
        return this.reason;
    }

    public int getMatch(){
        return this.match;
    }
}