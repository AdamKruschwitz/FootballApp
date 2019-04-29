package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIOption extends JPanel {
    JButton addPlayerButton;
    JButton roundButton;
    JButton matchButton;
    JButton tournamentButton;
    JButton addTeamButton;
    JButton viewTeamButton;
    JButton runLeagueButton;
    JButton leaderButton;

    public UIOption(ActionListener parentListener){
        //Generate components
        this.addPlayerButton = new JButton("Add Player");
        this.roundButton = new JButton("Round");
        this.matchButton = new JButton("Match");
        this.tournamentButton = new JButton("Tournament");
        this.addTeamButton = new JButton("Add Team");
        this.viewTeamButton = new JButton("View Teams");
        this.runLeagueButton = new JButton("Run League");
        this.leaderButton = new JButton("Get Leaderboard");
        JLabel optionLabel = new JLabel("Options");

        //Add components/LAF
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.VERTICAL;

        this.add(optionLabel, constraints);
        this.add(addPlayerButton, constraints);
        this.add(roundButton, constraints);
        this.add(matchButton, constraints);
        this.add(tournamentButton, constraints);
        this.add(matchButton, constraints);
        this.add(addTeamButton, constraints);
        this.add(viewTeamButton, constraints);
        this.add(runLeagueButton, constraints);
        this.add(leaderButton, constraints);

        //Action listeners
        this.addPlayerButton.addActionListener(parentListener);
        this.roundButton.addActionListener(parentListener);
        this.matchButton.addActionListener(parentListener);
        this.tournamentButton.addActionListener(parentListener);
        this.addTeamButton.addActionListener(parentListener);
        this.viewTeamButton.addActionListener(parentListener);
        this.runLeagueButton.addActionListener(parentListener);
        this.leaderButton.addActionListener(parentListener);
    }
}
