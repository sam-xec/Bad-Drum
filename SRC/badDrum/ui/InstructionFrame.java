package badDrum.ui;

import javax.swing.*;
import java.awt.*;

public class InstructionFrame extends JFrame {

    public InstructionFrame() {

        super("Instructions"); // MY CODE — window title

        setSize(900, 700); // MY CODE — window size
        setLocationRelativeTo(null); // AI CODE — center window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // AI CODE — close only this window

        JPanel panel = new JPanel(); // MY CODE — main panel
        panel.setLayout(null); // MY CODE — manual layout
        panel.setBackground(new Color(240, 230, 210)); // MY CODE — warm beige background
        setContentPane(panel); // MY CODE — attach panel

        JLabel title = new JLabel("HOW TO USE THE DRUM SET"); // MY CODE — title text
        title.setFont(new Font("Georgia", Font.BOLD, 32)); // MY CODE — title font
        title.setForeground(new Color(80, 50, 20)); // MY CODE — warm brown color
        title.setBounds(180, 40, 700, 50); // MY CODE — position
        panel.add(title); // MY CODE — add to panel

        JTextArea text = new JTextArea(); // MY CODE — instruction text box
        text.setText(
                "• Move left stick with the mouse.\n" +
                "• Move right stick with W A S D.\n" +
                "• Hit drums to play sounds.\n" +
                "• Use the INSTRUCTIONS button to open this window.\n" +
                "• Press BACK to return to the game.\n"
        ); // MY CODE — instruction text
        text.setEditable(false); // MY CODE — read-only
        text.setFont(new Font("Georgia", Font.PLAIN, 24)); // MY CODE — text font
        text.setForeground(new Color(60, 40, 20)); // MY CODE — text color
        text.setBackground(new Color(240, 230, 210)); // MY CODE — match panel color
        text.setBounds(80, 120, 750, 350); // MY CODE — position
        panel.add(text); // MY CODE — add to panel

        JButton backButton = new JButton("BACK"); // MY CODE — brown back button

        backButton.setFont(new Font("Georgia", Font.BOLD, 26)); // MY CODE — font
        backButton.setBackground(new Color(180, 140, 90)); // MY CODE — brown color
        backButton.setForeground(Color.WHITE); // MY CODE — white text
        backButton.setFocusPainted(false); // AI CODE — remove blue outline
        backButton.setBorderPainted(false); // AI CODE — remove border
        backButton.setOpaque(true); // AI CODE — allow background color

        backButton.setBounds(80, 520, 200, 70); // MY CODE — position
        panel.add(backButton); // MY CODE — add to panel

        backButton.addActionListener(e -> dispose()); // AI CODE — close window

        setVisible(true); // MY CODE — show window
    }
}