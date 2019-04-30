package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIWelcome extends JPanel {

    JButton contButton;

    public UIWelcome(ActionListener parentListener){

        //Generate components
        this.contButton = new JButton("Continue");
        JLabel wLabel = new JLabel("Welcome to the football app");

        //Add components
        this.add(contButton);
        this.add(wLabel);

        //Look and feel
        BoxLayout grid = new BoxLayout(this,BoxLayout.Y_AXIS);
        this.setLayout(grid);

        this.contButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        wLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.contButton.addActionListener(parentListener);




    }
}