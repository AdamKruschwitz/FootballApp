package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIOption extends JPanel {
    //Option screen, allows user to add players

    //Control vars
    private boolean addPlayer;
    private boolean roundButton;
    private boolean matchButton;
    private boolean tournamentButton;

    //Control vars getters and setters
    public void setAddPlayer(boolean addPlayer){
        this.addPlayer = addPlayer;
    }
    public boolean getAddPlayer(){
        return this.addPlayer;
    }
    public void setRoundButton(boolean roundButton){this.roundButton = roundButton;}
    public boolean getRoundButton(){return this.roundButton;}
    public void setMatchButton(boolean matchButton){this.matchButton = matchButton;}
    public boolean getMatchButton(){return this.matchButton;}
    public void setTournamentButton(boolean tournamentButton){this.tournamentButton = tournamentButton;}
    public boolean gettournamentButton(){return this.tournamentButton;}

    public UIOption(){
        //Set control vars
        this.addPlayer = false;

        //Generate components
        JButton addPlayerButton = new JButton("Add Player");
        JButton roundButton = new JButton("Round");
        JButton matchButton = new JButton("Match");
        JButton tournamentButton = new JButton("Tournament");
        JLabel optionLabel = new JLabel("Options");

        //Add components
        this.add(addPlayerButton);
        this.add(roundButton);
        this.add(matchButton);
        this.add(tournamentButton);
        this.add(optionLabel);

        //Look and feel
        BoxLayout grid = new BoxLayout(this,BoxLayout.Y_AXIS);
        this.setLayout(grid);

        addPlayerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        roundButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        matchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        tournamentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        //Action listeners
        addPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIOption.this.setAddPlayer(true);
            }
        });

        roundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIOption.this.setRoundButton(true);

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


    }
}
