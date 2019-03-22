package ithaca.edu.footballTeam.footballApp;

import java.util.ArrayList;
import java.util.List;

public class Roster {
    private boolean canPlay;
    private List<Player> players = new ArrayList<Player>();


    public Roster(boolean canPlay){
        this.canPlay = canPlay;
    }

    public boolean isEligible(){
        return (canPlay == true);
    }

    public void addPlayer(Player p){
        players.add(p);

    }

    public void removePlayer(){
        if(players.size()>0) {
            players.remove((players.size() - 1));
        }
        else{
            throw new IndexOutOfBoundsException("Roster is empty");
        }
    }

    public int getPlayerCount(){
        return players.size();
    }
}
