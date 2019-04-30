package ithaca.edu.footballTeam.footballApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UIApi {
    //Handles functions for the GUI

    //Initialize required classes for app to run
    //App needs a leaue with a few prefilled teams to work
    private League league;
    public UIApi(){
        //Generate a few teams to put in the league
        //Generic roster for right now
        Roster testRoster = new Roster();
        testRoster.addPlayer(new Player("p1",0));
        testRoster.addPlayer(new Player("p2",1));
        testRoster.addPlayer(new Player("p3",2));
        testRoster.addPlayer(new Player("p4",3));
        testRoster.addPlayer(new Player("p5",4));
        testRoster.addPlayer(new Player("p6",5));
        testRoster.addPlayer(new Player("p7",6));
        testRoster.addPlayer(new Player("p8",7));
        testRoster.addPlayer(new Player("p9",8));
        testRoster.addPlayer(new Player("p10",9));
        testRoster.addPlayer(new Player("p11",10));
        testRoster.addPlayer(new Player("p12",11));
        List<Team> initTeamList = new ArrayList();
        for (int i = 0; i < 7; i++) {
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
}
