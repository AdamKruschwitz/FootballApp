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
        List<Team> teamTmp = new ArrayList<>();
        List<String> ret = new ArrayList<>();
        teamTmp =this.league.getParticipants();
        for (int i = 0; i < teamTmp.size(); i++) {
            ret.add(teamTmp.get(i).getTeamName());
        }
        return ret;
    }

    public Iterator<Match> getMatchesToSet(){
        return this.league.generateLeagueMatches();
    }

    public Iterator<Map.Entry<String, Integer>> getLeaderBoard(){
        return this.league.updateLeaderBoard();
    }
}
