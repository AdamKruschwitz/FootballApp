package ithaca.edu.footballTeam.footballApp;

import java.util.List;
import java.util.ArrayList;

public class Round {
    private List<Match> currentMatches;
    private Round nextRound;

    Round() {
        currentMatches = new ArrayList<>();
        nextRound = null;
    }

    Round(List<Match> matches, Round nextRound) {
        this.currentMatches = new ArrayList<>(matches);
        this.nextRound = nextRound;
    }

    public void setWinner(Team winner, Match match) {
        if(!currentMatches.contains(match)) throw new IllegalArgumentException("match not in this round");
       // match.setWinner(winner);
    }

    public Round setUpNextRound(List<Match> matches, Round nextRound) {

        List<Team> tempTeams = new ArrayList<>();

        for (int i = 0; i < matches.size(); i++) {
            Team teamToAdd = matches.get(i).getWinner();
            tempTeams.add(teamToAdd);
        }
        matches.clear();
        for (int i = 0; i < tempTeams.size()/2; i++) {
            Match match = new Match(tempTeams.get(i),tempTeams.get(tempTeams.size()-(i+1)),i);
            match.setId(i+1);
            matches.add(match);
        }
        this.nextRound = new Round(matches, nextRound);

        return this.nextRound;
    }

    public List<Match> getCurrentMatches(){
        return this.currentMatches;
    }

    public void print(){
        for (int i = 0; i < currentMatches.size(); i++) {
            System.out.println(currentMatches.get(i).getTeam1().getTeamName() +" VS "+currentMatches.get(i).getTeam2().getTeamName());
        }

    }
}
