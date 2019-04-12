package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;

public class UIAddTeam extends JOptionPane {
    //Popup allows user to enter a new team
    //Parameters
    private JPanel optionPanel;
    private JPanel addTeamPanel;
    private JTextField nameField;

    //Will returna string for the team name
    //Active roster is defaulted for now
    public UIAddTeam(JPanel optionPanel){
        this.optionPanel = optionPanel;
        //Setup text fields
        this.nameField = new JTextField(15);
        this.addTeamPanel = new JPanel();
        addTeamPanel.add(new JLabel("Team Name"));
        addTeamPanel.add(nameField);
    }

    public String display(){
        int result = this.showConfirmDialog(this.optionPanel, this.addTeamPanel, "Add Team", JOptionPane.OK_OPTION);
        return this.nameField.getText();




    }





}
