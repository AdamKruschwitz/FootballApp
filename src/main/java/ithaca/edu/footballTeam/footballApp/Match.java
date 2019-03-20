package ithaca.edu.footballTeam.footballApp;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Match {
    public List<Team> teams;
    public Team winner;
    public Date startTime;

    public Match(){
        teams = new ArrayList<>();
    }

    public Match(List<Team> teams, Date startTime) {
        this.teams = new ArrayList<>(teams);
        this.startTime = startTime;
    }

    public void setWinner(Team winner) {
        if(!teams.contains(winner)) throw new IllegalArgumentException("winner not in this match");
        this.winner = winner;
    }

    public Team getWinner() { return winner; }
}
