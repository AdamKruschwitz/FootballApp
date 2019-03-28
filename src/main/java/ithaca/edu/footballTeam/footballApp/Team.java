package ithaca.edu.footballTeam.footballApp;

public class Team {

    private Roster activeRoster;
    private Roster benchRoster;
    private String teamName;
    private int teamId;
    private String tournamentID;
    private teamOwner owner;
    private int rank;



    public Team(){}


    /**
     *
     * @param activeRoster the active roster that will be playing during a match roster is eligible
     *                     when all players within the roster can play and roster count is
     *                     11
     * @param teamName the team name for the team
     */
    public Team(Roster activeRoster, String teamName){
        if(activeRoster.isEligible() == false) {
            throw new IllegalArgumentException("Entered team is not eligible to play");
        }
        else{
            this.activeRoster = activeRoster;
            this.teamName = teamName;
        }
    }

    /**
     *
     * @param activeRoster the active roster that will be playing during a match roster is eligible
     *                     when all players within the roster can play and roster count is
     *                     11
     * @param teamName the team name for the team
     * @param tournamentID the tournament ID or league ID that the team is participating in
     */
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

    /**
     *
     * @param activeRoster sets the active roster to the passed in roster
     *                     Roster must be a valid rosted where every player within the roster is eligible to play
     *                     and the roster count is 11
     */

    public void setActiveRoster(Roster activeRoster){
        if(activeRoster.isEligible() == false) {
            throw new IllegalArgumentException("Entered team is not eligible to play");
        }
        else{
            this.activeRoster = activeRoster;

        }
    }

    /**
     *
     * @return the team name
     */
    public String getTeamName(){
        return this.teamName;
    }

    /**
     *
     * @return the tournament ID or League ID
     */

    public String getTournamentID(){
        return this.tournamentID;
    }

    /**
     *
     * @param teamName sets the team name for this team
     */
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }

    /**
     *
     * @param teamId sets the team ID to passed in argument
     */
    public  void setTeamId(int teamId){
        this.teamId = teamId;
    }

    /**
     *
     * @param benchRoster roster
     * allows a benched roster to be set
     */
    public void setBenchRoster(Roster benchRoster){
        this.benchRoster = benchRoster;
    }

    /**
     *
     * @return a boolean that denotes if the active roster has the
     * right amount of players and that each player within the roster is eligible to play
     */
    public boolean isTeamEligible(){
        return activeRoster.isEligible();
    }

    /**
     *
     * @param tournamentID sets the tournament ID to the passed in argument
     */
    public void setTournamentID(String tournamentID){
        this.tournamentID = tournamentID;
    }


    /**
     *
     * @param teamOwner sets the team owner for this team
     */


    public void setOwner(teamOwner teamOwner){
        this.owner = teamOwner;
    }

    /**
     * Updates rank for team based on leaderboard
     * @param num
     */
    public void updateRank(int num){
        if(num>0) {
            this.rank = num;
        }
        else{
            throw new IllegalArgumentException("Value is invalid");
        }
    }

    /**
     * Gets the rank of team
     * @return int
     */
    public int getRank(){
        return this.rank;
    }




}
