package badDrum.ui;
import java.awt.*;

public class Stick {

    // ============================
    //  DATA (FIELDS)
    // ============================

    private int x;          // MY CODE
    private int y;          // MY CODE
    private int length;     // MY CODE
    private Color color;    // MY CODE
    private int angle;      // AI

    // ============================
    //  CONSTRUCTOR
    // ============================
    public Stick(int x, int y, int length, Color color) {
        this.x = x;             // MY CODE
        this.y = y;             // MY CODE
        this.length = length;   // MY CODE
        this.color = color;     // MY CODE
        this.angle = -45;       //  AI
    }

    // ============================
    //  METHOD: DRAW
    // ============================
    public void draw(Graphics g) {

        g.setColor(color);      // MY CODE

        // AI
        int x2 = x + (int)(length * Math.cos(Math.toRadians(angle)));
        int y2 = y + (int)(length * Math.sin(Math.toRadians(angle)));

        g.drawLine(x, y, x2, y2); // MY CODE
    }

    // ============================
    //  METHOD: HIT 
    // ============================
    public void hit() {
        angle = -70;            //AI
    }

    // ============================
    //  METHOD: RESET
    // ============================
    public void reset() {
        angle = -45;            // AI
    }
}
