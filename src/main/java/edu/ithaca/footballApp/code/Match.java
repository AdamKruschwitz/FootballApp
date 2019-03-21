package edu.ithaca.footballApp.code;

public class Match {
    private int id;
    private Team team1;
    private Team team2;
    private int team1Score;
    private int team2Score;

    public int getId(){
        return this.id;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public void setTeam2(Team team2){
        this.team2 = team2;
    }

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
