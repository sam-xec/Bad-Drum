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

    PlaySound sound;
    VolumeControl volume;

    public void play(VolumeControl volume){
        PlaySound sound = new PlaySound();
        volume.vol =(FloatControl)sound.clip.getControl(FloatControl.Type.MASTER_GAIN); // MY CODE
        volume.vol.setValue(volume.volumeLevel); // MY CODE
    }

    public void highPitchSoundOn(int signal){
        if (signal == 1){  //turn on high pitch sound
           /* To be removed setVolumeLevel(6); */
        }
    }

    public void highPitchSoundOff(int signal){}

    public void punishment(int level){
        if (level == 1) ; // add punishment sound
        if (level == 2) ; // add another sound
        if (level == 3) ; // more sounds:")
    }

    //================================
    // VOLUME CONTROL
    //================================


}
