package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UITeamCtrl extends JOptionPane {
    JFrame parentFrame;
    GridBagLayout layout;
    GridBagConstraints constraints;
    JButton homeButton;
    ActionListener chosenTeam;
    ActionListener parentListener;

    //Requires access to an api and parent frame
    public UITeamCtrl(UIApi api, JFrame parentFrame, ActionListener parentListener) {
        this.parentListener = parentListener;
        this.layout = new GridBagLayout();
        this.setLayout(layout);
        this.constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.VERTICAL;
        this.parentFrame = parentFrame;
        homeButton = new JButton("GO HOME");
        homeButton.addActionListener(parentListener);



        this.chosenTeam = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Remove chosen team from the league
                JButton source = (JButton)e.getSource();
                api.dropTeam(source.getText());
                homeButton.doClick();
            }
        };
    }

    public void clear(){
        parentFrame.remove(this);
        this.removeAll();
    }

    public void userDropTeam(UIApi api){
        //Show jbuttons for all current teams
        //User clicks on one to drop
        List<String> teams = api.viewTeams();

        for (int i = 0; i < teams.size(); i++) {
            //Generate buttons and add to panel
            JButton newBtn = new JButton(teams.get(i));
            this.add(newBtn, constraints);
            newBtn.addActionListener(this.chosenTeam);
        }

        //Home button
        this.add(homeButton);
        parentFrame.add(this);
        parentFrame.revalidate();
        parentFrame.repaint();


    }

    public void userAddTeam(){
        //Gets input from user and adds team with valid players
    }

}
