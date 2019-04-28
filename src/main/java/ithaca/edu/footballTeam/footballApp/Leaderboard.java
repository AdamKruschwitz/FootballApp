package ithaca.edu.footballTeam.footballApp;


import java.util.*;


public class Leaderboard {
    //variables
    private Map<String, Integer> leaderBoard = new HashMap<String, Integer>();
    private List<Map.Entry<String, Integer>> orderedScores;


    /**
     * @param teams takes in as an input the list of teams that will be participating in the League
     *              Creates a board that includes the team name and the team score in terms of points all teams start off with 0 points
     */
    //constructors
    public Leaderboard(List<Team> teams) {
        Iterator<Team> itr = teams.iterator();
        while (itr.hasNext()) {
            leaderBoard.put(itr.next().getTeamName(), 0);
        }
    }

    /**
     * @param playedMatch The completed match with the statistics that you want to update the leader board with
     *                    Takes a completed match and proceeds to extract the game information relevant to the leader board from it
     */
    public void updateLeaderBoard(Match playedMatch) {
        if (leaderBoard.containsKey(playedMatch.getTeam1().getTeamName())
                && leaderBoard.containsKey(playedMatch.getTeam2().getTeamName())) {
            if (playedMatch.isTie()) {
                leaderBoard.put(playedMatch.getTeam1().getTeamName(), leaderBoard.get(playedMatch.getTeam1().getTeamName()) + 1);
                leaderBoard.put(playedMatch.getTeam2().getTeamName(), leaderBoard.get(playedMatch.getTeam2().getTeamName()) + 1);
            } else {
                leaderBoard.put(playedMatch.getWinner().getTeamName(), leaderBoard.get(playedMatch.getWinner().getTeamName()) + 3);
            }
            // 1. Convert Map to List of Map
            List<Map.Entry<String, Integer>> leagueScores =
                    new ArrayList<Map.Entry<String, Integer>>(leaderBoard.entrySet());

            // 2. Sort list with Collections.sort(), provide a custom Comparator
            //    Try switch the o1 o2 position for a different order
            Collections.sort(leagueScores, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> o1,
                                   Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            orderedScores = leagueScores;



        } else {
            throw new IllegalArgumentException("Teams in match are not on leaderboard");
        }
    }

    /**
     * @param team team whose league score you wish to see
     * @return the team's league score from the leader board
     * requires the team to be in the leader board
     */
    public int getTeamPoints(String team) {
        if (leaderBoard.containsKey(team)) {
            return leaderBoard.get(team);
        } else {
            throw new IllegalArgumentException("Team name not in leaderboard");
        }
    }

    public Iterator<Map.Entry<String, Integer>> getLeaderBoard() {
        return orderedScores.iterator();
    }
}
