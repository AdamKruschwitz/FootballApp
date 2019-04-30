package ithaca.edu.footballTeam.footballApp;

import java.util.Iterator;
import java.util.Map;

public class Match {
    private int id;
    private Team team1;
    private Team team2;
    private int team1Score;
    private int team2Score;

    public Match(Team team1, Team team2, int id){
        this.team1 = team1;
        this.team2 = team2;
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){this.id = id; }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public void setTeam2(Team team2){
        this.team2 = team2;
    }

    public Team getTeam1(){return this.team1;}

    public Team getTeam2(){return this.team2;}

    public void setTeam1Score(int team1Score){
        this.team1Score = team1Score;
        team1.addToScoredGoals(team1Score);
        team2.addToScoredOnGoals(team1Score);
    }

    public void setTeam2Score(int team2Score){
        this.team2Score = team2Score;
        team2.addToScoredGoals(team2Score);
        team1.addToScoredOnGoals(team2Score);
    }

    public boolean isTie(){
        if(team1Score == team2Score){
            return true;
        }
        return false;
    }

    public Team getWinner(){
        if(team1Score > team2Score){
            return team1;
        }
        return team2;
    }

    public Team getLoser(){
        if(team1Score < team2Score){
            return team1;
        }
        return team2;

    }

    /**
     * Add a goal in this match and increase the .
     * @param team
     */
    public void addGoal(int team) {
        Team temp = null;

        // Get the team to work with
        switch(team) {
            case 0:
                temp = team1;
                team1Score++;
                break;
            case 1:
                temp = team2;
                team2Score++;
                break;
        }

        temp.addToScoredGoals(1);
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void print(){
        System.out.println(team1.getTeamName() + " VS"+ team2.getTeamName());
    }

    public String showPlayersInMatch(){
        String Teams = "";
        Iterator<Player> team1Itr = team1.getActiveRoster().players.iterator();
        Iterator<Player> team2Itr = team2.getActiveRoster().players.iterator();


        while (team1Itr.hasNext() && team2Itr.hasNext()){

            Teams = Teams + team1.getTeamName() + " player: " + team1Itr.next().name + " " +   team2.getTeamName() + " player: " + team2Itr.next().name  + "\n";


        }
        return Teams;

    }
}
