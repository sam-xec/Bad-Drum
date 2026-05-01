package badDrum.sound;

public class VolumeControl {

    public static final int MAX_VOLUME = -10; //hard upper limit
    private static final int MIN_VOLUME = -80;// mute = -80
    public static float baseVolume = -10;   // My Code

    public float volumeLevel;
    private boolean locked;

    public VolumeControl() {
        this.volumeLevel = baseVolume;
        System.out.println("I am a new Volume Control");
    }

    public void requestVolumeChange(float delta){
        if (locked && delta < 0){
            if (random4() != 0){
                return;
            } else {
                delta = -delta;
            }
        }
        volumeLevel = changeVolume(delta);
    }

    public float getEffectiveVolume(){
        return volumeLevel;
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

    private int random4(){
        return (int) (Math.random()*4);
    }
}
