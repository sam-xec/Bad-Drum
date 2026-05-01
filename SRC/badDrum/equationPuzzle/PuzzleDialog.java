package badDrum.equationPuzzle;

import javax.swing.*;

// this class is created for the JOptionPane dialog
public class PuzzleDialog {

    public static int result;
    private static int signal;

    public void ask(PuzzleLogic Logic) throws Exception {
        int[] equat = Logic.getVarArray();
        System.out.printf("Dialog receive %dx + %d = %d\n", equat[1], equat[2], equat[3]);
        String answer = stateEquation(equat);
        // ======================
        // AI generated section
        // ======================
        // This variable will hold the parsed integer if parsing succeeds
        try {// Attempt to convert the input String to an integer
            result = Integer.parseInt(answer); // MY CODE
            // If we reach this line, the input IS numeric
            // result now contains the integer entered by the user
            signal = Logic.checkAnswer(result); // MY CODE
            System.out.println("Signal in Dialog = " + signal); // MY CODE
            setSignal(signal); // MY CODE
        } catch (NumberFormatException e) {
            // If we reach this block, the input is NOT a valid integer
            // Handle non-numeric input here:
            signal = -1; // MY CODE
            setSignal(signal);// MY CODE
        }
    }
    //===========================
    //MY CODE PART
    //===========================

    public int getSignal() {
        return signal;
    }
    private void setSignal(int signal) {
        PuzzleDialog.signal = signal;
    }

    public String stateEquation(int[] equat) {
        return JOptionPane.showInputDialog(null,
                "Solve this equation: \n" +  // AI GENERATED
                        equat[1] + "x + " + equat[2] + " = " + equat[3] +  // AI
                        "\nEnter x:");                // AI GENERATED
    }

    public void showErrorMassage(){ // - show error dialog
        JOptionPane.showMessageDialog(null,
                "Contract violation! Punishment level-up:)\n " +
                        "Please, enter an integer only");
    }

    public int showWrongAnsMassage(){
        return JOptionPane.showConfirmDialog(null,
                "Ops... Something went wrong!\n" +
                        "Can you hear it? ;)" +
                        "Unfortunately, you are not right:(\n" +
                        "Think about it. What value of" +
                        "\"x\" would satisfy this equation?\n");
    }
    public void showSolvedMassage(){
        JOptionPane.showMessageDialog(null,
                "Wow! That is so sophisticated!\n" +
                        "Are you a math genius?!");
    }
}
