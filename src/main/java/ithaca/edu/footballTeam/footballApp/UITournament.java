package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UITournament {
    UIApi api;
    JPanel entryPanel;
    JLabel tl1;
    JLabel tl2;
    JTextField t1Score;
    JTextField t2Score;
    JTextField t1Score1;
    JTextField t2Score1;
    JTextField t1Score3;
    JTextField t2Score3;

    public UITournament(UIApi api){
        this.api = api;
        //Initialize JPanel for entries
        this.entryPanel = new JPanel();
        this.entryPanel.setLayout(new GridLayout(4,2));

        //Team Labels
        this.tl1 = new JLabel("Team1");
        this.tl2 = new JLabel("Team2");

        //Entry fields
        this.t1Score = new JTextField("Team Score 1",5);
        this.t2Score = new JTextField("Team Score 1",5);
        this.t1Score1 = new JTextField("Team Score 2",5);
        this.t2Score1 = new JTextField("Team Score 2",5);
        this.t1Score3 = new JTextField("Team Score 3",5);
        this.t2Score3 = new JTextField("Team Score 3",5);

        //Add
        entryPanel.add(tl1);
        entryPanel.add(tl2);
        entryPanel.add(t1Score);
        entryPanel.add(t2Score);
        entryPanel.add(t1Score1);
        entryPanel.add(t2Score1);
        entryPanel.add(t1Score3);
        entryPanel.add(t2Score3);
    }

    public void runTournament(){
        //Pass teams into tournament constructor
        List<Team> teams = api.league.getParticipants();
        Round cRound;
        Match currMatch;
        int i = 0;
        int j = teams.size() - 1;
        boolean done = false;
        float t1Avg = 5;
        float t2Avg = 5;

        while(j-i != 0){
            t1Avg = 5;
            t2Avg = 5;
            //Keep asking until non-tie is entered
            while(t1Avg == t2Avg){
                this.tl1.setText(teams.get(i).getTeamName());
                this.tl2.setText(teams.get(j).getTeamName());
                JOptionPane.showConfirmDialog(null, this.entryPanel, "Enter scores for each round", JOptionPane.OK_OPTION);


                //Set averages
                t1Avg = (Integer.parseInt(this.t1Score.getText()) + Integer.parseInt(this.t1Score1.getText()) + Integer.parseInt(this.t1Score3.getText())/3);
                t2Avg = (Integer.parseInt(this.t2Score.getText()) + Integer.parseInt(this.t2Score1.getText()) + Integer.parseInt(this.t2Score3.getText())/3);

                //Dec/inc winner
                if(t1Avg > t2Avg){
                    j--;
                }
                else{
                    i++;
                }

            }

        }
        //pointer now set to winner
        JOptionPane.showConfirmDialog(null,"Tournament Winner is: " + teams.get(j).getTeamName());





    }
}
