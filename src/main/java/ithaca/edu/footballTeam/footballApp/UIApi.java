package ithaca.edu.footballTeam.footballApp;

import java.util.ArrayList;
import java.util.List;

public class UIApi {
    //Handles functions for the GUI

    //Initialize required classes for app to run
    //App needs a leaue with a few prefilled teams to work
    League league;
    public UIApi(){
        //Generate a few teams to put in the league
        //Generic roster for right now
        Roster testRoster = new Roster();
        List<Team> initTeamList = new ArrayList();
        for (int i = 0; i < 7; i++) {
            initTeamList.add(new Team(testRoster,"team" + i));
        }

        this.league= new League("Demo", 1,initTeamList);
    }


    //Add a team
    //Generates new team with generic roster and adds
    public void addTeam(String teamName){


    }

    //View teams in the league
    //Return list of teams in the league
    List<String> viewTeam(){

    }







}
