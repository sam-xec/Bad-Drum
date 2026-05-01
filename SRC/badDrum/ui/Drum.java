package badDrum.ui;

import java.awt.*;

public class Drum {

    private int cx; // MY CODE — center X of the drum set
    private int cy; // MY CODE — center Y of the drum set

    // ============================
    // COLORS (dark red sides)
    // ============================

    private final Color SIDE_RED = new Color(120, 0, 0);        // MY CODE — dark red for all drums
    private final Color TOP_WHITE = new Color(250, 250, 250);   // MY CODE — white drumhead
    private final Color BOTTOM_DARK = new Color(30, 30, 30);    // MY CODE — dark bottom ellipse
    private final Color METAL = new Color(210, 210, 210);       // MY CODE — silver metal rim
    private final Color CYMBAL = new Color(230, 200, 70);       // MY CODE — golden cymbal
    private final Color LEG = new Color(0, 0, 0);               // MY CODE — black stands

    // Back drums use same dark red
    private final Color BACK_SIDE = new Color(120, 0, 0);       // MY CODE — same dark red
    private final Color BACK_TOP = new Color(240, 240, 240);    // MY CODE
    private final Color BACK_BOTTOM = new Color(20, 20, 20);    // MY CODE

    public Drum(int centerX, int centerY) {
        this.cx = centerX; // MY CODE
        this.cy = centerY; // MY CODE
    }

    public void draw(Graphics2D g2) {

        // ============================================
        // DRUM LEGS FOR SMALL TOMS (unchanged)
        // ============================================
        drawDrumLegs(g2, cx - 150, cy - 20, 160, 75); // MY CODE — left tom legs
        drawDrumLegs(g2, cx + 30,  cy - 20, 160, 75); // MY CODE — right tom legs

        // ============================================
        // CYMBAL STANDS
        // ============================================
        drawCymbalLegs(g2, cx - 260, cy - 170, 200, 45); // MY CODE — left cymbal stand
        drawCymbalLegs(g2, cx + 60,  cy - 170, 200, 45); // MY CODE — right cymbal stand

        // ============================================
        // SMALL TILTED TOMS (shifted right)
        // ============================================
        drawTiltedDrum(g2, cx - 150, cy - 20, 160, 75); // AI CODE — left tom moved right
        drawTiltedDrum(g2, cx + 30,  cy - 20, 160, 75); // AI CODE — right tom moved right

        // ============================================
        // CYMBALS (moved slightly forward)
        // ============================================
        drawCymbal(g2, cx - 260, cy - 170, 200, 45); // MY CODE — left cymbal moved forward
        drawCymbal(g2, cx + 60,  cy - 170, 200, 45); // MY CODE — right cymbal moved forward

        // ============================================
        // DRUM LEGS FOR BIG DRUMS
        // ============================================
        drawDrumLegs(g2, cx - 230, cy + 40, 200, 110); // MY CODE
        drawDrumLegs(g2, cx + 230, cy + 40, 200, 120); // MY CODE
        drawDrumLegs(g2, cx - 200, cy + 110, 400, 180); // MY CODE

        // ============================================
        // BACK DRUMS
        // ============================================
        draw3DDrumBack(g2, cx - 230, cy + 40, 200, 110); // AI CODE
        draw3DDrumBack(g2, cx + 230, cy + 40, 200, 120); // AI CODE

        // ============================================
        // FRONT KICK DRUM
        // ============================================
        draw3DDrumFront(g2, cx - 200, cy + 140, 400, 180); // AI CODE
    }

    // ============================
    // CYMBAL
    // ============================
    private void drawCymbal(Graphics2D g2, int x, int y, int w, int h) {

        // SHADOW UNDER CYMBAL
        g2.setColor(new Color(0, 0, 0, 30)); // AI CODE
        g2.fillOval(x + w/4, y + h + 40, w/2, h/3); // AI CODE

        // CYMBAL SHAPE
        g2.setColor(CYMBAL); // MY CODE
        g2.fillOval(x, y, w, h); // MY CODE
    }

    // ============================
    // CYMBAL STANDS
    // ============================
    private void drawCymbalLegs(Graphics2D g2, int x, int y, int w, int h) {

        g2.setColor(LEG); // MY CODE
        g2.setStroke(new BasicStroke(8)); // AI CODE

        int cx = x + w / 2;     // AI CODE
        int top = y + h;        // AI CODE
        int bottom = top + 160; // AI CODE

        g2.drawLine(cx, top, cx - 40, bottom); // MY CODE
        g2.drawLine(cx, top, cx + 40, bottom); // MY CODE
        g2.drawLine(cx - 40, bottom, cx + 40, bottom); // MY CODE
    }

    // ============================
    // DRUM LEGS
    // ============================
    private void drawDrumLegs(Graphics2D g2, int x, int y, int w, int h) {

        g2.setColor(LEG); // MY CODE
        g2.setStroke(new BasicStroke(7)); // AI CODE

        int left = x + 20;          // MY CODE
        int right = x + w - 20;     // MY CODE
        int bottom = y + h + 60;    // MY CODE

        g2.drawLine(left, y + h, left - 25, bottom); // MY CODE
        g2.drawLine(right, y + h, right + 25, bottom); // MY CODE
        g2.drawLine(left - 25, bottom, right + 25, bottom); // MY CODE
    }

    // ============================
    // SMALL TILTED DRUMS
    // ============================
    private void drawTiltedDrum(Graphics2D g2, int x, int y, int w, int h) {

        g2.setColor(SIDE_RED); // MY CODE
        g2.fillOval(x, y, w, h); // MY CODE

        g2.fillOval(x + 10, y + 18, w - 20, h); // AI CODE — tilt shadow

        g2.setColor(METAL); // MY CODE
        g2.setStroke(new BasicStroke(3)); // AI CODE
        g2.drawOval(x, y, w, h); // MY CODE
        g2.drawOval(x + 10, y + 18, w - 20, h); // MY CODE

        g2.setColor(new Color(255, 255, 255, 120)); // AI CODE — highlight
        g2.drawOval(x + 4, y + 4, w - 8, h - 8); // AI CODE
    }

    // ============================
    // BACK DRUMS
    // ============================
    private void draw3DDrumBack(Graphics2D g2, int x, int y, int w, int h) {

        g2.setColor(new Color(0, 0, 0, 40)); // AI CODE — shadow
        g2.fillOval(x, y + h, w, h / 4); // AI CODE

        g2.setColor(BACK_SIDE); // MY CODE
        g2.fillRect(x, y + h / 6, w, h / 2); // MY CODE

        g2.setColor(BACK_TOP); // MY CODE
        g2.fillOval(x, y, w, h / 3); // MY CODE

        g2.setColor(BACK_BOTTOM); // MY CODE
        g2.fillOval(x, y + h / 2, w, h / 3); // MY CODE

        g2.setColor(METAL); // MY CODE
        g2.setStroke(new BasicStroke(4)); // AI CODE
        g2.drawOval(x, y, w, h / 3); // MY CODE
        g2.drawOval(x, y + h / 2, w, h / 3); // MY CODE

        g2.drawLine(x, y + h/6, x + w, y + h/6); // MY CODE
        g2.drawLine(x, y + h/6 + h/2, x + w, y + h/6 + h/2); // MY CODE
    }

    // ============================
    // FRONT KICK DRUM
    // ============================
    private void draw3DDrumFront(Graphics2D g2, int x, int y, int w, int h) {

        g2.setColor(new Color(0, 0, 0, 40)); // AI CODE — shadow
        g2.fillOval(x, y + h, w, h / 4); // AI CODE

        g2.setColor(SIDE_RED); // MY CODE
        g2.fillRect(x, y + h / 6, w, h / 2); // MY CODE

        g2.setColor(TOP_WHITE); // MY CODE
        g2.fillOval(x, y, w, h / 3); // MY CODE

        g2.setColor(BOTTOM_DARK); // MY CODE
        g2.fillOval(x, y + h / 2, w, h / 3); // MY CODE

        g2.setColor(METAL); // MY CODE
        g2.setStroke(new BasicStroke(4)); // AI CODE
        g2.drawOval(x, y, w, h / 3); // MY CODE
        g2.drawOval(x, y + h / 2, w, h / 3); // MY CODE

        g2.drawLine(x, y + h/6, x + w, y + h/6); // MY CODE
        g2.drawLine(x, y + h/6 + h/2, x + w, y + h/6 + h/2); // MY CODE
    }
}