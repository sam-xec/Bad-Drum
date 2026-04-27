package badDrum.logic.equationPuzzle;

import javax.swing.*;

// this class is created for the JOptionPane dialog
public class PuzzleDialog {
    public static int result;
    private static int signal;
    private static int errorCount = 0;

    static void main() throws Exception {
        PuzzleLogic.main();
        int[] equat = PuzzleLogic.getVarArray();
        System.out.printf("%dx + %d = %d\n", equat[1], equat[2], equat[3]);
        String answer = JOptionPane.showInputDialog(null,
                "Solve this equation: \n" +  // AI
                        equat[1] + "x + " + equat[2] + " = " + equat[3] +  // AI
                        "\nEnter x:");                // AI
        // ======================
        // AI generated section
        // ======================
        // This variable will hold the parsed integer if parsing succeeds
        try {
            // Attempt to convert the input String to an integer
            result = Integer.parseInt(answer); // MY CODE
            // If we reach this line, the input IS numeric
            // result now contains the integer entered by the user
            signal = PuzzleLogic.getSignal();
            System.out.println("Signal in Dialog = " + signal);
            PuzzleDialog.setSignal(signal);
        } catch (NumberFormatException e) {
            // If we reach this block, the input is NOT a valid integer
            // This includes letters, symbols, empty strings, or mixed input

            // Handle non-numeric input here:
            signal = -1; // MY CODE
            PuzzleDialog.setSignal(signal);// MY CODE
            // - show error dialog
            JOptionPane.showMessageDialog(null,
                    "Contract violation! Punishment level-up:)\n " +
                            "Please, enter an integer only"); // MY CODE
            // - escalate punishment
            errorCount++; // MY CODE
            PuzzleDialog.setErrorCount(errorCount);
            // - restart the puzzle
            PuzzleState.restartPuzzle();
        }
        //===========================
        //MY CODE PART
        //===========================
        int s = PuzzleLogic.getSignal();
        System.out.println("signal: " + s +". Dialog.main has run");
    }

    public static int getSignal() {
        return signal;
    }
    private static void setSignal(int signal) {
        PuzzleDialog.signal = signal;
    }

    public static int getResult() {
        return result;
    }

    public static int getErrorCount() {
        return errorCount;
    }

    public static void setErrorCount(int errorCount) {
        PuzzleDialog.errorCount = errorCount;
    }
}
