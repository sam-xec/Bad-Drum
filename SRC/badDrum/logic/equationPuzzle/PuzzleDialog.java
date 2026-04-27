package badDrum.logic.equationPuzzle;

import javax.swing.*;

// this class is created for the JOptionPane dialog
public class PuzzleDialog {
    public static int result;
    private static int signal;
    private static int errorCount = 0;

    static void main() throws Exception {
        int a = PuzzleLogic.getEquat(0);
        int b = PuzzleLogic.getEquat(1);
        int c = PuzzleLogic.getEquat(2);
        System.out.printf("%dx + %d = %d\n", a, b, c);
        String answer = JOptionPane.showInputDialog(null,
                "Solve this equation: \n" +  // AI
                        a + "x + " + b + " = " + c +  // AI
                        "\nEnter x:");                // AI
        // ======================
        // AI generated section
        // ======================
        // answer is the String returned by JOptionPane
        // This variable will hold the parsed integer if parsing succeeds
        int parsedValue;

        try {
            // Attempt to convert the input String to an integer
            result = Integer.parseInt(answer); // MY CODE
            signal = result;                    // My CODE
            JOptionPane.showMessageDialog(null,
                    "Wow! That is so sophisticated!\n" +
                            "Are you a math genius?!");

            // If we reach this line, the input IS numeric
            // parsedValue now contains the integer entered by the user

        } catch (NumberFormatException e) {
            // If we reach this block, the input is NOT a valid integer
            // This includes letters, symbols, empty strings, or mixed input

            // Handle non-numeric input here:
            signal = -1;        // MY CODE
            JOptionPane.showMessageDialog(null,
                    "Contract violation! Punishment level-up:)\n Please, enter an integer only"); // MY CODE
            // - show error dialog
                errorCount++; // MY CODE
            // - escalate punishment

            // - restart the puzzle
        }
        //===========================
        //MY CODE PART
        //===========================
        int s = PuzzleLogic.getSignal();
        System.out.println("signal: " + s);
    }

    public static int getSignal() {
        return signal;
    }

    public static int getResult() {
        return result;
    }

    public static void setSignal(int signal) {
        PuzzleDialog.signal = signal;
    }

    public static int getErrorCount() {
        return errorCount;
    }

    public static void setErrorCount(int errorCount) {
        PuzzleDialog.errorCount = errorCount;
    }
}
