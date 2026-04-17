package badDrum.ui;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private Stick leftStick;   // MY CODE
    private Stick rightStick;  // MY CODE

    public GamePanel() {

        setBackground(new Color(26, 26, 26)); //AI

        // MY CODE
        leftStick = new Stick(300, 400, 120, Color.WHITE);
        rightStick = new Stick(450, 400, 120, Color.WHITE);

        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // MY CODE
        leftStick.draw(g);
        rightStick.draw(g);
    }
}