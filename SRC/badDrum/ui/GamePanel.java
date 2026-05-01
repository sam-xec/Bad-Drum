package badDrum.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements MouseMotionListener, KeyListener {

    private Drum drum;               // MY CODE — drumset object
    private LeftStick leftStick;     // MY CODE — левая палочка (мышь)
    private RightStick rightStick;   // MY CODE — правая палочка (клавиатура)

    private JButton instructionButton; // MY CODE — button
    private String lastHit = "";       // MY CODE — stores last clicked drum

    // MY CODE — позиции палочек
    private int leftX, leftY;
    private int rightX, rightY;
    private static final int KEY_STEP = 8;

    public GamePanel() {

        // MY CODE — background color
        setBackground(new Color(240, 230, 210));
        setLayout(null);
        setFocusable(true); // MY CODE — нужно для KeyListener

        // MY CODE — instructions button
        instructionButton = new JButton("Instructions");
        instructionButton.setFont(new Font("Georgia", Font.BOLD, 24));
        instructionButton.setBackground(new Color(180, 140, 90));
        instructionButton.setForeground(Color.WHITE);
        instructionButton.setFocusPainted(false);
        instructionButton.setBorderPainted(false);
        instructionButton.setBounds(30, 30, 220, 60);
        add(instructionButton);

        // AI CODE — open instructions window
        instructionButton.addActionListener(e -> new InstructionFrame());

        // MY CODE — слушаем движение мыши и клавиатуру
        addMouseMotionListener(this);
        addKeyListener(this);

        // AI CODE — mouse click detection using hitmap
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (drum == null) return;
                lastHit = drum.detectHit(e.getX(), e.getY());
                repaint();
            }
        });
    }

    // MY CODE — инициализируем объекты один раз при первом отображении
    @Override
    public void addNotify() {
        super.addNotify();
        // FIX: defer initialization until layout is done and panel has real size
        SwingUtilities.invokeLater(() -> {
            int cx = getWidth() > 0  ? getWidth() / 2  : 640;
            int cy = getHeight() > 0 ? getHeight() / 2 + 40 : 400;

            drum = new Drum(cx, cy);

            // MY CODE — начальные позиции палочек
            leftX  = cx - 200;  leftY  = cy - 80;
            rightX = cx + 200;  rightY = cy - 80;

            leftStick  = new LeftStick(leftX, leftY);
            rightStick = new RightStick(rightX, rightY);

            repaint();
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // AI CODE — smooth rendering
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // MY CODE — если объекты ещё не созданы — создаём
        if (drum == null) {
            int cx = getWidth() / 2;
            int cy = getHeight() / 2 + 40;
            drum = new Drum(cx, cy);
            leftX  = cx - 200;  leftY  = cy - 80;
            rightX = cx + 200;  rightY = cy - 80;
            leftStick  = new LeftStick(leftX, leftY);
            rightStick = new RightStick(rightX, rightY);
        }

        int cx = getWidth() / 2;
        int cy = getHeight() / 2 + 40;

        // AI CODE — draw drumset and sticks
        drum.draw(g2);
        leftStick.draw(g2);   // MY CODE — левая (мышь)
        rightStick.draw(g2);  // MY CODE — правая (клавиатура)

        // MY CODE — подсказка управления
        g2.setFont(new Font("Monospaced", Font.BOLD, 14));
        g2.setColor(new Color(40, 100, 220));
        g2.fillOval(20, 100, 12, 12);
        g2.setColor(Color.DARK_GRAY);
        g2.drawString("Left stick  — mouse", 40, 111);
        g2.setColor(new Color(200, 40, 40));
        g2.fillOval(20, 120, 12, 12);
        g2.setColor(Color.DARK_GRAY);
        g2.drawString("Right stick — WASD / arrows", 40, 131);

        // AI CODE — highlight clicked area (simple yellow overlay)
        g2.setColor(new Color(255, 255, 0, 80));
        switch (lastHit) {
            case "snare"       -> drawHit(g2, cx, cy,    0,  -40);
            case "tomLeft"     -> drawHit(g2, cx, cy, -120,  -80);
            case "tomRight"    -> drawHit(g2, cx, cy,  120,  -80);
            case "floorLeft"   -> drawHit(g2, cx, cy, -130,   20);
            case "floorRight"  -> drawHit(g2, cx, cy,  130,   20);
            case "kick"        -> drawHit(g2, cx, cy,    0,   80);
            case "cymbalLeft"  -> drawHit(g2, cx, cy, -180, -160);
            case "cymbalRight" -> drawHit(g2, cx, cy,  180, -160);
        }
    }

    // AI CODE — simple highlight circle
    private void drawHit(Graphics2D g2, int cx, int cy, int dx, int dy) {
        g2.fillOval(cx + dx - 40, cy + dy - 40, 80, 80);
    }

    // ── мышь → левая палочка ────────────────────────────────────────────

    @Override
    public void mouseMoved(MouseEvent e) {
        leftX = e.getX();
        leftY = e.getY();
        if (leftStick != null) leftStick.setPosition(leftX, leftY); // MY CODE
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        leftX = e.getX();
        leftY = e.getY();
        if (leftStick != null) leftStick.setPosition(leftX, leftY); // MY CODE
        repaint();
    }

    // ── клавиатура → правая палочка ─────────────────────────────────────

    @Override
    public void keyPressed(KeyEvent e) {
        int w = getWidth() > 0 ? getWidth() : 1280;
        int h = getHeight() > 0 ? getHeight() : 720;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: case KeyEvent.VK_UP:    rightY -= KEY_STEP; break;
            case KeyEvent.VK_S: case KeyEvent.VK_DOWN:  rightY += KEY_STEP; break;
            case KeyEvent.VK_A: case KeyEvent.VK_LEFT:  rightX -= KEY_STEP; break;
            case KeyEvent.VK_D: case KeyEvent.VK_RIGHT: rightX += KEY_STEP; break;
        }
        rightX = Math.max(20, Math.min(w - 20, rightX));
        rightY = Math.max(20, Math.min(h - 20, rightY));
        if (rightStick != null) rightStick.setPosition(rightX, rightY); // MY CODE
        repaint();
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
