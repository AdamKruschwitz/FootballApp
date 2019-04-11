package ithaca.edu.footballTeam.footballApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Roster {
    private boolean canPlay;
    private List<Player> players = new ArrayList<Player>();



    /**
     *
     * @return true if the roster has only eligible players and the roster count is greater than 10
     */
    public boolean isEligible(){
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()){
            if(iterator.next().isEligible() != true){
                canPlay = false;
                break;
            }
            else {
                canPlay = true;
            }
        }
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
    public void removePlayer(int i){
        if(players.size()>0) {
            players.remove(i);
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

    /**
     * Helper method to fill a roster with valid players
     */
    public void fillWithValidPlayers(){
        for(int i = 0; i < 11; i++){
            Player p = new Player(Integer.toString(i),i);
            addPlayer(p);
        }
    }

    public Player getPlayer(int id){
        return players.get(id);

    }
}
