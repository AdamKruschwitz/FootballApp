package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class UIRunWeekend extends JPanel {
    //Gives user control over running the weekend
    //User enters scores for each match

    Iterator<Iterator<Match>> wMatches;
    UIApi api;
    JFrame parentFrame;
    JPanel entryPanel;
    JLabel tl1;
    JLabel tl2;
    JTextField t1Score;
    JTextField t2Score;
    JButton homeButton;
    ActionListener chosenWeekend;
    ActionListener parentListener;
    List<Iterator<Match>> weekMatches;
    GridBagLayout layout;
    GridBagConstraints constraints;
    Integer weekend;

    //Generate weekends upon construct to allow resume
    public UIRunWeekend(UIApi api, JFrame parentFrame, ActionListener parentListener){
        this.weekend = 0;
        this.parentListener = parentListener;
        this.layout = new GridBagLayout();
        this.setLayout(layout);
        this.constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.VERTICAL;
        this.api = api;
        this.parentFrame = parentFrame;
        this.weekMatches = api.getWeekendMatches();
        this.homeButton = new JButton("GO GOME");
        this.homeButton.addActionListener(this.parentListener);

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
                //Find source and run the weekend
                //Pass iterator of matches into weekend runner
                JButton source = (JButton)e.getSource();
                runWeekend((Character.getNumericValue(source.getText().charAt(source.getText().length() - 1))) - 1);

            }
        };
    }

    public void clear(){
        parentFrame.remove(this);
        this.removeAll();

    }

    public void showWeekends(){
        this.removeAll();
        //New JButton for each weekend
        for (int i = 0; i < weekMatches.size(); i++) {
            JButton newBtn = new JButton("Weekend " + (i+1));
            newBtn.addActionListener(this.chosenWeekend);
            this.add(newBtn, constraints);
        }
        //Home Button
        this.add(homeButton, constraints);
        parentFrame.add(this);
        parentFrame.revalidate();
        parentFrame.repaint();
    }


    //Popup a JConfirm for each weekend match
    public void runWeekend(int i) {
        //User cannot exit this until the entire weekend is run
        //Remove weekend from the list after it has been run
        Iterator<Match> matches = weekMatches.get(i);
        Match currMatch;
        int s1 = 5;
        int s2 = 5;

        while(matches.hasNext()){
            currMatch = matches.next();
            //Popup to enter scores
            s1 = 5;
            s2 = 5;
            while(s1 == s2){
                s1 = 5;
                s2 = 5;
                this.tl1.setText(currMatch.getTeam1().getTeamName());
                this.tl2.setText(currMatch.getTeam2().getTeamName());
                JOptionPane.showConfirmDialog(null, this.entryPanel, "Enter Match Scores", JOptionPane.OK_OPTION);
                s1 = Integer.parseInt(this.t1Score.getText());
                s2 = Integer.parseInt(this.t2Score.getText());

            }
            currMatch.setTeam1Score(s1);
            currMatch.setTeam2Score(s2);

        }
        api.league.updateLeaderBoard();

    }
}