package badDrum.logic;

public class StateManager<signal> {

    public static int pitchSoundOn;
    public static int signal;

    public void normalPlayMode(int signal) {
        normalUpdate();
        monitorPuzzleMode(signal);
    }

    public void monitorPuzzleMode(int signal){
        if (signal == 1) {
            freeze();
            pitchSoundOn = 1;
        }
    }

    public void setSignal(int signal){
        StateManager.signal = signal;
    }

    public void freeze(){
        System.out.println("Movement logic is frozen");
    }

    public void normalUpdate(){
        System.out.println("Sticks are moving, Drums are playing");
    }
}
