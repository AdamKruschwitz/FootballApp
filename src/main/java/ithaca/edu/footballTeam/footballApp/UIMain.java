package ithaca.edu.footballTeam.footballApp;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;


public class UIMain {
    public static void main(String[] args) throws InterruptedException{
        //Initialize UI
        JFrame f = new JFrame();

        //Create all required components
        UIWelcome welcome = new UIWelcome();
        UIOption options = new UIOption();
        UIAddTeam addTeam = new UIAddTeam(options);
        UIApi api = new UIApi();
        UIViewTeams viewTeams = new UIViewTeams(api);
        UIRunLeague runLeague = new UIRunLeague(api);
        UIShowLeaderBoard showLeader = new UIShowLeaderBoard(api);

        f.add(welcome);
        f.pack();
        f.setSize(1600, 900);
        f.setVisible(true);


        //Main loop for UI control
        boolean exit = false;
        while(!exit){
            sleep(200);
            if(welcome.getWelcome()) {
                //Option screen
                f.remove(welcome);
                f.add(options);
                f.revalidate();
                f.repaint();
                while (!exit) {
                    sleep(200);
                    //Go to chosen options
                    //Add player
                    if(options.getAddPlayer()){

                    }

                    //Round options

                    //Match options

                    //Tournament options

                    //Add team
                    if(options.getAddteamButton()){
                        String result = addTeam.display();
                        api.addTeam(result);
                        options.setAllFalse();
                    }

                    //View teams
                    if(options.getViewteamButton()){
                        viewTeams.display();
                        options.setAllFalse();
                    }

                    //Run league
                    if(options.getRunLeagueButton()){
                        runLeague.display();
                        options.setAllFalse();
                    }

                    if(options.getLeaderButton()){
                        showLeader.display();
                        options.setAllFalse();

                    }




                }
            }
        }













    }
}
