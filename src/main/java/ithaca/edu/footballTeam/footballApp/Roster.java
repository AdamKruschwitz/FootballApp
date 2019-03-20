package ithaca.edu.footballTeam.footballApp;

import java.util.ArrayList;
import java.util.List;

public class Roster {
    private boolean canPlay;
    private List<Player> players = new ArrayList<Player>();
    private int playerCount;

    public Roster(boolean canPlay){
        this.canPlay = canPlay;
        this.playerCount = playerCount;
    }

    public boolean isEligible(){
        return (canPlay == true && playerCount > 10);
    }

    public void addPlayer(Player p){
        players.add(p);
        playerCount++;
    }

    public void removePlayer(){
        if(playerCount>0) {
            players.remove((playerCount - 1));
        }
        else{
            throw new IndexOutOfBoundsException("Roster is empty");
        }
    }

    public int getPlayerCount(){
        return playerCount;
    }
}
