package badDrum.logic.equationPuzzle;

import java.lang.Math;
import java.util.Arrays;

public class PuzzleLogic {

    private static final int[] varArray = new int[4];
    private static int x;
    private static int a;
    private static int b;
    private static int c;
    public static int localSignal;

    public void main() {
        generateVars();
        int result = PuzzleDialog.getResult();
        checkAnswer(result);
    }

    public static void generateVars(){
        for (int i = varArray.length - 2; i >= 0; i--){
            varArray[i] = (int) ((Math.random()*21)  +10);
        }
        x = varArray[0];
        a = varArray[1];
        b = varArray[2];
        // Calculates c
        varArray[3] = (a * x) + b;
        c = varArray[3];
        System.out.printf("x: %d, a: %d, b: %d, c: %d\n", x, a, b, c);
    }

    public static void checkAnswer(int result) {
        if (result == x) {
            localSignal = 1; // signal 1 -> puzzle solved
        } else {
            localSignal = 0; // signal 2 -> retry
        }
    }
    
    public static int[] getEquat() {
        generateVars();
        int[] equat = new int[3];
        System.arraycopy(varArray, 1, equat, 0, 3);
        System.out.println("equat: ");
        System.out.println(Arrays.toString(equat));
        return equat;
    }
    
    public static int getSignal() {
        int signal = PuzzleDialog.getSignal();
        if (signal >=10) {
            return localSignal;
        } else {
            return signal;
        }
    }
}
