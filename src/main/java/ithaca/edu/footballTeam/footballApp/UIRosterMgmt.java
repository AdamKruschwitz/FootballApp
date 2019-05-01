package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UIRosterMgmt extends JPanel {
    //Allows the user to modify team rosters

    //Components required to be able to run interface
    UIApi api;
    GridBagLayout layout;
    GridBagConstraints constraints;
    ActionListener parentListener;
    JFrame parentFrame;
    ActionListener rosterChoice;
    ActionListener playerChoice;
    JButton homeButton;
    JButton dropButton;
    JButton addButton;
    JButton addYCard;
    JButton addRCard;

    public UIRosterMgmt(UIApi api, JFrame parentFrame, ActionListener parentListener){
        //Initialize outside requirements
        this.api = api;
        this.parentFrame = parentFrame;
        this.parentListener = parentListener;
        this.homeButton = new JButton("GO GOME");

        //Initialize class frame and components
        this.layout = new GridBagLayout();
        this.setLayout(layout);
        this.constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.VERTICAL;

        //ActionListeners for navigation
        this.rosterChoice = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Get the team name and show players for the team
                JButton source = (JButton)e.getSource();
                showTeamPlayers(source.getText());
            }
        };

        this.playerChoice = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Show the options for a given player
            }
        };

    }

    public void showTeamPicks(){
        this.removeAll();
        //Add a bunch of buttons for each available team
        List<String> leagueTeams = api.viewTeams();

        for (int i = 0; i < leagueTeams.size(); i++) {
            JButton newBtn = new JButton(leagueTeams.get(i));
            this.add(newBtn, constraints);
            newBtn.addActionListener(this.rosterChoice);
        }

        this.add(homeButton, constraints);
        this.homeButton.addActionListener(parentListener);
        parentFrame.add(this);
        parentFrame.revalidate();
        parentFrame.repaint();

    }

    //Listener calls this function, shows players in team roster
    private void showTeamPlayers(String team){
        this.removeAll();
        //Get all players on a given team
        List<Player> players = api.getPlayers(team);

        for (int i = 0; i < players.size(); i++) {
            JButton newBtn = new JButton(players.get(i).getPlayerName());
            this.add(newBtn, constraints);
            newBtn.addActionListener(playerChoice);
        }

        this.add(homeButton, constraints);
        this.updateUI();

    }


    //Listener calls this function to add/drop/card players
    private void showPlayerOptions(String player){
        //User can drop player, add cards

    }

    public void clear(){
        parentFrame.remove(this);
        this.removeAll();
    }






}
