package badDrum.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {

    private Drum drum;    // MY CODE — drumset object
    private LeftStick leftStick;
    private RightStick rightStick; // MY CODE — drumsticks object
    private JButton instructionButton; // MY CODE — button
    private String lastHit = ""; // MY CODE — stores last clicked drum

    public GamePanel() {

        // MY CODE — background color
        setBackground(new Color(240, 230, 210));

        // MY CODE — manual layout
        setLayout(null);

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

        // AI CODE — mouse click detection using hitmap
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (drum == null) return;

                int mx = e.getX();
                int my = e.getY();

                // AI CODE — detect hit using hitmap
                lastHit = drum.detectHit(mx, my);

                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // AI CODE — smooth rendering
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // MY CODE — center of screen
        int cx = getWidth() / 2;
        int cy = getHeight() / 2 + 40;

        // MY CODE — create objects
        drum = new Drum(cx, cy);
         leftStick = new LeftStick(cx, cy);
         rightStick = new RightStick(cx, cy);

        // AI CODE — draw drumset and sticks
        drum.draw(g2);
        leftStick.draw(g2);
        rightStick.draw(g2);

        // AI CODE — highlight clicked area (simple yellow overlay)
        g2.setColor(new Color(255, 255, 0, 80));

        switch (lastHit) {
            case "snare"      -> drawHit(g2, cx, cy, 0, -40);
            case "tomLeft"    -> drawHit(g2, cx, cy, -120, -80);
            case "tomRight"   -> drawHit(g2, cx, cy, 120, -80);
            case "floorLeft"  -> drawHit(g2, cx, cy, -130, 20);
            case "floorRight" -> drawHit(g2, cx, cy, 130, 20);
            case "kick"       -> drawHit(g2, cx, cy, 0, 80);
            case "cymbalLeft" -> drawHit(g2, cx, cy, -180, -160);
            case "cymbalRight"-> drawHit(g2, cx, cy, 180, -160);
        }
    }

    // AI CODE — simple highlight circle
    private void drawHit(Graphics2D g2, int cx, int cy, int dx, int dy) {
        g2.fillOval(cx + dx - 40, cy + dy - 40, 80, 80);
    }
}