package badDrum.ui;

import javax.swing.*;
import java.awt.*;

public class InstructionFrame extends JFrame {

    public InstructionFrame() {

        super("Instructions"); // MY CODE — window title

        // MY CODE — window size
        setSize(900, 700);

        // AI code  — center the window
        setLocationRelativeTo(null);

        // FIX: must be DISPOSE so windowClosed event fires in GamePanel
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // MY CODE — create main panel with warm studio background
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240, 230, 210)); // warm beige
        setContentPane(panel);

        // MY CODE — title label
        JLabel title = new JLabel("HOW TO USE THE DRUM SET");
        title.setFont(new Font("Georgia", Font.BOLD, 32));
        title.setForeground(new Color(80, 50, 20)); // warm brown
        title.setBounds(200, 40, 700, 50);
        panel.add(title);

        // MY CODE — instruction text
        JTextArea text = new JTextArea();
        text.setText(
                "• Click on the drums to play sounds.\n" +
                "• Cymbals are located at the top of the drum set.\n" +
                "• Sticks show the direction of the hit.\n" +
                "• Each drum has its own angle and height.\n" +
                "• Use the interface buttons to navigate.\n" +
                "• Press BACK to return to the game window.\n"
        );
        text.setEditable(false);
        text.setFont(new Font("Georgia", Font.PLAIN, 24));
        text.setForeground(new Color(60, 40, 20));
        text.setBackground(new Color(240, 230, 210)); 
        text.setBounds(80, 120, 750, 400);
        panel.add(text);

        // MY CODE — Back button
        JButton backButton = new JButton("BACK");
        backButton.setFont(new Font("Georgia", Font.BOLD, 28));
        backButton.setBackground(new Color(180, 140, 90)); // warm brown
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setBounds(80, 550, 200, 70);
        backButton.setBorderPainted(false);//AI code 
        panel.add(backButton);

        //AI code  — close this window when Back is pressed
        backButton.addActionListener(e -> dispose());

        // MY CODE — show window
        setVisible(true);
    }
}