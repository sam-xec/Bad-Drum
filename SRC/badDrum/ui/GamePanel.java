package badDrum.ui;

import badDrum.logic.MovementLogic;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

<<<<<<< HEAD
    private Drum drum;    // MY CODE — drum set object
    private Stick sticks; // MY CODE — drumsticks object
    private JButton instructionButton; // MY CODE — button for instructions

    public GamePanel() {

        // MY CODE — warm studio background
        setBackground(new Color(240, 230, 210)); 

        // MY CODE — manual layout for custom button placement
        setLayout(null);

        // MY CODE — create "Instructions" button
        instructionButton = new JButton("Instructions");

        // MY CODE — button styling (same as GameWindow)
        instructionButton.setFont(new Font("Georgia", Font.BOLD, 24));
        instructionButton.setBackground(new Color(180, 140, 90)); 
        instructionButton.setForeground(Color.WHITE);
        instructionButton.setFocusPainted(false);
        instructionButton.setBorderPainted(false);//AI code 

        // MY CODE — button position
        instructionButton.setBounds(30, 30, 220, 60);

        add(instructionButton);

        //AI  code — open instruction window when clicked
        instructionButton.addActionListener(e -> new InstructionFrame());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // AI code — enable smooth drawing
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        // MY CODE 
        int cx = getWidth() / 2;
        int cy = getHeight() / 2 - 40;

        // MY CODE — create drum and stick objects
        drum = new Drum(cx, cy);
        sticks = new Stick(cx, cy);

        // AI code — draw drums first (background)
        drum.draw(g2);

        // AI  code — draw sticks on top
        sticks.draw(g2);
=======
    public GamePanel() {
        setLayout(new BorderLayout()); // MY CODE
        setBackground(Color.WHITE);   // MY CODE

        MovementLogic game = new MovementLogic(); // MY CODE
        add(game, BorderLayout.CENTER);            // MY CODE

        // Фокус нужен сразу, чтобы WASD/стрелки работали
        SwingUtilities.invokeLater(game::requestFocusInWindow); // MY CODE
    }

    // MY CODE — публичный метод для запроса фокуса извне (после показа окна)
    public void requestFocusForGame() {
        for (Component c : getComponents()) {
            if (c instanceof MovementLogic) {
                c.requestFocusInWindow();
                return;
            }
        }
>>>>>>> denys_code_extracted
    }
}
