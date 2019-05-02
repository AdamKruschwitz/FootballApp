package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.text.DefaultEditorKit;
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
    ActionListener optionChoice;
    JButton homeButton;
    JButton dropButton;
    JButton addButton;
    JButton addYCard;
    JButton addRCard;
    Team currTeam;
    String currPlayer;
    JTextField yCards;
    JTextField rCards;

    public UIRosterMgmt(UIApi api, JFrame parentFrame, ActionListener parentListener){
        //Initialize outside requirements
        this.api = api;
        this.parentFrame = parentFrame;
        this.parentListener = parentListener;
        this.homeButton = new JButton("GO GOME");
        this.addButton = new JButton("Add Player");
        this.dropButton = new JButton("Drop This Player");

        this.addYCard = new JButton("Yellow Card This Player");
        this.addRCard = new JButton("Red Card This Player");
        this.yCards = new JTextField();
        this.rCards = new JTextField();

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
                currTeam = api.league.findTeamByName(source.getText());
                showTeamPlayers(source.getText());
            }
        };

        this.playerChoice = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Show the options for a given player
                JButton source = (JButton)e.getSource();
                currPlayer = source.getText();
                showPlayerOptions(source.getText());
            }
        };

        this.optionChoice = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Add, drop, yellow card, redcard
                JButton source = (JButton)e.getSource();
                if(source == addButton){
                    String pName = JOptionPane.showInputDialog("Player Name");
                    Player newPlayer = new Player(pName, 3);
                    currTeam.getActiveRoster().addPlayer(newPlayer);
                    //Reload
                    showTeamPlayers(currTeam.getTeamName());
                }
                if(source == dropButton){
                    //Drop the current player
                    List<Player> dropList = currTeam.getActiveRoster().players;
                    for (int i = 0; i < dropList.size(); i++) {
                        if(dropList.get(i).getPlayerName().equals(currPlayer)){
                            dropList.remove(i);
                        }
                        showTeamPlayers(currTeam.getTeamName());
                    }

                }
                if(source == addYCard){
                    String reason = JOptionPane.showInputDialog("Enter Reason for Yellow Card");
                    List<Player> players = currTeam.getActiveRoster().players;
                    for (int i = 0; i < players.size(); i++) {
                        if(players.get(i).getPlayerName().equals(currPlayer)){
                            players.get(i).addYellowCard(new RedCard(1, reason));
                        }
                    }
                }

                if(source == addRCard){
                    String reason = JOptionPane.showInputDialog("Enter Reason for Red Card");
                    List<Player> players = currTeam.getActiveRoster().players;
                    for (int i = 0; i < players.size(); i++) {
                        if(players.get(i).getPlayerName().equals(currPlayer)){
                            players.get(i).addRedCard(new RedCard(1, reason));
                        }
                    }
                }
            }
        };
        //Actionlisteners to run this class
        this.addButton.addActionListener(this.optionChoice);
        this.dropButton.addActionListener(this.optionChoice);
        this.addYCard.addActionListener(this.optionChoice);
        this.addRCard.addActionListener(this.optionChoice);
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
            newBtn.addActionListener(this.playerChoice);
        }

        this.add(addButton, constraints);
        this.add(homeButton, constraints);
        this.updateUI();
    }


    //Listener calls this function to add/drop/card players
    private void showPlayerOptions(String player){
        this.removeAll();
        //User can drop player, add cards
        //If user has red/yellow cards
        List<Player> toSearch = currTeam.getActiveRoster().players;
        Player currPlayer = null;
        for (int i = 0; i < toSearch.size(); i++) {
            if(toSearch.get(i).getPlayerName().equals(this.currPlayer)){
                currPlayer = toSearch.get(i);
            }
        }
        //this.yCards = currPlayer.getPlayerName()
        this.add(dropButton, constraints);
        this.add(addYCard, constraints);
        this.add(addRCard, constraints);
        this.add(homeButton, constraints);
        this.updateUI();
    }

    public void clear(){
        parentFrame.remove(this);
        this.removeAll();
    }
}
