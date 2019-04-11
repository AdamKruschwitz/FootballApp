package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIOption extends JPanel {

    //Control vars
    private boolean addPlayer;
    private boolean roundButton;
    private boolean matchButton;
    private boolean tournamentButton;
    private boolean addTeamButton;
    private boolean viewTeamButton;

    //Control vars getters and setters
    public boolean getAddPlayer(){ return this.addPlayer; }
    public boolean getRoundButton(){return this.roundButton;}
    public boolean getMatchButton(){return this.matchButton;}
    public boolean gettournamentButton(){return this.tournamentButton;}
    public boolean getAddteamButton(){return this.addTeamButton;}
    public boolean getViewteamButton(){return this.viewTeamButton;}
    public void setAllFalse(){
        this.addPlayer = false;
        this.roundButton = false;
        this.matchButton = false;
        this.tournamentButton = false;
        this.addTeamButton = false;
        this.viewTeamButton = false;
    }

    public UIOption(){
        //Set control vars
        this.addPlayer = false;

        //Generate components
        JButton addPlayerButton = new JButton("Add Player");
        JButton roundButton = new JButton("Round");
        JButton matchButton = new JButton("Match");
        JButton tournamentButton = new JButton("Tournament");
        JButton addTeamButton = new JButton("Add Team");
        JButton viewTeamButton = new JButton("View Teams");
        JLabel optionLabel = new JLabel("Options");

        //Add components
        this.add(addPlayerButton);
        this.add(roundButton);
        this.add(matchButton);
        this.add(tournamentButton);
        this.add(addTeamButton);
        this.add(viewTeamButton);
        this.add(optionLabel);

        //Look and feel
        BoxLayout grid = new BoxLayout(this,BoxLayout.Y_AXIS);
        this.setLayout(grid);

        addPlayerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        roundButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        matchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        tournamentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionLabel.setAlignmentY(Component.TOP_ALIGNMENT);


        //Action listeners
        addPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIOption.this.addPlayer = true;
            }
        });

        roundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIOption.this.roundButton = true;

            }
        });

        matchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        tournamentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        addTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIOption.this.addTeamButton = true;
            }
        });

        viewTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIOption.this.viewTeamButton = true;
            }
        });


    }
}
