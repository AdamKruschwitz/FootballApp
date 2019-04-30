package ithaca.edu.footballTeam.footballApp;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;


public class UIMain {

    //Required classes for display to work
    public static UITeamCtrl teamCtrl;
    public static UIOption options;
    public static UIWelcome welcome;
    public static UIApi api;
    public static ActionListener mainListener;

    public static void main(String[] args) throws InterruptedException{
        //Initialize UI
        JFrame f = new JFrame();

        //Main action listener
        mainListener = new ActionListener() {
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
                //Roster Mgmt
                if(source == options.rosterMgmtButton){
                    //Launch roster management
                }

                //Add team
                if(source == options.dropTeamButton){
                    teamCtrl.userDropTeam();
                    System.out.println("Drop Team");
                }

                //Drop Team
                if(source == options.addTeamButton){
                    System.out.println("Add Team");
                }

                //Tournament
                if(source == options.runWeekendButton){
                    System.out.println("Run Weekend");
                }

                //Win-Loss-Ties
                if(source == options.showWltButton){
                    System.out.println("Show Win-Loss-Ties");
                }

                //Show League Participants
                if(source == options.showParticipantButton){
                    System.out.println("Show Participants");

                }

                //Show Goals Points
                if(source == options.showGoalPointsButton){
                    System.out.println("Show Goals and Points");
                }

                //Run Tournament
                if(source == options.runTournamentButton){
                    System.out.println("Run Tournament");
                }





            }
        };

        //Create all required components
        welcome = new UIWelcome(mainListener);
        options = new UIOption(mainListener);
        teamCtrl = new UITeamCtrl(api, f, mainListener);
        api = new UIApi();

        f.add(welcome);
        f.pack();
        f.setSize(1600, 900);
        f.setVisible(true);
    }
}
