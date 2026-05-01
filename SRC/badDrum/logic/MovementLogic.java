package badDrum.logic;

import badDrum.ui.Drum;
import badDrum.ui.LeftStick;
import badDrum.ui.RightStick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovementLogic extends JPanel implements MouseMotionListener, KeyListener {

    //MY CODE
    private static final int W = 1280;
    private static final int H = 720;

    private int mouseX;
    private int mouseY;

    private int keyX;
    private int keyY;
    private static final int KEY_STEP = 8;

    //MY CODE
    private Drum drum;
    private LeftStick leftStick;
    private RightStick rightStick;

    public MovementLogic() {
        setPreferredSize(new Dimension(W, H));
        setBackground(Color.WHITE);
        setFocusable(true);

        mouseX = W / 3;
        mouseY = H / 2;
        keyX   = W * 2 / 3;
        keyY   = H / 2;

        drum       = new Drum(W / 2, H / 2 + 60);
        leftStick  = new LeftStick(mouseX, mouseY);
        rightStick = new RightStick(keyX,   keyY);

        addMouseMotionListener(this);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drum.draw(g2);
        leftStick.draw(g2);
        rightStick.draw(g2);
        drawHUD(g2);
    }

    //MY CODE
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
        g2.drawString(String.format("Mouse: (%4d, %4d)   Keys: (%4d, %4d)",
                mouseX, mouseY, keyX, keyY), 20, H - 12);
    }

    //AI CODE
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        // not moves unless movement applies
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        // not moves unless movement applies
        repaint();
    }

    //AI CODE
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
        // not moves unless movement applies
        repaint();
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    /**
     * Applies movement based on the current input state.
     * This method MUST be called from the game loop.
     * If it is not called (PUZZLE state), movement freezes automatically.
     */
    public void applyMovement() {
            leftStick.setPosition(mouseX, mouseY);
            rightStick.setPosition(keyX, keyY);
    }
}
