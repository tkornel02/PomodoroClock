package main;

import timer.TimerPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private TimeSetterPanel StudyTimeSetter;
    private TimeSetterPanel PauseTimeSetter;
    private ButtonPanel buttonPanel;
    private TimerPanel timerPanel;

    public MainFrame(){
        createFrame();
    }

    private void createFrame() {
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setTitle("Pomodoro Timer");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        timerPanel = new TimerPanel();
        this.add(timerPanel,"North");

        buttonPanel = new ButtonPanel(timerPanel);
        this.add(buttonPanel,"Center");

        StudyTimeSetter = new TimeSetterPanel("Study time",timerPanel);
        PauseTimeSetter = new TimeSetterPanel("Pause time",timerPanel);
        this.add(StudyTimeSetter,"West");
        this.add(PauseTimeSetter,"East");


        this.pack();
        this.setLocationRelativeTo(null);
    }
    private void setComponents(){

    }


}
