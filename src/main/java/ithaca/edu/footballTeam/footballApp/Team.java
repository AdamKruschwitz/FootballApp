package ithaca.edu.footballTeam.footballApp;

public class Team implements Comparable<Team> {

    private Roster activeRoster;
    private Roster benchRoster;
    private String teamName;
    private int teamId;
    private String tournamentID;
    private teamOwner owner;
    private int rank;
    private int totalGoalsScored;
    private int totalGoalsScoredOn;
    private int totalAssists;



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
    public int getRank() {
        return this.rank;
    }

    /**
     *
     * @return whether a team is eligible or not based on whether a teams's active roster is eligible or not
     */
    public boolean isValid(){
        return activeRoster.isEligible();

    }

    /**
     *
     * @param id id for the player you are trying to get
     * @return the player
     * player id will just correspond to index in list
     * later player id will be a unique identifier for a player
     */
    public  Player getPlayer(int id){
        return this.activeRoster.getPlayer(id);
    }

    /**
     *
     * @param goalAmount total amount of goals scored at the end of a match
     * adds the total amount of goals scored for a team in a match to a total amount scored for the life time of the team
     */
    public void addToScoredGoals(int goalAmount){
        this.totalGoalsScored = this.totalGoalsScored + goalAmount;
    }

    public int getTotalGoalsScored() {
        return totalGoalsScored;
    }

    /**
     *
     * @param goalAmount total amount of goals scored on this team at the end of a match
     * adds the total amount of goals scored  on  a team in a match to the total lifetime goals scored on this team
     */
    public  void addToScoredOnGoals(int goalAmount){
        this.totalGoalsScoredOn = this.totalGoalsScoredOn + goalAmount;
    }


    /**
     *
     * @param team another team
     * @return whether this team is higher or lower ranked than the other team or if they are even
     * this is here in the case of two teams with the same points value, you can simply comapare two teams to get which team is better
     */
    @Override
    public int compareTo(Team team) {
        if((this.totalGoalsScored/this.totalGoalsScoredOn) > (team.totalGoalsScored/team.totalGoalsScoredOn)){
            return 1;
        }
        else if((this.totalGoalsScored/this.totalGoalsScoredOn) < (team.totalGoalsScored/team.totalGoalsScoredOn)){
            return -1;
        }
        return 0;
    }

    /**
     * Gets the total number of assists that the team has accumulated
     * @return int
     */
    public int getTotalAssists(){return this.totalAssists;}

    /**
     * Increments the total number of assists that the team has by 1
     */
    public void addAssist(){this.totalAssists++;}

    /**
     * Gets the total number of goals that has been scored on the team
     * @return int
     */
    public int getTotalGoalsScoredOn(){return this.totalGoalsScoredOn;}

    /**
     * Prints out a list of players in the team's roster
     */
    public void showPlayers(){
        activeRoster.showPlayer();
    }

    protected void resetStats(){
        this.totalAssists = 0;
        this.totalGoalsScored = 0;
        this.totalGoalsScoredOn = 0;

        for (int i = 0; i < activeRoster.getPlayerCount(); i++) {
            Player player = activeRoster.getPlayer(i);
            player.resetStats();
        }
    }
}
