package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class UIPlayer extends JPanel {
    //Player management, gives the user control over players
    //View players on a given team
    public void showTeamPlayers(UIApi api, JFrame frame, ActionListener parentListener){
        //Give user a list of teams and let them pick
        List<String> teams = api.viewTeams();

        //Takes the parent frame to a new screen with jbuttons for each team
        //Make JPanel with buttons for each team and a home button
        for (int i = 0; i < teams.size(); i++) {

        }

        //Show a list of players for selected team

    }
    //Add player to a given team

    //Red card a player

    //Yellow card a player



}
