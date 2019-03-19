package ithaca.edu.footballTeam.footballApp;

public class Roster {
    private boolean canPlay;
    //private List<Player> Players = new ArrayList();

    public Roster(boolean canPlay){
        this.canPlay = canPlay;

    }

    public boolean isEligable(){
        return this.canPlay;
    }
}
