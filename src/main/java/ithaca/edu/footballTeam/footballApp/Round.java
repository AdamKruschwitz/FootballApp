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

    /**
     * Sets up the matches for the next round based on the winner from the previous round
     * @param matches
     * @param nextRound
     * @param teams
     * @return Round next round
     */
    public Round setUpNextRound(List<Match> matches, Round nextRound, List<Team> teams) {

        List<Team> tempTeams = new ArrayList<>();
        /*if(teams.size()%2 != 0) {
            Team oddTeam = new Team();
            for (int i = 0; i < teams.size(); i++) {
                for (int j = 0; j < matches.size(); j++) {
                    if (!teams.get(i).getTeamName().equals(matches.get(i).getTeam1().getTeamName()) || !teams.get(i).getTeamName().equals(matches.get(i).getTeam2().getTeamName())) {
                        oddTeam = teams.get(i);
                    }
                }
            }
            tempTeams.add(oddTeam);
        }*/


        for (int i = 0; i < matches.size(); i++) {
            Team teamToAdd = matches.get(i).getWinner();
            if(teamToAdd.getTeamName().equals(matches.get(i).getTeam1().getTeamName())){
                Team toRemove = matches.get(i).getTeam2();
                teams.remove(toRemove);
            }else{
                Team toRemove = matches.get(i).getTeam1();
                teams.remove(toRemove);
            }

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

    /**
     * prints out the match ups for the current round
     */
    public void print(){
        for (int i = 0; i < currentMatches.size(); i++) {
            System.out.println(currentMatches.get(i).getTeam1().getTeamName() +" VS "+currentMatches.get(i).getTeam2().getTeamName());
        }

    }
}
