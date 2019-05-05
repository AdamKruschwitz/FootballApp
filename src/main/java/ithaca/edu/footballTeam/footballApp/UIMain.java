package ithaca.edu.footballTeam.footballApp;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;


public class UIMain {

    //Required classes for display to work
    public static UITeamCtrl teamCtrl;
    public static UIRosterMgmt rosterCtrl;
    public static UIRunWeekend weekendCtrl;
    public static UITournament tCtrl;
    public static UIOption options;
    public static UIWelcome welcome;
    public static ActionListener mainListener;
    public static UIShowLeaderBoard leaderBoardCtrl;
    public static UILeagueCtrl leagueCtrl;

    public static void main(String[] args) throws InterruptedException{
        //Required api
        UIApi api = new UIApi();

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
                    f.remove(options);
                    f.revalidate();
                    f.repaint();
                    rosterCtrl.showTeamPicks();
                    //Launch roster management
                }

                //Drop team
                if(source == options.dropTeamButton){
                    f.remove(options);
                    f.revalidate();
                    f.repaint();
                    teamCtrl.userDropTeam(api);
                    api.getWeekendMatches();

                }

                //Add Team
                if(source == options.addTeamButton){
                    teamCtrl.userAddTeam();
                    System.out.println("Add Team");
                }

                //Tournament
                if(source == options.runWeekendButton){
                    weekendCtrl.runWeekend(api);
                }

                //Win-Loss-Ties
                if(source == options.showWltButton){
                    leaderBoardCtrl.showWinLossTies();
                    System.out.println("Show Win-Loss-Ties");
                }

                //Show League Participants
                if(source == options.showParticipantButton){
                    leagueCtrl.showUserParticipants();
                    System.out.println("Show Participants");

                }

                //Show Goals Points
                if(source == options.showGoalPointsButton){
                    leaderBoardCtrl.showGoalPoints();

                    System.out.println("Show Goals and Points");
                }

                //Run Tournament
                if(source == options.runTournamentButton){
                    tCtrl.runTournament();
                    System.out.println("Run Tournament");
                }

                //Home button clicked, go back to option screen
                if(source == teamCtrl.homeButton){
                    teamCtrl.clear();
                    f.remove(teamCtrl);
                    f.add(options);
                    f.revalidate();
                    f.repaint();
                }

                if (source == rosterCtrl.homeButton){
                    rosterCtrl.clear();
                    f.remove(rosterCtrl);
                    f.add(options);
                    f.revalidate();
                    f.repaint();
                }
            }
        };

        //Create all required components
        rosterCtrl = new UIRosterMgmt(api, f, mainListener);
        weekendCtrl = new UIRunWeekend(api);
        tCtrl = new UITournament(api);
        welcome = new UIWelcome(mainListener);
        options = new UIOption(mainListener);
        leagueCtrl = new UILeagueCtrl(api);
        leaderBoardCtrl = new UIShowLeaderBoard(api);
        teamCtrl = new UITeamCtrl(api, f, mainListener);


        f.add(welcome);
        f.pack();
        f.setSize(1600, 900);
        f.setVisible(true);
    }
}
