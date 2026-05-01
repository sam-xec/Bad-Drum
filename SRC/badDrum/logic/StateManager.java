package badDrum.logic;

import badDrum.equationPuzzle.PuzzleState;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * StateManager is responsible for the game loop
 * It constantly updates and decides with of two modes should proceed
 * Game mode or Puzzle mode
 * That creates a "freeze effect" without freezing ui threads
 * Thus when the Puzzle starts, you cannot do anything else
 * unless you solve a puzzle **/
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

    public void backToNormal(PuzzleState puzzle){
        boolean solved = puzzle.puzzleSolved;
        if (solved){
            puzzle = null;
        }
    }

    public void setSignal(T signal){
        this.signal = signal;
    }

    public T getSignal() {
        return signal;
    }

    public void freeze(){
        System.out.println("Movement logic is frozen");
    }

    public void normalUpdate(){
        System.out.println("Sticks are moving, Drums are playing");
    }
}
