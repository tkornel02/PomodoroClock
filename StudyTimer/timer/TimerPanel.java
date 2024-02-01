package timer;

import main.Music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TimerPanel extends JPanel implements ActionListener {
    private final Timer t = new Timer(1000,this);
    JLabel timeLabel;
    Time time;
    String endSoundFileName = "res/alert2.wav";
    Music m;
    Color studyColor = new Color(194, 45, 45);
    Color pauseColor = new Color(4, 91, 4);

    enum State {
        study,
        pause
    }
    State state;
    Time studyTime = new Time(0,25,0);
    Time pauseTime = new Time(0,5,0);

    public TimerPanel(){
        state = State.study;
        time = new Time(studyTime.getHour(),studyTime.getMin(),studyTime.getSec());
        timeLabel = new JLabel(time.toString());

        timeLabel.setFont(new Font(Font.SERIF,Font.PLAIN,50));
        timeLabel.setForeground(studyColor);
        this.add(timeLabel);

        m = new Music();
        m.setFile(endSoundFileName);

    }
    public void pauseTimer(){
        if (t.isRunning()) t.stop();
        else t.start();
    }
    public void resetTimer(){
        time.setTime(studyTime);
        state = State.study;
        timeLabel.setForeground(studyColor);
        timeLabel.setText(time.toString());
        t.stop();
    }

    public void setStudyTime(Time studyTime) {
        this.studyTime.setTime(studyTime);
    }

    public void setPauseTime(Time pauseTime) {
        this.pauseTime.setTime(pauseTime);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        time.subSec(1);
        timeLabel.setText(time.toString());
        if (time.getAllSec() <= 0){

            try {
                m.play();
                //m.stop();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            switch (state){
                case study -> {
                    state = State.pause;
                    timeLabel.setForeground(pauseColor);
                    time.setTime(new Time(pauseTime.getHour(),pauseTime.getMin(),pauseTime.getSec()+1));
                }
                case pause -> {
                    state = State.study;
                    timeLabel.setForeground(studyColor);
                    time.setTime(new Time(studyTime.getHour(),studyTime.getMin(),studyTime.getAllSec()+1));
                }
            }
        }


    }

}
