package ithaca.edu.footballTeam.footballApp;

public class Team {

    private Roster activeRoster;
    private Roster benchRoster;
    private String teamName;
    private int teamId;
    private String tournamentID;
    private teamOwner owner;


    public Team(Roster activeRoster, String teamName){
        if(activeRoster.isEligible() == false) {
            throw new IllegalArgumentException("Entered team is not eligible to play");
        }
        else{
            this.activeRoster = activeRoster;
            this.teamName = teamName;
        }
    }

    public Team(Roster activeRoster, String teamName, String tournamentID, teamOwner owner){
        if(activeRoster.isEligible() == false) {
            throw new IllegalArgumentException("Entered team is not eligible to play");
        }
        else{
            this.activeRoster = activeRoster;
            this.teamName = teamName;
            this.tournamentID = tournamentID;
            this.owner = owner;

        }
    }

    public void setActiveRoster(Roster activeRoster){
        if(activeRoster.isEligible() == false) {
            throw new IllegalArgumentException("Entered team is not eligible to play");
        }
        else{
            this.activeRoster = activeRoster;

        }
    }

    public String getTeamName(){
        return this.teamName;
    }

    public String getTournamentID(){
        return this.tournamentID;
    }
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }

    public  void setTeamId(int teamId){
        this.teamId = teamId;
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

    public boolean isValid(){
        return true;
    }

}
