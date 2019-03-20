package ithaca.edu.footballTeam.footballApp;




public class Team {

    private Roster activeRoster;
    private Roster benchRoster;
    private String teamName;
    private int teamId;
    private String tournamentID;


    public Team(Roster activeRoster, String teamName){
        if(activeRoster.isEligible() == false) {
            throw new IllegalArgumentException("Entered team is not eligible to play");
        }
        else{
            this.activeRoster = activeRoster;
            this.teamName = teamName;
        }
    }

    public void setActiveRoster(Roster activeRoster){
        if(activeRoster.isEligible() == false) {
            throw new IllegalArgumentException("Entered team is not eligible to play");
        }
        else{
            this.activeRoster = activeRoster;
            this.teamName = teamName;
        }
    }

    public void setBenchRoster(Roster benchRoster){
        this.benchRoster = benchRoster;
    }

    public boolean isTeamEligible(){
        return activeRoster.isEligible();
    }




}
