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
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // AI CODE
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // MY CODE
        setLocationRelativeTo(null); // MY CODE

        // MY CODE — main menu panel
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
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        startButton.setBounds(650, 350, 300, 90);
        mainPanel.add(startButton);

        // MY CODE — End button
        endButton = new JButton("END");
        endButton.setBackground(new Color(180, 140, 90));
        endButton.setForeground(Color.WHITE);
        endButton.setFont(new Font("Georgia", Font.BOLD, 36));
        endButton.setFocusPainted(false);
        endButton.setBorderPainted(false);
        endButton.setBounds(650, 480, 300, 90);
        mainPanel.add(endButton);

        // AI CODE — open game panel ONCE
        startButton.addActionListener(e -> {

            JFrame gameFrame = new JFrame("Drum Game");
            gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // AI CODE — add GamePanel only once
            GamePanel gamePanel = new GamePanel();
            gameFrame.add(gamePanel);

            gameFrame.setVisible(true);

            // MY CODE — close menu window
            dispose();
        });

        // MY CODE — exit program
        endButton.addActionListener(e -> System.exit(0));

        setVisible(true); // MY CODE
    }

    public static void main(String[] args) {
        new GameWindow(); // MY CODE
    }
}