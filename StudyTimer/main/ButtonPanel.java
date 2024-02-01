package main;

import timer.TimerPanel;

import javax.swing.*;
import java.awt.*;

import static java.awt.event.KeyEvent.VK_E;

public class ButtonPanel extends JPanel {
    JButton resetButton;
    JButton pauseButton;
    public ButtonPanel(TimerPanel tp){
        pauseButton = new JButton("Start/Stop");
        resetButton = new JButton("Reset");

        pauseButton.setBackground(Color.white);
        pauseButton.setFocusPainted(false);
        resetButton.setBackground(Color.white);
        resetButton.setFocusPainted(false);

        pauseButton.addActionListener(e -> tp.pauseTimer());
        resetButton.addActionListener(e -> tp.resetTimer());
        this.setLayout(new FlowLayout());
        this.add(pauseButton);
        this.add(resetButton);
    }
}
