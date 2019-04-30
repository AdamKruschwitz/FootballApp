package ithaca.edu.footballTeam.footballApp;


import java.util.*;

public class Tournament {

    private List<Team> teams;
    private String tournamentName;
    private Round currRound;
    private Round nextRound;
    private List<Match> matches;
    private Team winner;
    private int roundNUm;

    public Tournament(String name, Map<String, Team> teams){
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
        this.tournamentName = name;
        for (Map.Entry<String,Team> entry : teams.entrySet()){
            Team team = entry.getValue();
            if(team.getRank() <= 8 ){
                //team.resetStats();
                this.teams.add(team);
            }
        }

        for (int i = 0; i < this.teams.size()/2; i++) {
            Match match = new Match(this.teams.get(i),this.teams.get(this.teams.size()-(i+1)),i);
            match.setId(i+1);
           // match.print();
            matches.add(match);
        }

        this.currRound = new Round(matches,nextRound);
        roundNUm =1;
        teams.clear();
    }

    public Tournament(String name, List<Team> teams) {
        this.matches = new ArrayList<>();
        this.teams = new ArrayList<>();
        if (teams.size() < 4 || teams.size()%2 != 0) {
            throw new IllegalArgumentException("Invalid amount of teams ");
        } else {
            this.tournamentName = name;
            for (int i = 0; i < teams.size(); i++) {
                Team toAdd = teams.get(i);
                if (toAdd.getRank() <= 8 && toAdd.getRank() == i+1) {
                    //toAdd.resetStats();
                    this.teams.add(toAdd);
                }
            }

            for (int i = 0; i < this.teams.size()/2; i++) {
                Match match = new Match(this.teams.get(i),this.teams.get(this.teams.size()-(i+1)),i);
                match.setId(i+1);
                //match.print();
                matches.add(match);
            }

            this.currRound = new Round(matches, nextRound);
            roundNUm = 1;

        }
        teams.clear();
    }


    /**
     * Advances the tournament to the next round or ends tournament if there is no next round
     */
    public void goToNextRound(List<Match> matches) {
        if (matches.size() == 1) {
            winner= matches.get(0).getWinner();
            endTournament();

        } else {
            roundNUm++;
            this.currRound = currRound.setUpNextRound(matches, nextRound, teams);
        }
    }

    /**
     * Gets the number of current round
     * @return int
     */
    public int getRoundNUm(){return this.roundNUm;}
    /**
     * Adds a team to the tournament
     * @param team
     */
    public void addTeam(Team team){
        if(team.isTeamEligible()) {
            teams.add(team);
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
        Team toRemove = new Team();
        for (int i = 0; i < this.teams.size() ; i++) {
            Team temp = this.teams.get(i);
            if(temp.getTeamName().equals(teamName)){
                teams.remove(i);
                toRemove = temp;
                break;
            }
        }
        if(!toRemove.getTeamName().equals(teamName)){
            throw new NullPointerException("This team does not exist in this tournament. ");
        }
    }

    /**
     * Returns the tournamentID
     * @return tournamentID
     */
    public String getTournamentID(){
        return tournamentName;
    }

    /**
     * Finds and returns a team from the tournament
     * @param teamName
     * @return Team or NullPointerException  if not found
     */
    public Team getTeam(String teamName) {
        Team toReturn = new Team();
        for (int i = 0; i < this.teams.size(); i++) {
            Team temp = this.teams.get(i);
            if (temp.getTeamName().equals(teamName)) {
                toReturn = temp;
            }
        }
        if(!toReturn.getTeamName().equals(teamName)){
            throw new NullPointerException("This team does not exit in this tournament");
        }else {
            return toReturn;
        }
    }

    /**
     * Prints out a visual of the current leaderboard for the tournament
     */
    public void showMatchesForCurrentRound(){
        currRound.print();
    }

    public List<Team> getTeams(){return this.teams;}

    /**
     * Prints out the current list of teams in the tournament
     */
    public void showTeams() {
        for (int i = 0; i < this.teams.size(); i++) {
            Team team = teams.get(i);
            System.out.println("Tournament Name: "+tournamentName+"\n"+"Team Name: " + team.getTeamName() + "\n" + "League Rank: " + team.getRank());
        }

        }
    public Round getCurrRound(){return this.currRound;}


    /**
     * Prints out the winner of the tournament
     */
    private void endTournament(){
        System.out.println("\nThe winner of the tournament is "+winner.getTeamName()+"!");
        }
    }


