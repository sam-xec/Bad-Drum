package badDrum.sound;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.*; // MY CODE
import java.lang.Math.*;

public class PlaySound {
    Clip clip;
    FloatControl vol;
    private static final String ASSET_PATH = "Assets/Sounds/";
    private static final Map<String, Clip> clipCache = new HashMap<>();
    private final float VOLUME_LEVEL;

    public PlaySound(String file_name, float volumeLevel) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.clip = getClip(file_name);
        this.VOLUME_LEVEL = volumeLevel;
    }

    public void playSound(String fileName) {
        new Thread(() -> {
            try {
                Thread.sleep(500);

                Clip clip = getClip(fileName);

                if (clip.isRunning()) {
                    clip.stop();
                }

                vol =(FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN); // MY CODE
                vol.setValue(VOLUME_LEVEL); // MY CODE


                clip.setFramePosition(0);
                clip.start();
               } catch (InterruptedException e) {
                System.err.println("Sound delay was interrupted: " + fileName);
                Thread.currentThread().interrupt();

                  }
             catch (Exception e) {
                System.err.println("Sound playback error: " + fileName);
                e.printStackTrace();
            }
        }).start();
    }

    private static Clip getClip(String fileName)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        if (clipCache.containsKey(fileName)) {
            return clipCache.get(fileName);
        }

        File soundFile = new File(ASSET_PATH + fileName);

        System.out.println("Trying to load: " + soundFile.getAbsolutePath());
        System.out.println("Exists? " + soundFile.exists());

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);

        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clipCache.put(fileName, clip);
        return clip;
    }

    // ==========================================
    //             MY CODE PART
    // ==========================================


}
