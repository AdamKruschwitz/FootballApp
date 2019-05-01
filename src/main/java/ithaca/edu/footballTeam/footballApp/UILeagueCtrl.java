package ithaca.edu.footballTeam.footballApp;

import ithaca.edu.footballTeam.footballApp.UIApi;

import javax.swing.*;

public class UILeagueCtrl {
    UIApi api;
    public UILeagueCtrl(UIApi api){
        this.api = api;
    }
    public void showUserParticipants(){
        JOptionPane.showConfirmDialog(null, this.api.getTeamsInLeague(), "Teams In This League", JOptionPane.CANCEL_OPTION);
    }
}
