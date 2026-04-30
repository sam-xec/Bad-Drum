package badDrum.ui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private Drum drum;   // MY CODE 
    private Stick sticks; // MY CODE 

    public GamePanel() {
        setBackground(Color.WHITE); // MY CODE 
        setPreferredSize(new Dimension(1920, 1080)); // MY CODE 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //AI code
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 26));
        g2.drawString("HOW TO USE DRUMS:", 20, 40);

        // MY CODE 
        int cx = getWidth() / 2;
        int cy = getHeight() / 2 - 40;

        // MY CODE
        drum = new Drum(cx, cy);
        sticks = new Stick(cx, cy);

        //AI code
        drum.draw(g2);
        sticks.draw(g2);
    }
}