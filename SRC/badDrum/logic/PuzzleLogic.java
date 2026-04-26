package badDrum.logic;

import java.lang.Math;

public class PuzzleLogic {

private int a;
private int b;
private int c;
public int x;

public static generateVars(){
    a = (int) Math.random()*21 +10;
    b = (int) Math.random()*21 +10;
    x = (int) Math.random()*21 +10;
}

public static calculateC(){
    c = a*x + b;
}

}
