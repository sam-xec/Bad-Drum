package badDrum.ui;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private JButton startButton;   // MY CODE
    private JButton endButton;     // MY CODE
    private JLabel titleLabel;     // MY CODE
    private JPanel mainPanel;      // MY CODE

    public GameWindow() {

        setTitle("Java Project: Drum Simulator"); // MY CODE
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // AI code
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // MY CODE
        setLocationRelativeTo(null); // MY CODE

        // MY CODE 
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(240, 230, 210)); 
        mainPanel.setLayout(null);
        add(mainPanel);

        // MY CODE — title label
        titleLabel = new JLabel("DRUM SIMULATOR");
        titleLabel.setForeground(new Color(80, 50, 20)); 
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 60)); 
        titleLabel.setBounds(550, 150, 800, 100); 
        mainPanel.add(titleLabel);

        // MY CODE — Start button
        startButton = new JButton("START");
        startButton.setBackground(new Color(180, 140, 90)); 
        startButton.setForeground(Color.WHITE); 
        startButton.setFont(new Font("Georgia", Font.BOLD, 36));
        startButton.setFocusPainted(false); //AI code 
        startButton.setBounds(650, 350, 300, 90);
        startButton.setBorderPainted(false);
        mainPanel.add(startButton);

        // MY CODE — End button
        endButton = new JButton("END");
        endButton.setBackground(new Color(180, 140, 90));
        endButton.setForeground(Color.WHITE);
        endButton.setFont(new Font("Georgia", Font.BOLD, 36));
        endButton.setFocusPainted(false);
        endButton.setBounds(650, 480, 300, 90);
        endButton.setBorderPainted(false);//AI code 
        mainPanel.add(endButton);
        
        // COMMENT AI — open the game panel in a new window
        startButton.addActionListener(e -> {

            JFrame gameFrame = new JFrame("Drum Game");
            gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

<<<<<<< HEAD
            gameFrame.add(new GamePanel()); //AI code  — load the game panel

            gameFrame.setVisible(true);
            dispose(); // close the menu window
=======
            //AI code
            GamePanel gamePanel = new GamePanel();
            gameFrame.add(gamePanel);

            gameFrame.pack();           // MY CODE
            gameFrame.setVisible(true); // MY CODE

            // MY CODE
            SwingUtilities.invokeLater(() -> gamePanel.requestFocusForGame());

            dispose(); // MY CODE
>>>>>>> denys_code_extracted
        });

        // MY CODE — exit program
        endButton.addActionListener(e -> System.exit(0));

        setVisible(true); // MY CODE
    }

    public static void main(String[] args) {
        new GameWindow(); // MY CODE
    }
}