package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UIViewTeams extends JOptionPane {
    //Jpanel that shows a list of all current teams
    private UIApi api;

    public UIViewTeams(UIApi api){
        this.api = api;

    }

    public void display(){
        List<String> teamsList = new ArrayList<>();
        teamsList = api.viewTeams();
        String teamDisplay = new String();
        for (int i = 0; i < teamsList.size(); i++) {
            teamDisplay = teamDisplay + teamsList.get(i);
            teamDisplay = teamDisplay + '\n';
        }
        UIViewTeams.this.showMessageDialog(null, teamDisplay);

    }
}
