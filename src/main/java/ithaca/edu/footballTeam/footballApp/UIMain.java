package ithaca.edu.footballTeam.footballApp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;


public class UIMain {

    //Required classes for display to work
    public static UIWelcome welcome;
    public static UIOption options;
    public static UIAddTeam addTeam;
    public static UIViewTeams viewTeams;
    public static UIRunLeague runLeague;
    public static UIShowLeaderBoard showLeader;

    public static void main(String[] args) throws InterruptedException{
        //Initialize UI
        JFrame f = new JFrame();

        //Main action listener
        ActionListener mainListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Find out which button was clicked
                Object source = e.getSource();

                //Welcome screen continue button, go to main menu
                if(source == welcome.contButton){
                    f.remove(welcome);
                    f.add(options);
                    f.revalidate();
                    f.repaint();
                }

                //Option screen buttons
                //Add player
                if(source == options.addPlayerButton){
                    System.out.println("Add Player");
                }

                //Round
                if(source == options.roundButton){
                    System.out.println("Run Round");
                }

                //Match
                if(source == options.matchButton){
                    System.out.println("Run Match");
                }

                //Tournament
                if(source == options.tournamentButton){
                    System.out.println("Tournament");
                }

                //Add Team
                if(source == options.addTeamButton){
                    System.out.println("Add Team");
                }

                //View Team
                if(source == options.viewTeamButton){
                    //Show view team popup
                    viewTeams.display();
                }

                //Run League
                if(source == options.runLeagueButton){
                    System.out.println("Run League");
                }

                //Show Leaderboard
                if(source == options.leaderButton){
                    System.out.println("Show Leaderboard");
                }


            }
        };

        //Create all required components
        welcome = new UIWelcome(mainListener);
        options = new UIOption(mainListener);
        addTeam = new UIAddTeam(options);
        UIApi api = new UIApi();
        viewTeams = new UIViewTeams(api);
        runLeague = new UIRunLeague(api);
        showLeader = new UIShowLeaderBoard(api);

        f.add(welcome);
        f.pack();
        f.setSize(1600, 900);
        f.setVisible(true);
    }
}
