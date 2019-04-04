package ithaca.edu.footballTeam.footballApp;

import java.util.Date;

public class Match {
    private int id;
    private Team team1;
    private Team team2;
    private int team1Score;
    private int team2Score;
    public Date startTime;

    public Match(Team team1, Team team2, Date startTime, int id){
        this.team1 = team1;
        this.team2 = team2;
        this.id = id;
        this.startTime = startTime;
    }

    public int getId(){
        return this.id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public void setTeam2(Team team2){
        this.team2 = team2;
    }

    public Team getTeam1() { return this.team1; }

    public Team getTeam2() { return this.team2; }

    public void setTeam1Score(int team1Score){
        this.team1Score = team1Score;
    }

    public void setTeam2Score(int team2Score){
        this.team2Score = team2Score;
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
}
