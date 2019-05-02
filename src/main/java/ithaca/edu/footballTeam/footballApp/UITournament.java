package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.util.List;

public class UITournament {
    UIApi api;
    JPanel entryPanel;
    JLabel tl1;
    JLabel tl2;
    JTextField t1Score;
    JTextField t2Score;

    public UITournament(UIApi api){
        this.api = api;
        //Initialize JPanel for entries
        this.entryPanel = new JPanel();

        //Team Labels
        this.tl1 = new JLabel("Team1");
        this.tl2 = new JLabel("Team2");

        //Entry fields
        this.t1Score = new JTextField(5);
        this.t2Score = new JTextField(5);

        //Add
        entryPanel.add(tl1);
        entryPanel.add(t1Score);
        entryPanel.add(tl2);
        entryPanel.add(t2Score);
    }

    public void runTournament(){
        //Gen Matches for 1st and last team, drop the loser
        List<Team> teams = api.league.getParticipants();
        int option;

        while (teams.size() > 1){
            //Set labels
            this.tl1.setText(teams.get(0).getTeamName());
            this.tl2.setText(teams.get(teams.size()-1).getTeamName());

            option = JOptionPane.showConfirmDialog(null, this.entryPanel, "Enter Team Scores", JOptionPane.OK_CANCEL_OPTION);

            if(Integer.parseInt(t1Score.getText()) > Integer.parseInt(t2Score.getText())){
                teams.remove(teams.size() - 1);
            }
            else{
                teams.remove(0);
            }
            //Cancel button hit, end tournament
        }
        //Print remaining team after running tournament
        JOptionPane.showConfirmDialog(null, "Tournament Winner: " + teams.get(0).getTeamName());

    }
}
