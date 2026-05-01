package badDrum.sound;

import javax.sound.sampled.FloatControl;
import java.lang.Math.*;

public class VolumeControl {

    public static final int MAX_VOLUME = 6; //hard upper limit
    private static final int MIN_VOLUME = -80;// mute = -80
    public static float baseVolume = -10;   // My Code

    public static float volumeLevel;
    private boolean locked;

    static FloatControl vol;

    public VolumeControl(float level) { }

    public void requestVolumeChange(float delta){
        if (locked && delta < 0){
            if (true){
                return;
            } else {
                delta = -delta;
            }
        }
        float level = changeVolume(delta);
        vol = getEffectiveVolume(level);
    }

    public FloatControl getEffectiveVolume(float level){
        vol.setValue(level);
        return vol;
    }

    private float changeVolume(float delta){
        volumeLevel = volumeLevel + delta;
        if(volumeLevel > MAX_VOLUME) volumeLevel = MAX_VOLUME;
        if(volumeLevel < MIN_VOLUME) volumeLevel = MIN_VOLUME;
        return volumeLevel;
    }

    public boolean isLocked(){
        return locked;
    }

    public void lockVolume(){
        locked = true;
    }

    private void unlockVolume(){
        locked = false;
    }

    public void reset(){
        volumeLevel = baseVolume;
        unlockVolume();
    }
}
