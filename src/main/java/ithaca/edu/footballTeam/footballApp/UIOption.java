package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIOption extends JPanel {
    JButton rosterMgmtButton;
    JButton dropTeamButton;
    JButton addTeamButton;
    JButton runWeekendButton;
    JButton showWltButton;
    JButton showParticipantButton;
    JButton showGoalPointsButton;
    JButton runTournamentButton;

    public UIOption(ActionListener parentListener){
        //Generate components
        this.rosterMgmtButton = new JButton("Roster Management");
        this.dropTeamButton = new JButton("Drop Team");
        this.addTeamButton = new JButton("Add Team");
        this.runWeekendButton = new JButton("Run Weekend");
        this.showWltButton = new JButton("Show Win-Loss-Ties");
        this.showParticipantButton = new JButton("Show League Participants");
        this.showGoalPointsButton = new JButton("Show Goals and Points");
        this.runTournamentButton = new JButton("Run Tournament");
        JLabel optionLabel = new JLabel("Options");

        //Add components/LAF
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.VERTICAL;

        this.add(optionLabel, constraints);
        this.add(rosterMgmtButton, constraints);
        this.add(dropTeamButton, constraints);
        this.add(addTeamButton, constraints);
        this.add(runWeekendButton, constraints);
        this.add(showWltButton, constraints);
        this.add(showParticipantButton, constraints);
        this.add(showGoalPointsButton, constraints);
        this.add(runTournamentButton, constraints);

        //Action listeners
        this.rosterMgmtButton.addActionListener(parentListener);
        this.dropTeamButton.addActionListener(parentListener);
        this.addTeamButton.addActionListener(parentListener);
        this.runWeekendButton.addActionListener(parentListener);
        this.showWltButton.addActionListener(parentListener);
        this.showParticipantButton.addActionListener(parentListener);
        this.showGoalPointsButton.addActionListener(parentListener);
        this.runTournamentButton.addActionListener(parentListener);
    }
}
