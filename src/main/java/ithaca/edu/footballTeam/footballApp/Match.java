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
}
