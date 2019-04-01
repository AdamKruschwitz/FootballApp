package ithaca.edu.footballTeam.footballApp;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tournament {

    private HashMap<String, Team> teams;
    private String tournamentName;
    private Round r1;
    private Round r2;
    private Round r3;
    private Round currRound;
   // private Leaderboard leaderboard;
    private List<Match> matches;

    public Tournament(String name, HashMap<String, Team> teams){
        this.tournamentName = name;
        for (Map.Entry<String,Team> entry : teams.entrySet()){
            Team team = entry.getValue();
            if(team.getRank() <= 8){
                this.teams.put(team.getTeamName(),team);
            }
        }
       // this.r1 = new Round(matches,r2);
       // this.r2 = new Round(matches,r3);
       // this.r3 = new Round(matches,null);
       // this.currRound = r1;
        //this.leaderboard = new Leaderboard();
    }

    public Tournament(String name, List<Team> teams) {
        this.teams = new HashMap<String, Team>();
        if (teams.size() < 8) {
            throw new IllegalArgumentException("Not enough teams to start a tournament");
        } else {
            this.tournamentName = name;
            for (int i = 0; i < teams.size(); i++) {
                Team toAdd = teams.get(i);

                this.teams.put(toAdd.getTeamName(), toAdd);
            }

//            this.r1 = new Round(matches, r2);
  //          this.r2 = new Round(matches, r3);
    //        this.r3 = new Round(matches, null);
      //      this.currRound = r1;
            //this.leaderboard = new Leaderboard();
        }
    }

    public Tournament(String name){
        this.tournamentName = name;
        this.teams = new HashMap<String,Team>();
       // this.r1 = new Round(matches,r2);
        //this.r2 = new Round(matches,r3);
        //this.r3 = new Round(matches,null);
        //this.currRound = r1;
        //this.leaderboard = new Leaderboard();

    }

    /**
     * Advances the tournament to the next round
     */
    public void goToNextRound(){
        if(currRound == r1){
            currRound = r2;
        }else if(currRound == r2){
            currRound = r3;
        }else{
            throw new IllegalStateException("Tournament is already in final round");
        }
    }

    /**
     * Adds a team to the tournament
     * @param team
     */
    public void addTeam(Team team){
        if(team.isTeamEligible()) {
            teams.put(team.getTeamName(), team);
        }
        else{
            throw new IllegalArgumentException("Team is not eligible");
        }
    }

    /**
     * Removes a team from the tournament based on team name
     * @param teamName
     */
    public void removeTeam(String teamName){
        Team teamToRemove = teams.get(teamName);
        if(teamToRemove!=null){
            teams.remove(teamName);
        }else{
            throw new NullPointerException("This team does not exist in this tournament");
        }
    }

    /**
     * Returns the tournamentID
     * @return tournamentID
     */
    public String getTournamentID(){
        return tournamentName;
    }

    public Team getTeam(String teamName) {
        if (teams.get(teamName) == null) {
            throw new NullPointerException("Team does not exist");
        } else {
            Team toReturn = teams.get(teamName);
            return toReturn;
        }
    }

    /**
     * Prints out a visual of the current leaderboard for the tournament
     */
    public void showLeaderboard(){}

    /**
     * Updates the leaderboard for the tournament
     */
    public void updateLeaderboard() {}

    public void showTeams() {
        for (Map.Entry<String, Team> entry : teams.entrySet()) {
            Team team = entry.getValue();
            System.out.println("Tournament Name: "+tournamentName+"\n"+"Team Name: " + team.getTeamName() + "\n" + "Team Rank: " + team.getRank());
        }
    }



}
