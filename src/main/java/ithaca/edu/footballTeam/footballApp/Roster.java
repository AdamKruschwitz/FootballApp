package ithaca.edu.footballTeam.footballApp;

import java.util.ArrayList;
import java.util.List;

public class Roster {
    private boolean canPlay;
    private List<Player> players = new ArrayList<Player>();

    /**
     *
     * @param canPlay hard coded boolean that determines if the roster is a playable roster
     */
    public Roster(boolean canPlay){
        this.canPlay = canPlay;
    }

    /**
     *
     * @return true if the roster has only eligible players and the roster count is greater than 10
     */
    public boolean isEligible(){
        return (canPlay == true && players.size() > 10);
    }

    /**
     *
     * @param p adds a player to the roster
     */
    public void addPlayer(Player p){
        players.add(p);

    }

    /**
     * removes a player from the roster
     */
    public void removePlayer(){
        if(players.size()>0) {
            players.remove((players.size() - 1));
        }
        else{
            throw new IndexOutOfBoundsException("Roster is empty");
        }
    }

    /**
     *
     * @return a count of all the players within the roster
     */
    public int getPlayerCount(){
        return players.size();
    }
}
