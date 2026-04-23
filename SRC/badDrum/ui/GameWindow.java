package badDrum.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame {

    private JButton startButton;   // MY CODE:
    private JButton endButton;     // MY CODE
    private JLabel titleLabel;     // MY CODE
    private JPanel mainPanel;      // MY CODE

    public GameWindow() {

        // MY CODE: 
        setTitle("Java Project: Drum Simulator");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // MY CODE
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY); //  AI
        mainPanel.setLayout(null);
        add(mainPanel);

        // MY CODE
        titleLabel = new JLabel("DRUM SIMULATOR");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setBounds(250, 80, 400, 50);
        mainPanel.add(titleLabel);

        // MY CODE
        startButton = new JButton("START");
        startButton.setBounds(300, 200, 200, 60);
        mainPanel.add(startButton);

        // MY CODE
        endButton = new JButton("END");
        endButton.setBounds(300, 300, 200, 60);
        mainPanel.add(endButton);

        // AI
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame gameFrame = new JFrame("Drum Game");
                gameFrame.setSize(800, 600);
                gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameFrame.setLocationRelativeTo(null);

                gameFrame.add(new GamePanel()); 
                gameFrame.setVisible(true);

                dispose(); 
            }
        });

        // MY CODE
        endButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new GameWindow(); // MY CODE
    }
}
