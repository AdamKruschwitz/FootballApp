package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class UIRunWeekend extends JPanel {
    //Gives user control over running the weekend
    //User enters scores for each match

    Iterator<Iterator<Match>> wMatches;
    JPanel entryPanel;
    JLabel tl1;
    JLabel tl2;
    JTextField t1Score;
    JTextField t2Score;
    ActionListener chosenWeekend;
    List<Iterator<Match>> weekMatches;

    //Generate weekends upon construct to allow resume
    public UIRunWeekend(UIApi api){

        this.wMatches = api.getWeekendMatches().iterator();
        while(wMatches.hasNext()){
            this.weekMatches.add(wMatches.next());
        }

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

        chosenWeekend = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //When user clicks on chosen weekend, prompt scores for each match

            }
        };
    }

    public void showWeekends(){
        //New JButton for each weekend
        for (int i = 0; i < weekMatches.size(); i++) {
            JButton newBtn = new JButton("Weekend " + (i+1));
            newBtn.addActionListener(this.chosenWeekend);

        }
    }




    //Popup a JConfirm for each weekend match
    public void runWeekend(UIApi api){
        Iterator<Match> matchSet;
        Match currMatch;
        boolean stop = false;
        int option;

        while(wMatches.hasNext() && !stop){
            matchSet = wMatches.next();
            while (matchSet.hasNext() && !stop){
                currMatch = matchSet.next();
                //Popup a dialog box to enter scores
                this.tl1.setText(currMatch.getTeam1().getTeamName());
                this.tl2.setText(currMatch.getTeam2().getTeamName());
                option = JOptionPane.showConfirmDialog(null, this.entryPanel, "Enter Match Scores", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.CANCEL_OPTION){
                    stop = true;
                }
                else {
                    currMatch.setTeam1Score(Integer.parseInt(t1Score.getText()));
                    currMatch.setTeam1Score(Integer.parseInt(t2Score.getText()));
                }
            }
            //Increment to next set of matches
            matchSet = wMatches.next();
        }
        api.updateLeaderBoard();
    }
}