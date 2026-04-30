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
        setExtendedState(JFrame.MAXIMIZED_BOTH); //AI code
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // MY CODE
        setLocationRelativeTo(null); // MY CODE

    
        mainPanel = new JPanel(); // MY CODE
        mainPanel.setBackground(Color.WHITE); // MY CODE
        mainPanel.setLayout(null); // MY CODE
        add(mainPanel); // MY CODE

        
        titleLabel = new JLabel("DRUM SIMULATOR"); // MY CODE
        titleLabel.setForeground(Color.BLACK); // MY CODE
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48)); // MY CODE
        titleLabel.setBounds(600, 150, 600, 80); //AI code
        mainPanel.add(titleLabel); // MY CODE

        
        startButton = new JButton("START"); // MY CODE
        startButton.setBackground(Color.LIGHT_GRAY); // MY CODE
        startButton.setFont(new Font("Arial", Font.BOLD, 32)); // MY CODE
        startButton.setBounds(650, 350, 300, 80); // MY CODE
        mainPanel.add(startButton); // MY CODE

        
        endButton = new JButton("END"); // MY CODE
        endButton.setBackground(Color.LIGHT_GRAY); // MY CODE
        endButton.setFont(new Font("Arial", Font.BOLD, 32)); // MY CODE
        endButton.setBounds(650, 480, 300, 80); // MY CODE
        mainPanel.add(endButton); // MY CODE

        
        startButton.addActionListener(e -> {

            //AI code
            JFrame gameFrame = new JFrame("Drum Game");
            gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); //AI code
            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // MY CODE

            //AI code
            gameFrame.add(new GamePanel());

            gameFrame.setVisible(true); // MY CODE

            dispose(); // MY CODE
        });

        
        endButton.addActionListener(e -> System.exit(0)); // MY CODE

        setVisible(true); // MY CODE
    }

    public static void main(String[] args) {
        new GameWindow(); // MY CODE
    }
}