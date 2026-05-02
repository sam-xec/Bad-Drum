package badDrum.sound;
//All the sound will be produced in this class


import javax.sound.sampled.*;
import badDrum.equationPuzzle.*;

import java.io.IOException;

/** SoundManager is responsible for playing sounds when collision cures
 * It uses PlaySound as a tool
 * <p>
 * SoundManager is also responsible for:
 * the centralized volume control system
 * and punishment mechanisms
 * SoundManager controls when sounds start and stop.
 **/
public class SoundManager {
    // PlaySound instance (already implemented by you)
    private final PlaySound playSound = new PlaySound();

    // Track whether high-pitch sound is currently active
    private boolean highPitchPlaying = false;

    // Filename of the high-pitch sound
    private static final String HIGH_PITCH_FILE = "Anoy.wav";

    public SoundManager() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
    }

    public void escalatePunishment(PlaySound sound, int level) {
        switch (level) {
            case 1: // add punishment sound
                break;
            case 2: // add another sound
                break;
            case 3: // more sounds:")
                break;
            case 0: // stop(); // stops all sounds
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + level);
        }
    }
    /**
     * Starts the high-pitch sound and loops it continuously.
     * If it is already playing, this method does nothing.
     */
    public void startHighPitch() throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        // Prevent multiple starts
        if (highPitchPlaying) {
            return;
        }

        // Start playing the sound
        playSound.playSound(HIGH_PITCH_FILE);

        // Get the Clip and loop it
        Clip clip = playSound.getClip(HIGH_PITCH_FILE);
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }

        highPitchPlaying = true;
    }
    /**
     * Stops the high-pitch sound if it is playing.
     */
    public void stopHighPitch() {

        if (!highPitchPlaying) {
            return;
        }

        playSound.stopSound(HIGH_PITCH_FILE);
        highPitchPlaying = false;
    }
}
