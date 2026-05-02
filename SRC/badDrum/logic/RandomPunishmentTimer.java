package badDrum.logic;

import badDrum.sound.*;
import badDrum.equationPuzzle.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

/**
 * RandomPunishmentTimer periodically checks a random condition
 * and triggers a punishment (high-pitch sound + puzzle) once.
 * This class does NOT know how punishment works.
 * It only decides WHEN to trigger it.
 */
public class RandomPunishmentTimer implements ActionListener {

    // Swing timer used to periodically check randomness
    private final Timer timer;

    // Random number generator
    private final Random random = new Random();

    // Reference to SoundManager (or coordinator)
    private final SoundManager soundManager;

    // Reference to Puzzle starter (can be your puzzle class)
    private final PuzzleState puzzle;

    // How often to check (milliseconds)
    private static final int CHECK_INTERVAL_MS = 1000;

    // Probability threshold (0.0 – 1.0)
    private static final double TRIGGER_CHANCE = 0.1; // 10% chance per check

    /**
     * Creates the random punishment timer.
     *
     * @param soundManager     used to start high-pitch sound
     * @param puzzle used to start the puzzle
     */
    public RandomPunishmentTimer(SoundManager soundManager,
                                 PuzzleState puzzle) {

        this.soundManager = soundManager;
        this.puzzle = puzzle;

        // Create Swing Timer that fires every CHECK_INTERVAL_MS
        this.timer = new Timer(CHECK_INTERVAL_MS, this);
    }

    /**
     * Starts the random punishment checks.
     */
    public void start() {
        timer.start();
    }

    /**
     * Stops the random punishment checks.
     */
    public void stop() {
        timer.stop();
    }

    /**
     * Called automatically by Swing Timer.
     * This method checks whether punishment should start.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Generate random number between 0.0 and 1.0
        double roll = random.nextDouble();

        // If roll is below threshold, trigger punishment
        if (roll < TRIGGER_CHANCE) {
            // Start high-pitch sound
            try {
                soundManager.startHighPitch();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                throw new RuntimeException(ex);
            }
            // Start puzzle (this may block until solved)
            try {
                puzzle.startPuzzle();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            // Stop sound after puzzle is solved
            soundManager.stopHighPitch();
        }
    }
}
