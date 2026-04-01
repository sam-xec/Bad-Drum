package baddrum.sound;
//All the sound will be produced in this class

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SoundManager {

private static final String ASSET_PATH = "asset/";
    private static final Map<String, Clip> clipCache = new HashMap<>();

    /**
     * Plays a sound from the asset folder.
     * @param fileName Name of the .wav file (e.g. "snare.wav")
     */
    public static void playSound(String fileName) {
        new Thread(() -> {
            try {
                Clip clip = getClip(fileName);

                if (clip.isRunning()) {
                    clip.stop();          // Allows retriggering
                }

                clip.setFramePosition(0);
                clip.start();

            } catch (Exception e) {
                System.err.println("Sound playback error: " + fileName);
            }
        }).start();
    }

    /**
     * Loads and caches clips to avoid repeated disk access.
     */
    private static Clip getClip(String fileName)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        if (clipCache.containsKey(fileName)) {
            return clipCache.get(fileName);
        }

        File soundFile = new File(ASSET_PATH + fileName);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);

        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clipCache.put(fileName, clip);
        return clip;
    }

}
