package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.util.Iterator;

public class UIRunLeague extends JOptionPane {
    //Allows the user to enter all the scores for a league
    private UIApi api;
    private JPanel entryPanel;
    private JTextField t1Score;
    private JTextField t2Score;
    private Match currMatch;


    public UIRunLeague(UIApi api){
        this.api = api;

        //Entry panel setup
        this.entryPanel = new JPanel();
        this.t1Score = new JTextField("Team 1 Score",5);
        this.t2Score = new JTextField("Team 2 Score", 5);
        this.entryPanel.add(t1Score);
        this.entryPanel.add(t2Score);

    }

    public void display(){
        Iterator<Match> matchIterator;
        matchIterator = api.getMatchesToSet();

        //Show popup to enter scores for each match
        while(matchIterator.hasNext()){
            this.showConfirmDialog(null, this.entryPanel, "Set Team Scores",JOptionPane.OK_OPTION);
            this.currMatch = matchIterator.next();
            currMatch.setTeam1Score(Integer.parseInt(this.t1Score.getText()));
            currMatch.setTeam2Score(Integer.parseInt(this.t2Score.getText()));
        }
    }
}
