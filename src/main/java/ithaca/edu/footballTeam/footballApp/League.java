package ithaca.edu.footballTeam.footballApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class League {
    private String leagueName;
    private int leagueID;
    private List<Team> participants;
    private Leaderboard scoreboard;
    private List<Match> leagueMatches;

    /**
     *
     * @param leagueName name of the league
     * @param leagueID id of the league
     * @param participants participants of the league
     *
     * Paticipant list size must be even and participant teams must be eligible to play with valid active rosters
     */

    public  League(String leagueName, int leagueID, List<Team> participants){
        if(participantsValid(participants)){
            this.leagueID = leagueID;
            this.leagueName = leagueName;
            this.participants = participants;
            this.scoreboard = new Leaderboard(participants);
        }
        else {
            throw new IllegalArgumentException("Invalid team in participants or invalid participants size");
        }

    }

    /**
     *
     * @param participants list of participating teams
     * @return boolean if the participating teams are all valid
     */

    public static boolean participantsValid(List<Team> participants){
        for(int i = 0; i < participants.size(); i++){
            if(participants.get(i).isTeamEligible() == false){
                return false;
            }
        }
        return true;

    }

    /**
     *
     *
     * Teams must be valid and team numbers have to be even
     * This creates all of the matches for the games to be played within a league season
     */

    public Iterator<Match> generateLeagueMatches(){
        if(participantsValid(participants)) {
             leagueMatches = new ArrayList<>();
            for (int i = 0; i < participants.size(); i++) {
                for(int j =i+1; j < participants.size(); j++){
                    Match match = new Match(participants.get(i), participants.get(j), i + j);
                    leagueMatches.add(match);
                }
            }
        }
        else {
            throw new IllegalArgumentException("Participating teams does not have an even number");
        }
        return leagueMatches.iterator();
    }

    /**
     *
     * @param team team to be added
     * Checks to make sure that the team to be added is eligible to play in the league then the team is added
     */
    public void addTeam(Team team){
        if(team.isTeamEligible()){
            participants.add(team);
        }
        else{
            throw new IllegalArgumentException("Team to be added not eligible to be added");
        }

    }

    /**
     *
     * @param teamName name of the team you want to remove
     * @return the team you wanted removed or null if the team wasn't in the list
     */
    public  Team removeTeam(String teamName){
        Iterator<Team> itr = participants.iterator();
        while(itr.hasNext()){
            Team team = itr.next();
            if(team.getTeamName() == teamName){
                itr.remove();
                return team;
            }
        }
        return null;
    }


    /**
     *
     * @return the leaderboard associated with this class with the updated scores and rankings
     */
  public Iterator<Map.Entry<String, Integer>> updateLeaderBoard(){
        Iterator<Match> itr = leagueMatches.iterator();
        while (itr.hasNext()){
            scoreboard.updateLeaderBoard(itr.next());
        }
        return this.scoreboard.getLeaderBoard();
  }

    /**
     *
     * @return list of teams in the league
     */
  public List<Team> getParticipants(){
      return this.participants;
  }

  public Team findTeamByName(String teamName){
      for(int i = 0; i < participants.size(); i++){
          if(participants.get(i).getTeamName() == teamName){
              return participants.get(i);
          }
      }
      return null;

  }

  public String getSocreBoardWinLossTie(){
      Iterator<Map.Entry<String, Integer>> scores = scoreboard.getLeaderBoard();
      String scoreBoard = leagueName + " Team win-loss-ties and league points" + "\n";
      while (scores.hasNext()){
          Map.Entry<String, Integer> item = scores.next();
          scoreBoard = scoreBoard + " Team: " + item.getKey() + " League Points " + item.getValue() + " Wins "
                  + findTeamByName(item.getKey()).getWins() + " ties " + findTeamByName(item.getKey()).getTie() +
                    " losses " + findTeamByName(item.getKey()).getLoss() + "\n";


      }
      return scoreBoard;
  }

  public String getScoreBoardGoals(){
      Iterator<Map.Entry<String, Integer>> scores = scoreboard.getLeaderBoard();
      String scoreBoard = leagueName + " Team goals and league points " + "\n";
      while (scores.hasNext()){
          Map.Entry<String, Integer> item = scores.next();
          scoreBoard = scoreBoard + " Team: " + item.getKey() + " League Points " + item.getValue() + " Goals "
                  + findTeamByName(item.getKey()).getTotalGoalsScored() + "\n";


      }
      return scoreBoard;

  }





}
