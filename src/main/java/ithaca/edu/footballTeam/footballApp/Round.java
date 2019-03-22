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

    public void setUpNextRound() {
        if(nextRound == null) throw new IllegalCallerException("There is no next round");
        // TODO: set up the next round from list of matches with winners.
    }
}
