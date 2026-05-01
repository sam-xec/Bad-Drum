package badDrum.logic;

import badDrum.ui.Drum;
import badDrum.ui.Stick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovementLogic extends JPanel implements MouseMotionListener, KeyListener {

    //размеры окна
    private static final int W = 1280;
    private static final int H = 720;

    //позиции стиков ────────────────────────────────────────────────────────
    private int mouseX;
    private int mouseY;

    private int keyX;
    private int keyY;
    private static final int KEY_STEP = 8;

    //барабан и палочки ─────────────────────────────────────────────────────
    private Drum drum;
    private Stick mouseStick;  // MY CODE — палочка от мыши
    private Stick keyStick;    // MY CODE — палочка от клавиатуры

    public MovementLogic() {
        setPreferredSize(new Dimension(W, H));
        setBackground(Color.WHITE); // MY CODE
        setFocusable(true);

        //Начальные позиции
        mouseX = W / 3;
        mouseY = H / 2;
        keyX   = W * 2 / 3;
        keyY   = H / 2;

        drum       = new Drum(W / 2, H / 2 + 60);        // MY CODE
        mouseStick = new Stick(mouseX, mouseY);            // MY CODE
        keyStick   = new Stick(keyX,   keyY);              // MY CODE

        addMouseMotionListener(this);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drum.draw(g2);            // MY CODE
        mouseStick.draw(g2);      // MY CODE
        keyStick.draw(g2);        // MY CODE
        drawHUD(g2);
    }

    private void drawHUD(Graphics2D g2) {
        g2.setFont(new Font("Monospaced", Font.BOLD, 15));

        g2.setColor(new Color(40, 100, 220));
        g2.fillOval(20, 18, 14, 14);
        g2.setColor(Color.DARK_GRAY);
        g2.drawString("Left stick  - mouse", 42, 30);

        g2.setColor(new Color(200, 40, 40));
        g2.fillOval(20, 42, 14, 14);
        g2.setColor(Color.DARK_GRAY);
        g2.drawString("Right stick - WASD / arrows", 42, 54);

        g2.setColor(new Color(150, 150, 150));
        g2.setFont(new Font("Monospaced", Font.PLAIN, 12));
        g2.drawString(String.format("Мышь: (%4d, %4d)   Клав: (%4d, %4d)",
                mouseX, mouseY, keyX, keyY), 20, H - 12);
    }

    //обработка мыши

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        mouseStick.setPosition(mouseX, mouseY); // MY CODE
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        mouseStick.setPosition(mouseX, mouseY); // MY CODE
        repaint();
    }

    //обработка клавиатуры

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: case KeyEvent.VK_UP:    keyY -= KEY_STEP; break;
            case KeyEvent.VK_S: case KeyEvent.VK_DOWN:  keyY += KEY_STEP; break;
            case KeyEvent.VK_A: case KeyEvent.VK_LEFT:  keyX -= KEY_STEP; break;
            case KeyEvent.VK_D: case KeyEvent.VK_RIGHT: keyX += KEY_STEP; break;
        }
        keyX = Math.max(20, Math.min(W - 20, keyX));
        keyY = Math.max(20, Math.min(H - 20, keyY));
        keyStick.setPosition(keyX, keyY); // MY CODE
        repaint();
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
