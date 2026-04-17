package badDrum.ui;
import java.awt.*;
public class Drum  {

    // ============================
    //  DATA (FIELDS)
    // ============================

    private int x;          // MY CODE
    private int y;          // MY CODE
    private int width;     // MY CODE
    private int height;     // MY CODE
    private Color color;    // MY CODE
    private String name ;     // MY CODE


    // ============================
    //  CONSTRUCTOR
    // ============================
    public Drum(int x, int y, int width, int height, Color color, String name) {
        this.x = x;             // MY CODE
        this.y = y;             // MY CODE
        this.width = width;     // MY CODE
        this.height = height;   // MY CODE
        this.color = color;     // MY CODE
        this.name = name;       // MY CODE
    }

    // ============================
    //  METHOD: DRAW
    // ============================
    public void draw(Graphics g) {

        g.setColor(color);      // MY CODE
        g.fillOval(x, y, width, height); // MY CODE
    }
    }
