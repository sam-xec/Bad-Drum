package badDrum.sound;
//All the sound will be produced in this class


import javax.sound.sampled.*;

/**SoundManager is responsible for playing sounds when collision cures
 * It uses PlaySound as a tool
 * <p>
 * SoundManager is also responsible for:
 * the centralized volume control system
 * and punishment mechanisms **/

public class SoundManager {

   
    VolumeControl volume;

   
    public void highPitchSoundOn(PlaySound sound, VolumeControl volume){
        volume.requestVolumeChange(VolumeControl.MAX_VOLUME - volume.volumeLevel);
        volume.lockVolume();
        while (true) {
            sound.playSound("Anoy.wav");//turn on high pitch sound
        }
    }

    public void highPitchSoundOff(PlaySound sound, VolumeControl volume){
        sound.clip.stop();
        sound = null;
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
}
