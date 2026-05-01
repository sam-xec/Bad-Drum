package badDrum.ui;

import java.awt.*;

public class Drum {

    private int cx; // MY CODE 
    private int cy; // MY CODE 

    
    private final Color DRUM_COLOR = new Color(150, 150, 150); // MY CODE 
    private final Color METAL = new Color(200, 200, 200);      // MY CODE 
    private final Color CYMBAL = new Color(230, 200, 90);      // MY CODE 
    private final Color LEG = new Color(0, 0, 0);              // MY CODE 

    public Drum(int centerX, int centerY) {
        this.cx = centerX; // MY CODE
        this.cy = centerY; // MY CODE
    }

    public void draw(Graphics2D g2) {

        
        drawDrumLegs(g2, cx - 150, cy - 10, 160, 75); //my code
        drawDrumLegs(g2, cx + 10,  cy - 10, 160, 75); //my code 

        
        drawCymbalLegs(g2, cx - 260, cy - 150, 200, 45);//my code 
        drawCymbalLegs(g2, cx + 60,  cy - 150, 200, 45);//my code

        drawTiltedDrum(g2, cx - 150, cy - 10, 160, 75);//AI code
        drawTiltedDrum(g2, cx + 10,  cy - 10, 160, 75);//AI code

       //MY CODE 
        drawCymbal(g2, cx - 260, cy - 150, 200, 45);
        drawCymbal(g2, cx + 60,  cy - 150, 200, 45);
        //MY CODE 
        drawDrumLegs(g2, cx - 230, cy + 40, 200, 110); 
        drawDrumLegs(g2, cx + 230, cy + 40, 200, 120); 
        drawDrumLegs(g2, cx - 200, cy + 110, 400, 180); 

    
        draw3DDrum(g2, cx - 230, cy + 40, 200, 110);//AI code
        draw3DDrum(g2, cx + 230, cy + 40, 200, 120); //AI code
        draw3DDrum(g2, cx - 200, cy + 110, 400, 180); //AI code
    }

    
    private void drawCymbal(Graphics2D g2, int x, int y, int w, int h) {
        g2.setColor(CYMBAL); // MY CODE
        g2.fillOval(x, y, w, h); // MY CODE
    }

    
    private void drawCymbalLegs(Graphics2D g2, int x, int y, int w, int h) {

        g2.setColor(LEG); // MY CODE
        g2.setStroke(new BasicStroke(8)); //AI code

        int cx = x + w / 2;
        int top = y + h;
        int bottom = top + 160;

        // MY CODE 
        g2.drawLine(cx, top, cx - 40, bottom);
        g2.drawLine(cx, top, cx + 40, bottom);
        g2.drawLine(cx - 40, bottom, cx + 40, bottom);
    }

    // ============================================================
    // Ножки барабанов (сложные, соединены)
    // ============================================================
    private void drawDrumLegs(Graphics2D g2, int x, int y, int w, int h) {

        g2.setColor(LEG); // MY CODE
        g2.setStroke(new BasicStroke(7)); //AI code

        int left = x + 20;
        int right = x + w - 20;
        int bottom = y + h + 60;

        // MY CODE 
        g2.drawLine(left, y + h, left - 25, bottom);
        g2.drawLine(right, y + h, right + 25, bottom);

        //AI code
        g2.drawLine(left - 25, bottom, right + 25, bottom);
    }


    private void drawTiltedDrum(Graphics2D g2, int x, int y, int w, int h) {

        g2.setColor(DRUM_COLOR); // MY CODE
        g2.fillOval(x, y, w, h); 

        //AI code
        g2.fillOval(x + 8, y + 14, w - 16, h);

        g2.setColor(METAL); // MY CODE
        g2.setStroke(new BasicStroke(3)); //AI code
        g2.drawOval(x, y, w, h);
        g2.drawOval(x + 8, y + 14, w - 16, h);
    }

    private void draw3DDrum(Graphics2D g2, int x, int y, int w, int h) {

        g2.setColor(DRUM_COLOR); // MY CODE
        g2.fillOval(x, y, w, h / 3); 
        g2.fillRect(x, y + h / 6, w, h / 2); 
        g2.fillOval(x, y + h / 2, w, h / 3); 

        g2.setColor(METAL); // MY CODE
        g2.setStroke(new BasicStroke(4)); //AI code
        g2.drawOval(x, y, w, h / 3);
        g2.drawOval(x, y + h / 2, w, h / 3);
    }
}