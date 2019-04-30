package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UIPlayer extends JPanel {
    //Player management, gives the user control over players

    ActionListener chosenTeam;
    JButton homeButton;
    UIApi api;
    GridBagLayout layout;
    GridBagConstraints constraints;
    ActionListener parentListener;
    JFrame frame;

    public UIPlayer(UIApi api, JFrame frame, ActionListener parentListener){
        this.parentListener = parentListener;
        this.frame = frame;
        this.api = api;
        this.layout = new GridBagLayout();
        this.setLayout(layout);
        this.constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.VERTICAL;

        //ActionListener displays player info for chosen team
        this.chosenTeam = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton)e.getSource();
                showTeamPlayers(btn.getText());

            }
        };

        homeButton = new JButton("GO HOME");
        homeButton.addActionListener(parentListener);

    }

    public void clear(){
        frame.remove(this);
        this.removeAll();
    }


    //List all the teams
    public void showTeamPicks(){
        //Give user a list of teams and let them pick
        List<String> teams = api.viewTeams();

        for (int i = 0; i < teams.size(); i++) {
            //Generate buttons and add to panel
            JButton newBtn = new JButton(teams.get(i));
            this.add(newBtn, constraints);
            newBtn.addActionListener(this.chosenTeam);
        }

        //Home button
        frame.remove(this);
        this.add(homeButton);
        frame.add(this);
        frame.revalidate();
        frame.repaint();
    }

    public void showTeamPlayers(String teamName){
        this.removeAll();
        //Adds a list of players for selected team
        List<Player> players = api.getPlayers(teamName);
        for (int i = 0; i < players.size(); i++) {
            JButton newBtn = new JButton(players.get(i).name);
            this.add(newBtn, constraints);
           // newBtn.addActionListener(this.chosenTeam);
        }

        //Home Button
        frame.remove(this);
        this.add(homeButton);
        frame.add(this);
        frame.revalidate();
        frame.repaint();

        //Get players for a given team

    }

 //   public void yellowCardPlayer
}
