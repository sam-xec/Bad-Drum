package badDrum.logic.equationPuzzle;

import javax.swing.*;

import static badDrum.logic.equationPuzzle.PuzzleLogic.signal;

public class PuzzleState {

    public static int attemptCount;
    public static int punishLevel;
    public static boolean puzzleSolved;

    public static void startPuzzle() throws Exception {
        int signal = PuzzleDialog.getSignal();
        // puzzleSolved = puzzleState(signal);
        setPuzzleState(signal);
        boolean puzzleSolved1 = getPuzzleState();
        // for some reason the code stops at this point
        if (puzzleSolved1) {
            JOptionPane.showMessageDialog(null,
                    "Wow! That is so sophisticated!\n" +
                            "Are you a math genius?!");
        } else {
            attemptCount++; // MY CODE
            PuzzleDialog.setErrorCount(attemptCount);
            int errorCount = PuzzleDialog.getErrorCount();
            punishment(errorCount);
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Ops... Something went wrong!\n" +
                            "Can you hear it? ;)" +
                            "Unfortunately, you are not right:(\n" +
                            "Think about it. What value of" +
                            "\"x\" would satisfy this equation?\n");
            restartPuzzle();
        }
    }

    public static void main(String[] args) throws Exception {
        attemptCount = 0;
        try {
            PuzzleDialog.main();
            startPuzzle();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void restartPuzzle() throws Exception {
        try {
            PuzzleDialog.main();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void setPuzzleState(int signal) {
        System.out.println("Signal passed to State = " + signal);
        puzzleSolved = signal == 1;
        PuzzleState.puzzleSolved = puzzleSolved;
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

    public static boolean getPuzzleState() {
        System.out.println("Getting puzzle state..." + puzzleSolved);
        return puzzleSolved;
    }

    public static int getPunishLevel() {
        return punishLevel;
    }

    public static int getAttemptCount() {
        System.out.println("Attempt count = " + attemptCount);
        return attemptCount;
    }
}
