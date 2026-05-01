package badDrum.sound;
//All the sound will be produced in this class


import javax.sound.sampled.*;
import badDrum.equationPuzzle.*;

import java.io.IOException;

/**SoundManager is responsible for playing sounds when collision cures
 * It uses PlaySound as a tool
 * <p>
 * SoundManager is also responsible for:
 * the centralized volume control system
 * and punishment mechanisms **/

public class SoundManager {

   
    VolumeControl volume = new VolumeControl();
    PlaySound sound = new PlaySound("Rack-tom.wav", volume.volumeLevel);
    PuzzleState puzzle = new PuzzleState();

    public SoundManager() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
    }

    public void main() throws Exception{
        highPitchSoundPlay(this.sound);
    }
   
    public void highPitchSoundPlay(PlaySound anoy){
        volume.requestVolumeChange(VolumeControl.MAX_VOLUME - volume.volumeLevel);
        volume.lockVolume();
        while (puzzle.puzzleSolved) {
            anoy.playSound("Rack-tom.wav");//turn on high pitch sound
        }
        anoy.clip.stop();
        anoy = null;
        volume.reset();
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

    public void playDrum(int collision){

    }
}
