package ithaca.edu.footballTeam.footballApp;

import java.util.*;

public class League {
    private String leagueName;
    private int leagueID;
    private List<Team> participants;
    private Leaderboard scoreboard;
    private List<Match> leagueMatches;
    private List<Iterator<Match>> weekends;


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
     * @param array array of league matches
     * @return array of league matches that have been randomized
     */
    public List<Match> randomizeArray(List<Match> array){
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<array.size(); i++) {
            int randomPosition = rgen.nextInt(array.size());
            Match temp = array.get(i);
            array.set(i,array.get(randomPosition));
            array.set(randomPosition, temp);
        }
        return array;
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
             int count = 0;
            List<Integer> usedIds = new ArrayList<>();
            for (int i = 0; i < participants.size(); i++) {
                for(int j =i+1; j < participants.size(); j++){
                    Match match = new Match(participants.get(i), participants.get(j), count);
                    count++;
                    Match match2 = new Match(participants.get(j), participants.get(i), count);
                    count++;
                    leagueMatches.add(match);
                    leagueMatches.add(match2);




                }
            }

        }
        else {
            throw new IllegalArgumentException("Participating teams does not have an even number");
        }

       List<Match> randMatches = randomizeArray(leagueMatches);
       this.leagueMatches = randMatches;
        return leagueMatches.iterator();
    }

    public String showLeagueMatchUps(){
        String leagueMatchUps = this.leagueName + " " + " match ups" + "\n";
        Iterator<Match> itr = this.leagueMatches.iterator();
        while (itr.hasNext()){
            Match match = itr.next();
            leagueMatchUps = leagueMatchUps + match.getTeam1().getTeamName() + " vs " + match.getTeam2().getTeamName() + "\n";

        }
        return leagueMatchUps;

    }

    /**
     *
     * @param playedCount counts of how many times a team has played
     * @param team the paticular team we wish to know if it has played
     * @param count the current count of played games
     * @return whether a paticular team has played already
     *
     */

    public static boolean hasPlayed(Map<String, Integer> playedCount, Team team, int count){
        if(playedCount.get(team.getTeamName()) < count){
            return false;
        }
        return true;

    }

    /**
     *
     * @param played list of match id's that have already been played
     * @param currentMatch match to be checked
     * @return if this match is good to be used for a weekend true false
     */

    public static boolean hasBeenPlayed(List<Match> played, Match currentMatch){
        if(played.contains(currentMatch)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     *
     * @param match the match that is being checked to see if it is an eligible match to be put into a particular weekend
     * @param playedMatches a list of match id's that have already been played in different weekends
     * @param playedCount the number of times a team has already played
     * @param count the current played number that a team should have if they have already played
     * @return whether this match is eligible to be placed into a weekend in the form of a boolean
     */

    public static boolean isEligible(Match match, List<Match> playedMatches,Map<String, Integer> playedCount,int count ){
        if(hasBeenPlayed(playedMatches,match) == false){
            if(hasPlayed(playedCount,match.getTeam1(),count) == false
                    && hasPlayed(playedCount, match.getTeam2(), count) == false ){
                return true;


            }
        }
        return false;

    }

    /**
     *
     * @param matchAmounts the empy mapping between teams and the number of times they have played
     * @return initialization of the teamnames and a 0 for times played
     */

    public Map<String, Integer> fillWithTeams(Map<String, Integer> matchAmounts){
        for(int i = 0; i< participants.size(); i++){
            matchAmounts.put(participants.get(i).getTeamName(), 0);
        }
        return matchAmounts;
    }

    /**
     *
     * @param games map of games to number of times played
     * @param count current weekend count
     * @return boolean representing whether or not all the games have been played
     */
    public static boolean checkAllGamesPlayed(Map<String, Integer> games, int count){
        Iterator it = games.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(pair.getValue() != (Integer)count){
                return false;
            }
        }
        return true;
    }


    /**
     * Generates a weekend set of matches
     *
     */

    public Iterator<Match> genWeekend(Map<String, Integer>  matchAmount, List<Match> playedMatches, int weekendCount ){

        // create an empty array where set matches will be set
        Iterator<Match> itr = leagueMatches.iterator();
        List<Iterator<Match>> weekends = new ArrayList<>();
        List<Match> weekend = new ArrayList<>();

        //iterate over all each of the league matches
        while (checkAllGamesPlayed(matchAmount,weekendCount)== false) {
            //generate a single weekend holder and get the first matc
            if (itr.hasNext()) {
                Match match = itr.next();
                //check to see if  the match have is eligible for this weekend in that the teams haven't played yet and
                //the match wasn't a part of a previous weekend
                if (isEligible(match, playedMatches, matchAmount, weekendCount)) {
                    weekend.add(match);
                    matchAmount.put(match.getTeam1().getTeamName(), matchAmount.get(match.getTeam1().getTeamName()) + 1);
                    matchAmount.put(match.getTeam2().getTeamName(), matchAmount.get(match.getTeam2().getTeamName()) + 1);
                    playedMatches.add(match);


                }
            }
            else{
                fullyPlayed(matchAmount,weekendCount);

            }
        }


        return weekend.iterator() ;
    }

    /**
     * Generates the entire weekend schedule for the league
     * @return weekened schedule iterator that has the individual weekends inside as iterators
     */
    public List<Iterator<Match>> genAllWeekeds(){
        //create something to keep track of when a team has played
        Map<String, Integer>  matchAmount = new HashMap<>();
        fillWithTeams(matchAmount);
        List<Match> playedMatches = new ArrayList<>();
        int weekendCount = 1;

        //make something to hold all the weekend match iterators
        List<Iterator<Match>> weekendsForLeague = new ArrayList<>();

        //while all matches haven't been played construct a weekend
        while (playedMatches.size() < leagueMatches.size()){
            weekendsForLeague.add(genWeekend(matchAmount,playedMatches,weekendCount));
            weekendCount++;
        }
        this.weekends = weekendsForLeague;
        return weekendsForLeague;
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

    /**
     *
     * @param teamName team name of the team you want to find
     * @return the team object that was searched for
     */
  public Team findTeamByName(String teamName){
      for(int i = 0; i < participants.size(); i++){
          if(participants.get(i).getTeamName() == teamName){
              return participants.get(i);
          }
      }
      return null;

  }

    /**
     * Gets the win loss tie designations for each team
     * @return string representation of win loss ties
     */
  public String getSocreBoardWinLossTie(){
      Iterator<Map.Entry<String, Integer>> scores = scoreboard.getLeaderBoard();
      String scoreBoard = leagueName + " Team win-loss-ties and league points" + "\n";
      while (scores.hasNext()){
          Map.Entry<String, Integer> item = scores.next();
          if(findTeamByName(item.getKey()) != null) {
              scoreBoard = scoreBoard + " Team: " + item.getKey() + " League Points " + item.getValue() + " Wins "
                      + findTeamByName(item.getKey()).getWins() + " ties " + findTeamByName(item.getKey()).getTie() +
                      " losses " + findTeamByName(item.getKey()).getLoss() + "\n";
          }

      }
      return scoreBoard;
  }

    /**
     * Gets the goals and league points
     * @return string representation of the goals and league points
     */

  public String getScoreBoardGoals(){
      Iterator<Map.Entry<String, Integer>> scores = scoreboard.getLeaderBoard();
      String scoreBoard = leagueName + " Team goals and league points " + "\n";
      while (scores.hasNext()){
          Map.Entry<String, Integer> item = scores.next();
          if(findTeamByName(item.getKey()) != null) {
              scoreBoard = scoreBoard + " Team: " + item.getKey() + " League Points " + item.getValue() + " Goals "
                      + findTeamByName(item.getKey()).getTotalGoalsScored() + "\n";
          }

      }
      return scoreBoard;

  }

    /**
     *
     * @param matchAmount number of times each team has played
     * @param count current expected amount of times teams should have played
     * final check for teams that have played the maximum two matches against each other
     */

  public static void fullyPlayed(Map<String, Integer> matchAmount, int count){
      Iterator it = matchAmount.entrySet().iterator();
      while (it.hasNext()) {
          Map.Entry pair = (Map.Entry)it.next();
          if(pair.getValue() != (Integer)count){
              matchAmount.put(pair.getKey().toString(), count);
          }
      }
  }

  public static boolean sameOrReciprical(Match match, String team1, String team2 ){
       if(match.getTeam1().getTeamName() == team1 ||
       match.getTeam1().getTeamName() == team2){
           if( match.getTeam2().getTeamName() == team1
                   || match.getTeam2().getTeamName() == team2) {
               return true;
           }

       }
       return false;

  }







}
