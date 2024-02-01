package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;

public class Music {
    Clip clip;
    AudioInputStream sound;
    Thread thread;
    public void setFile(String soundFileName) {
        try {
            File file = new File(soundFileName);
            sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {
        }
    }
    public void play() throws InterruptedException {
        thread = new Thread(() -> {
            clip.setFramePosition(0);
            clip.start();
        });
        thread.start();
    }
}
