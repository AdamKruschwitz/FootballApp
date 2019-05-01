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

    public void showGoalPoints(){
        JOptionPane.showConfirmDialog(null, api.getScoreGoals());
    }

    public void showWinLossTies(){
        JOptionPane.showConfirmDialog(null, api.getWinLossTies());
    }
}
