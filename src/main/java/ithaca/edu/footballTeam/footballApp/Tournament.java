package ithaca.edu.footballTeam.footballApp;

import java.util.List;
import java.util.ArrayList;

public class Tournament {

    private List<Round> rounds;

    public Tournament() {
        rounds = new ArrayList<>();
    }

    public Tournament(List<Round> rounds) {
        this.rounds = new ArrayList<>(rounds);
    }
}
