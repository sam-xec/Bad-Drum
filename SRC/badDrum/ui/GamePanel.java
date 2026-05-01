package badDrum.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements MouseMotionListener, KeyListener {

    private Drum drum;               // MY CODE — drum 
    private LeftStick leftStick;     // MY CODE — left stick 
    private RightStick rightStick;   // MY CODE — right stick

    private JButton instructionButton; // MY CODE — image button

    private int leftX, leftY;   // MY CODE — left stick position
    private int rightX, rightY; // MY CODE — right stick position
    private static final int KEY_STEP = 8; // MY CODE — movement speed

    public GamePanel() {

        setBackground(new Color(240, 230, 210)); // MY CODE — warm background color 
        setLayout(null); // MY CODE
        setFocusable(true); // MY CODE 

        // MY CODE — load neon jpg image
        ImageIcon neonIcon = new ImageIcon("src/badDrum/ui/instruction.jpg");

       // MY CODE — create the button using the image
       instructionButton = new JButton(neonIcon);

      // AI CODE — remove default Swing visuals
      instructionButton.setBorderPainted(false);
      instructionButton.setContentAreaFilled(false);
      instructionButton.setFocusPainted(false);
      instructionButton.setOpaque(false);

    // MY CODE — place button exactly in the top-left corner
     instructionButton.setBounds(
        0,                                // MY CODE — X = 0
        0,                                // MY CODE — Y = 0
        neonIcon.getIconWidth(),          // MY CODE — original width
        neonIcon.getIconHeight()          // MY CODE — original height
    );

      // MY CODE — add button to panel
      add(instructionButton);

// MY CODE — open instructions window when clicked
instructionButton.addActionListener(e -> {
    InstructionFrame instrFrame = new InstructionFrame(); // MY CODE — open new window
    instrFrame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent we) {
            requestFocusInWindow(); // AI CODE — restore keyboard focus
        }
    });
});


        addMouseMotionListener(this); // MY CODE — mouse control
        addKeyListener(this); // MY CODE — keyboard control
    }

    @Override
    public void addNotify() {
        super.addNotify();

        SwingUtilities.invokeLater(() -> { // AI CODE — wait for layout
            int cx = getWidth() / 2; // MY CODE — center X
            int cy = getHeight() / 2 + 40; // MY CODE — center Y

            drum = new Drum(cx, cy); // MY CODE — create drum

            leftX  = cx - 200; leftY  = cy - 80; // MY CODE — left stick start
            rightX = cx + 200; rightY = cy - 80; // MY CODE — right stick start

            leftStick  = new LeftStick(leftX, leftY); // MY CODE
            rightStick = new RightStick(rightX, rightY); // MY CODE

            repaint(); // MY CODE — draw everything
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g; // AI CODE — smooth graphics
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (drum == null) { // AI CODE — safety check
            int cx = getWidth() / 2;
            int cy = getHeight() / 2 + 40;
            drum = new Drum(cx, cy);
            leftStick  = new LeftStick(cx - 200, cy - 80);
            rightStick = new RightStick(cx + 200, cy - 80);
        }

        drum.draw(g2); // MY CODE — draw drum
        leftStick.draw(g2); // MY CODE — draw left stick
        rightStick.draw(g2); // MY CODE — draw right stick
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        leftX = e.getX(); // MY CODE — update X
        leftY = e.getY(); // MY CODE — update Y
        // no movement here applyMovement() - 137 // MY CODE — move stick
        repaint(); // MY CODE — redraw
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        leftX = e.getX(); // MY CODE — update X
        leftY = e.getY(); // MY CODE — update Y
        // no code here see
        repaint(); // MY CODE — redraw
    }

    @Override
    public void keyPressed(KeyEvent e) {switch (e.getKeyCode()) { // MY CODE — WASD movement
            case KeyEvent.VK_W: case KeyEvent.VK_UP:    rightY -= KEY_STEP; break;
            case KeyEvent.VK_S: case KeyEvent.VK_DOWN:  rightY += KEY_STEP; break;
            case KeyEvent.VK_A: case KeyEvent.VK_LEFT:  rightX -= KEY_STEP; break;
            case KeyEvent.VK_D: case KeyEvent.VK_RIGHT: rightX += KEY_STEP; break;
        }

       // no movement here applyMovement() - 138 // MY CODE — move stick
        repaint(); // MY CODE — redraw
    }

    @Override public void keyReleased(KeyEvent e) {} // MY CODE — unused
    @Override public void keyTyped(KeyEvent e) {} // MY CODE — unused

    public void applyMovement() {
        leftStick.setPosition(leftX, leftY);
        rightStick.setPosition(rightX, rightY); // MY CODE — move stick
    }
}