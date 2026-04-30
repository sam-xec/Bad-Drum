package badDrum.sound;
//All the sound will be produced in this class


import javax.sound.sampled.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SoundManager {

    static FloatControl vol;  // My Code
    public static float volumeLevel = -10; /* mute = -80*/ // My Code


    PlaySound sound;

    public void play(){
        PlaySound sound = new PlaySound();
        vol =(FloatControl)sound.clip.getControl(FloatControl.Type.MASTER_GAIN); // MY CODE
        vol.setValue(volumeLevel); // MY CODE
    }

    public void setVolumeLevel(int volumeLevel){
        SoundManager.volumeLevel = volumeLevel;
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
}
