package badDrum.logic.equationPuzzle;

import javax.swing.*;

import java.awt.*;

import static badDrum.logic.equationPuzzle.PuzzleLogic.signal;

public class PuzzleState {

    public static int attemptCount;
    public static int punishLevel;
    public boolean puzzleSolved;

    public static void main(String[] args) throws Exception {
        startPuzzle();
    }

    public static void startPuzzle() throws Exception {
        PuzzleLogic Logic = new PuzzleLogic();
        PuzzleDialog Dialog = new PuzzleDialog();
        attemptCount = 0;
        iteratePuzzle(Logic, Dialog);
    }

    public static void iteratePuzzle(PuzzleLogic Logic, PuzzleDialog Dialog) throws Exception {
        try {
            Dialog.ask();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int signal = Dialog.getSignal();
        boolean puzzleSolved1 = getPuzzleState(signal);
        // for some reason the code stops at this point
        if (puzzleSolved1) {
            Dialog.showSolvedMassage();
        } else {
            attemptCount++;
            punishment(attemptCount);
            switch (signal){
                case 0: int ans = Dialog.showWrongAnsMassage();
                    System.out.println(ans);
                    break;
                case -1: Dialog.showErrorMassage();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + signal);
            }
            iteratePuzzle(Logic, Dialog);
        }
    }

    public static boolean getPuzzleState(int signal) {
        System.out.println("Signal passed to State = " + signal);
        System.out.println("Getting puzzle state..." + puzzleSolved);
        return puzzleSolved;
    }

    public static void punishment(int error){
        switch (error) {
            case 0: punishLevel = 0;
                break;
            case 1: punishLevel = 1;
                break;
            case 2: punishLevel = 2;
                break;
            default: punishLevel = 3;
            System.out.println("Punishment level = " + punishLevel);
        }
    }
    public static int getPunishLevel() {
        return punishLevel;
    }

    public static int getAttemptCount() {
        System.out.println("Attempt count = " + attemptCount);
        return attemptCount;
    }
}
