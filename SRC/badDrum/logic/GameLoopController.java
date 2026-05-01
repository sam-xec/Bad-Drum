package badDrum.logic;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import badDrum.ui.GamePanel;

/**
 * GameLoopController is responsible for driving the game loop.
 * It uses a Swing Timer to periodically:
 *  - update game logic (when allowed by StateManager)
 *  - repaint the UI
 *
 * IMPORTANT:
 * - It does NOT contain game logic itself.
 * - It does NOT know about puzzles or sound.
 * - It only coordinates existing components.
 */
public class GameLoopController implements ActionListener {

    /**
     * Swing Timer that triggers the game loop ticks.
     */
    private final Timer timer;

    /**
     * Central state manager controlling freeze / gameplay.
     */
    private final StateManager stateManager;

    /**
     * Reference to MovementLogic (already implemented by you).
     */
    private final MovementLogic movementLogic;

    /**
     * Reference to CollisionDetection (may be implemented later).
     */
    private final CollisionDetection collisionDetection;

    /**
     * Reference to the GamePanel for repainting.
     */
    private final GamePanel gamePanel;

    /**
     * Desired delay between updates in milliseconds.
     * 16 ms ≈ 60 updates per second.
     */
    private static final int FRAME_DELAY_MS = 16;

    /**
     * Constructs the game loop controller and wires all components together.
     *
     * @param stateManager        shared StateManager instance
     * @param movementLogic       movement logic instance
     * @param collisionDetection  collision detection instance
     * @param gamePanel           UI panel to repaint
     */
    public GameLoopController(StateManager stateManager,
                              MovementLogic movementLogic,
                              CollisionDetection collisionDetection,
                              GamePanel gamePanel) {

        // Store references to shared components
        this.stateManager = stateManager;
        this.movementLogic = movementLogic;
        this.collisionDetection = collisionDetection;
        this.gamePanel = gamePanel;

        // Create a Swing Timer that fires every FRAME_DELAY_MS milliseconds
        this.timer = new Timer(FRAME_DELAY_MS, this);
    }

    /**
     * Starts the game loop.
     * After this is called, actionPerformed() will be triggered periodically.
     */
    public void start() {
        timer.start();
    }

    /**
     * Stops the game loop.
     * Useful if you ever need to fully pause or shut down the game.
     */
    public void stop() {
        timer.stop();
    }

    /**
     * Called automatically by the Swing Timer on every tick.
     *
     * @param e the timer event (not used)
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Only update gameplay logic if the state allows it
        if (stateManager.isGameplay()) {

            // Update stick movement and other motion
            movementLogic.update();

            // Check collisions and trigger gameplay effects
            collisionDetection.update();
        }

        // Always repaint the UI (even during PUZZLE state)
        gamePanel.repaint();
    }
}