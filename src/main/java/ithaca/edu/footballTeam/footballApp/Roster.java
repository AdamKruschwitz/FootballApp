package ithaca.edu.footballTeam.footballApp;

public class Roster {
    private boolean canPlay;
    //private List<Player> Players = new ArrayList();
    private int playerCount;

    public Roster(boolean canPlay, int playerCount){
        this.canPlay = canPlay;
        this.playerCount = playerCount;
    }

    public boolean isEligable(){
        return (canPlay = true && playerCount > 10);
    }
}
