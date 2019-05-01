package ithaca.edu.footballTeam.footballApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UIPlayer extends JPanel {
    //Player management, gives the user control over players

    ActionListener chosenTeam;
    JButton homeButton;
    UIApi api;
    GridBagLayout layout;
    GridBagConstraints constraints;
    ActionListener parentListener;
    JFrame frame;

    public UIPlayer(UIApi api, JFrame frame, ActionListener parentListener){
        this.parentListener = parentListener;
        this.frame = frame;
        this.api = api;
        this.layout = new GridBagLayout();
        this.setLayout(layout);
        this.constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.VERTICAL;

        //ActionListener displays player info for chosen team
        this.chosenTeam = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton)e.getSource();


            }
        };

        homeButton = new JButton("GO HOME");
        homeButton.addActionListener(parentListener);

    }

    public void clear(){
        frame.remove(this);
        this.removeAll();
    }


    //List all the teams




 //   public void yellowCardPlayer
}
