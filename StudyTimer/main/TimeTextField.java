package main;

import timer.TimerPanel;

import javax.swing.*;
import java.awt.event.*;

public class TimeTextField extends JTextField {

    TimeTextField(String text,int columns){
        super(text, columns);
        this.addKeyListener(new NumbersOnlyAdapter());
        this.addFocusListener(new TimeTextFieldAdapter());
    }

    public static class NumbersOnlyAdapter extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if(!Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE))
            {
                e.consume();
            }
        }
    }

    public static class TimeTextFieldAdapter extends FocusAdapter {
        @Override
        public void focusGained(FocusEvent e) {
            ((TimeTextField)e.getSource()).selectAll();
        }
        @Override
        public void focusLost(FocusEvent e) {
            TimeTextField ttf = (TimeTextField)e.getSource();
            if (ttf.getText().length()==0) ttf.setText("00");}
    }
}
