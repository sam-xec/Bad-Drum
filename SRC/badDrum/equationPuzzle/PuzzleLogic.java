package badDrum.equationPuzzle;

import java.lang.Math;
import java.util.Arrays;

import static java.lang.System.*;

public class PuzzleLogic {

    private static final int[] varArray = new int[4];
    private static int x;
    private static int a;
    private static int b;
    private static int c;
    public static int signal;

    public void generateVars(){
        for (int i = varArray.length - 2; i >= 0; i--){
            varArray[i] = (int) ((Math.random()*21)  +10);
        }
        x = varArray[0];
        a = varArray[1];
        b = varArray[2];
        // Calculates c
        varArray[3] = (a * x) + b;
        c = varArray[3];
        out.printf("x: %d, a: %d, b: %d, c: %d\n", x, a, b, c);
    }

    public int checkAnswer(int result) {
        if (result == x) {
            signal = 1; // signal 1 -> puzzle solved
        } else {
            signal = 0; // signal 2 -> retry
        }
        return signal;
    }
    
    public int[] getVarArray() {
        out.println("varArray: ");
        out.println(Arrays.toString(varArray));
        return varArray;
    }
}
