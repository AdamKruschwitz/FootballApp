package ithaca.edu.footballTeam.footballApp;

public class Team {

    private Roster activeRoster;
    private Roster benchRoster;
    private String teamName;
    private int teamId;
    private String tournamentID;

    public Team() {}

    public Team(Roster activeRoster, String teamName){
        if(activeRoster.isEligible() == false) {
            throw new IllegalArgumentException("Entered team is not eligible to play");
        }
        else{
            this.activeRoster = activeRoster;
            this.teamName = teamName;
        }
    }

    public Team(Roster activeRoster, String teamName, String tournamentID){
        if(activeRoster.isEligible() == false) {
            throw new IllegalArgumentException("Entered team is not eligible to play");
        }
        else{
            this.activeRoster = activeRoster;
            this.teamName = teamName;
            this.tournamentID = tournamentID;
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

    public String getTeamName() {
        return teamName;
    }

    public void setBenchRoster(Roster benchRoster){
        this.benchRoster = benchRoster;
    }

    public boolean isTeamEligible(){
        return activeRoster.isEligible();
    }

    public void setTournamentID(String tournamentID){
        this.tournamentID = tournamentID;
    }

}
