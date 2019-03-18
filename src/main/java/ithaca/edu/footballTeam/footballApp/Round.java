package ithaca.edu.footballTeam.footballApp;

import java.util.List;
import java.util.ArrayList;

public class Round {
    private List<Match> currentMatches;
    private Round nextRound;
    private List<Team> winners;
    private List<Match> finishedMatches;

    Round() {
        currentMatches = new ArrayList<>();
        nextRound = null;
        winners = new ArrayList<>();
        finishedMatches = new ArrayList<>();
    }

    Round(List<Match> matches, Round nextRound) {

    }

    public void setWinner(Team winner, Match match) {
        if(!currentMatches.contains(match)) throw new IllegalArgumentException("match not in this round");
        if(!match.teams.contains(winner)) throw new IllegalArgumentException("winner not in this match");

        winners.add(winner);
        currentMatches.remove(match);
        finishedMatches.add(match);
    }

    public void setUpNextRound() {
        if(nextRound == null) throw new IllegalCallerException("There is no next round");

    }
}
