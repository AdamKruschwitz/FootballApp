package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.util.List;

public class UITournament {
    UIApi api;
    JPanel entryPanel;
    JLabel tl1;
    JLabel tl2;
    JTextField t1Score;
    JTextField t2Score;

    public UITournament(UIApi api){
        this.api = api;
        //Initialize JPanel for entries
        this.entryPanel = new JPanel();

        //Team Labels
        this.tl1 = new JLabel("Team1");
        this.tl2 = new JLabel("Team2");

        //Entry fields
        this.t1Score = new JTextField(5);
        this.t2Score = new JTextField(5);

        //Add
        entryPanel.add(tl1);
        entryPanel.add(t1Score);
        entryPanel.add(tl2);
        entryPanel.add(t2Score);
    }

    public void runTournament(){
        //Gen Matches for 1st and last team, drop the loser
        List<Team> teams = api.league.getParticipants();
        //Pass teams into tournament constructor
        Tournament tn = new Tournament("Tournament", teams);
        Round cRound;
        Match currMatch;
        int t1;
        int t2;
        boolean done = false;

        //Get round gets current round
        //Iterate over matches in round and set scores

        //Call gotonextround
        //end tournament if true
        //keep going if false


        //End tournament gets winner

        for (int i = 0; i < tn.getCurrRound().getCurrentMatches().size(); i++) {
            currMatch = tn.getCurrRound().getCurrentMatches().get(i);
            t1 = 4;
            t2 = 4;
            while(t1 == t2){
                this.tl1.setText(currMatch.getTeam1().getTeamName());
                this.tl2.setText(currMatch.getTeam2().getTeamName());
                JOptionPane.showConfirmDialog(null, this.entryPanel, "Enter Team Scores", JOptionPane.OK_OPTION);
                t1 = Integer.parseInt(this.t1Score.getText());
                t2 = Integer.parseInt(this.t2Score.getText());
            }
            currMatch.setTeam1Score(t1);
            currMatch.setTeam2Score(t2);


        }



    }
}
