package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.util.Iterator;
import java.util.Map;

public class UIShowLeaderBoard extends JOptionPane {
    //Shows a popup with the current leaderboard

    private UIApi api;

    public UIShowLeaderBoard(UIApi api){
        this.api = api;
    }

    public void display(){
        Iterator<Map.Entry<String, Integer>> leaderboard = this.api.getLeaderBoard();
        String leaderString = new String();

        Map.Entry<String, Integer> currEntry;

        while(leaderboard.hasNext()){
            currEntry = leaderboard.next();
            leaderString = leaderString + currEntry.getKey();
            leaderString = leaderString + " : ";
            leaderString = leaderString + currEntry.getValue();
            leaderString = leaderString + '\n';

        }
        UIShowLeaderBoard.this.showMessageDialog(null, leaderString);

        //Iterate through leaderboard and show popup
    }
}
