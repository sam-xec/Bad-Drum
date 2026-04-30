package badDrum.ui;

import java.awt.*;

public class Stick {

    // MY CODE 
    private int cx;
    private int cy;

    // MY CODE 
    private final Color STICK_COLOR = new Color(90, 70, 40);

    public Stick(int centerX, int centerY) {
        this.cx = centerX; // MY CODE
        this.cy = centerY; // MY CODE
    }

    // MY CODE 
    public void draw(Graphics2D g2) {

        g2.setColor(STICK_COLOR); // MY CODE 
        g2.setStroke(new BasicStroke(10)); //AI code

        
        //AI code
        g2.drawLine(
                cx - 180, cy + 120,   
                cx - 40,  cy + 40     
        );

        
        g2.drawLine(
                cx + 180, cy + 120,   
                cx + 40,  cy + 40     
        );
    }
}