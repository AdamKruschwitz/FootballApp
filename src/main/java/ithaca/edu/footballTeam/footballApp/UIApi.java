package ithaca.edu.footballTeam.footballApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UIApi {
    //Handles functions for the GUI

    //Initialize required classes for app to run
    //App needs a leaue with a few prefilled teams to work
    League league;
    public UIApi(){
        //Generate a few teams to put in the league
        //Generic roster for right now

        Roster testRoster = new Roster();
        testRoster.fillWithValidPlayers();
        List<Team> initTeamList = new ArrayList();
        for (int i = 1; i < 5; i++) {
            initTeamList.add(new Team(testRoster,"team" + i));
        }

        this.league = new League("Demo", 1,initTeamList);
    }


    //Add a team
    //Generates new team with generic roster and adds
    public void addTeam(String teamName){
        Team teamToAdd = new Team(new Roster(), teamName);
        this.league.addTeam(teamToAdd);
    }

    //View teams in the league
    //Return list of teams in the league
    public List<String> viewTeams(){
        List<Team> teams = league.getParticipants();
        List<String> teamsString = new ArrayList<>();
        for (int i = 0; i < teams.size(); i++) {
            teamsString.add(teams.get(i).getTeamName());
        }
        return teamsString;
    }

    public Iterator<Match> getMatchesToSet(){
        return this.league.generateLeagueMatches();
    }

    public Iterator<Map.Entry<String, Integer>> getLeaderBoard(){
        return this.league.updateLeaderBoard();
    }

    //Returns a list of players for a given team
    public List<Player> getPlayers(String teamName){
        List<Player> ret = new ArrayList<>();
        List<Team> teams = league.getParticipants();
        for (int i = 0; i < teams.size(); i++) {
            if(teams.get(i).getTeamName() == teamName){
                //Iterate over team roster and make add them to a list
                for (int j = 0; j < teams.get(i).getActiveRoster().players.size(); j++) {
                    ret.add(teams.get(i).getActiveRoster().players.get(j));
                }
                return ret;
            }
        }
        return ret;
    }

    public void dropTeam(String teamName){
        league.removeTeam(teamName);
    }

    public Iterator<Iterator<Match>> getWeekendMatches(){
        league.generateLeagueMatches();
        Iterator<Iterator<Match>> allWeekends = league.genAllWeekeds();
        return allWeekends;
    }

    public String getWinLossTies(){
        return league.getSocreBoardWinLossTie();
    }

    public String getScoreGoals(){
        return league.getScoreBoardGoals();
    }

    public String getTeamsInLeague(){
        List<Team> teams = league.getParticipants();
        String teamsString = "";
        for (int i = 0; i < teams.size(); i++) {
            teamsString = teamsString + teams.get(i).getTeamName() + "\n";
        }
        return teamsString;
    }



    public void apiTest(){
        System.out.println("Api Called");
    }
}
