package badDrum.ui;

import java.awt.*;

public class RightStick {

    // MY CODE — center point (can be updated at runtime)
    private int cx;
    private int cy;

    // MY CODE — color of the stick
    private final Color STICK_COLOR = new Color(90, 70, 40);

    public RightStick(int centerX, int centerY) {
        this.cx = centerX;
        this.cy = centerY;
    }

    // MY CODE — update position (called by MovementLogic on key press)
    public void setPosition(int centerX, int centerY) {
        this.cx = centerX;
        this.cy = centerY;
    }

    // MY CODE — draw the right stick
    public void draw(Graphics2D g2) {
        g2.setColor(STICK_COLOR);
        g2.setStroke(new BasicStroke(10)); // AI code — thickness of the stick

        // AI code — right stick drawn at an angle
        g2.drawLine(
                cx + 180, cy + 120,   // upper point of the stick
                cx + 40,  cy + 40     // lower point (stick tip)
        );
    }
}
