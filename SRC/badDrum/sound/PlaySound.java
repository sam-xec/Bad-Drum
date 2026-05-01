package badDrum.sound;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.*; // MY CODE

public class PlaySound {
    Clip clip;

    private static final String ASSET_PATH = "Assets/Sounds/";
    private static final Map<String, Clip> clipCache = new HashMap<>();

    public PlaySound() { }

    public void playSound(String fileName) {
        new Thread(() -> {
            try {
                Clip clip = getClip(fileName);

                if (clip.isRunning()) {
                    clip.stop();
                }

                clip.setFramePosition(0);
                clip.start();

            } catch (Exception e) {
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
