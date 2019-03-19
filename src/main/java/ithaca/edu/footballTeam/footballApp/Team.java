package ithaca.edu.footballTeam.footballApp;




public class Team {

    private Roster activeRoster;
    private Roster benchRoster;


    public Team(Roster activeRoster){
        if(activeRoster.isEligable() == false) {
            throw new IllegalArgumentException("Entered team is not eligable to play");
        }
        else{
            this.activeRoster = activeRoster;
        }
    }

    public void setActiveRoster(Roster activeRoster){
        this.activeRoster = activeRoster;
    }

    public void setBenchRoster(Roster benchRoster){
        this.benchRoster = benchRoster;
    }

    public boolean isTeamElgable(){
        return activeRoster.isEligable();
    }


}
