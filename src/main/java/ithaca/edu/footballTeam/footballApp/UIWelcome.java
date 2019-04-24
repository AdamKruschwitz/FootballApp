package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIWelcome extends JPanel {
    private boolean welcomeContinue;
    public boolean getWelcome(){
        return this.welcomeContinue;
    }
    public void setWelcome(boolean w){
        this.welcomeContinue = w;
    }
    public UIWelcome(){
        //Set control vars
        this.welcomeContinue = false;

        //Generate components
        JButton contButton = new JButton("Continue");
        JLabel wLabel = new JLabel("Welcome to the football app");

        //Add components
        this.add(contButton);
        this.add(wLabel);

        //Look and feel
        BoxLayout grid = new BoxLayout(this,BoxLayout.Y_AXIS);
        this.setLayout(grid);

        contButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        wLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        //Action listener for continue button
        contButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                UIWelcome.this.setWelcome(true);
            }
        });

    }

}