package ithaca.edu.footballTeam.footballApp;




public class Team {

    private Roster activeRoster;
    private Roster benchRoster;
    private String teamName;


    public Team(Roster activeRoster, String teamName){
        if(activeRoster.isEligible() == false) {
            throw new IllegalArgumentException("Entered team is not eligable to play");
        }
        else{
            this.activeRoster = activeRoster;
            this.teamName = teamName;
        }
    }

    public void setActiveRoster(Roster activeRoster){
        this.activeRoster = activeRoster;
    }

    public void setBenchRoster(Roster benchRoster){
        this.benchRoster = benchRoster;
    }

    public boolean isTeamEligible(){
        return activeRoster.isEligible();
    }


}
