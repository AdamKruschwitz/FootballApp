package ithaca.edu.footballTeam.footballApp;


import java.util.*;

public class Tournament {

    private List<Team> teams;
    private String tournamentName;
    private Round r1;
    private Round r2;
    private Round r3;
    private Round currRound;
   // private Leaderboard leaderboard;
    private List<Match> matches;

    public Tournament(String name, HashMap<String, Team> teams){
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
        this.tournamentName = name;
        for (Map.Entry<String,Team> entry : teams.entrySet()){
            Team team = entry.getValue();
            if(team.getRank() <= 8){
                this.teams.add(team);
            }
        }

        for (int i = 0; i < this.teams.size()/2; i++) {
            Match match = new Match(this.teams.get(i),this.teams.get(this.teams.size()-(i+1)),i);
            match.setId(i+1);
            match.print();
            matches.add(match);
        }

        this.r1 = new Round(matches,r2);
        this.r2 = new Round(matches,r3);
        this.r3 = new Round(matches,null);
        this.currRound = r1;
        //this.leaderboard = new Leaderboard();
    }

    public Tournament(String name, List<Team> teams) {
        this.matches = new ArrayList<>();
        this.teams = new ArrayList<>();
        if (teams.size() < 8) {
            throw new IllegalArgumentException("Not enough teams to start a tournament");
        } else {
            this.tournamentName = name;
            for (int i = 0; i < teams.size(); i++) {
                Team toAdd = teams.get(i);
                if (toAdd.getRank() <= 8) {
                    this.teams.add(toAdd);
                }
            }

            for (int i = 0; i < this.teams.size()/2; i++) {
                Match match = new Match(this.teams.get(i),this.teams.get(this.teams.size()-(i+1)),i);
                match.setId(i+1);
                match.print();
                matches.add(match);
            }

            this.r1 = new Round(matches, r2);
            this.r2 = new Round(matches, r3);
            this.r3 = new Round(matches, null);
            this.currRound = r1;
            //this.leaderboard = new Leaderboard();
        }
    }

    public Tournament(String name){
        this.tournamentName = name;
        this.teams = new ArrayList<>();
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
    public void showLeaderboard(){}

    /**
     * Updates the leaderboard for the tournament
     */
    public void updateLeaderboard() {}

    public void showTeams() {
        for (int i = 0; i < this.teams.size(); i++) {
            Team team = teams.get(i);
            System.out.println("Tournament Name: "+tournamentName+"\n"+"Team Name: " + team.getTeamName() + "\n" + "Team Rank: " + team.getRank());
        }

        }

    public void runRound(){

        Scanner reader = new Scanner(System.in);

        for (int i = 0; i < matches.size(); i++) {
            Match currMatch = matches.get(i);
            System.out.println("How many goals did "+currMatch.getTeam1().getTeamName()+" score?");
            while (!reader.hasNextInt()){
                System.out.println("please enter a valid number: ");
                reader.next();
            }
            int option = reader.nextInt();
            currMatch.setTeam1Score(option);
            System.out.println("How many goals did "+currMatch.getTeam2().getTeamName()+" score?");
            while (!reader.hasNextInt()){
                System.out.println("please enter a valid number: ");
                reader.next();
            }
            option = reader.nextInt();
            currMatch.setTeam2Score(option);
            }

        for (int i = 0; i < matches.size() ; i++) {
            Match currMatch = matches.get(i);
            System.out.println("Winner of match "+currMatch.getId()+": "+currMatch.getWinner().getTeamName());
        }
    }
    }


