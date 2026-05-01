package badDrum.sound;

import javax.sound.sampled.FloatControl;

public class VolumeControl {
    static FloatControl vol;  // My Code

    public int baseVolume ;       // normal volume level
    // current working volume
    public static float volumeLevel = -10; /* mute = -80*/ // My Code
    public static int MAX_VOLUME = 6;        // hard upper limit
    public boolean locked;            // boolean: can volume be reduced?
    public int punishmentLevel  ;// integer or small enum

    public VolumeControl(float level) {
        MAX_VOLUME = 6;
        setVolumeLevel(level);
    }

    public void setVolumeLevel(float level){
        volumeLevel = level;
    }

    public FloatControl getEffectiveVolume(int delta){
        return vol;
    }

    public void increaseVolume(){

    }

    public void reduceVolume(){

    }

    public void lockVolume(){

    }

    public void unlockVolume(){

    }

    public boolean isLocked(){
        return locked;
    }

    public void escalatePunishment(){

    }
}
