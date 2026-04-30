package badDrum.logic;

import badDrum.logic.equationPuzzle.PuzzleState;

public class StateManager<T> {

    public static boolean pitchSoundOn;
    private T signal;

    public void normalPlayMode(T signal) throws Exception {
        normalUpdate();
        monitorPuzzleMode(signal);
    }

    public void monitorPuzzleMode(T signal) throws Exception {
        if ((boolean) signal) {
            freeze();
            pitchSoundOn = true;
            PuzzleState state = new PuzzleState();
            state.startPuzzle();
        }
    }

    public void backToNormal(PuzzleState p){
        boolean solved = p.puzzleSolved;
        if (solved){
            p = null;
        }
    }

    public void setSignal(T signal){
        this.signal = signal;
    }

    public void freeze(){
        System.out.println("Movement logic is frozen");
    }

    public void normalUpdate(){
        System.out.println("Sticks are moving, Drums are playing");
    }
}
