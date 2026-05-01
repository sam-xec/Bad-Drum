package badDrum.ui;

import badDrum.logic.MovementLogic;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

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
    }
}
