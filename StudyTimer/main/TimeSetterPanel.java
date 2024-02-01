package main;

import timer.Time;
import timer.TimerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TimeSetterPanel extends JPanel{
    private JLabel nameField;
    private TimeTextField hoursField;
    private JLabel dotLabel1;
    private TimeTextField minsField;
    private JLabel dotLabel2;
    private TimeTextField secField;
    private JButton setTimeButton;
    private JPanel helpPanel;
    private TimerPanel tpanel;
    private String name;
    TimeSetterPanel(String nm, TimerPanel tp){
        helpPanel = new JPanel(new FlowLayout());
        this.tpanel = tp;
        this.name = nm;
        nameField = new JLabel(name);
        hoursField = new TimeTextField("00",2);
        dotLabel1 = new JLabel(":");
        minsField = new TimeTextField("10",2);
        dotLabel2 = new JLabel(":");
        secField = new TimeTextField("00",2);

        setTimeButton = new JButton("Set "+ name);
        setTimeButton.setBackground(Color.WHITE);
        setTimeButton.setFocusPainted(false);
        setTimeButton.setRolloverEnabled(false);



        if (name.equals("Study time")){
            setTimeButton.addActionListener(
                    e -> {
                        tpanel.setStudyTime(new Time(getHourFromField(),getMinFromField(),getSecTextFromField()));
                        tpanel.resetTimer();
                    }
            );

        } else if (name.equals("Pause time")) {
            setTimeButton.addActionListener(
                    e -> {
                        tpanel.setPauseTime(new Time(TimeSetterPanel.this.getHourFromField(), TimeSetterPanel.this.getMinFromField(), TimeSetterPanel.this.getSecTextFromField()));
                        tpanel.resetTimer();
                    }
            );
        }
        else {
            System.err.println("Invalid TimeSetter name");
        }




        this.setLayout(new GridLayout(2,1,0,10));
        helpPanel.add(nameField);
        helpPanel.add(hoursField);
        helpPanel.add(dotLabel1);
        helpPanel.add(minsField);
        helpPanel.add(dotLabel2);
        helpPanel.add(secField);

        this.add(helpPanel);
        this.add(setTimeButton);
    }

    public int getHourFromField(){
        return Integer.parseInt(hoursField.getText());
    }

    public int getMinFromField(){
        return Integer.parseInt(minsField.getText());
    }

    public int getSecTextFromField(){
        return Integer.parseInt(secField.getText());
    }


}
