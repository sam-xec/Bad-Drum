package badDrum.logic;

import badDrum.equationPuzzle.PuzzleState;

import javax.swing.*;


/**
 * StateManager is responsible for the game loop
 * It constantly updates and decides with of two modes should proceed
 * Game mode or Puzzle mode
 * That creates a "freeze effect" without freezing ui threads
 * Thus when the Puzzle starts, you cannot do anything else
 * unless you solve a puzzle **/
//=====================AI==============================

/**
 * StateManager is a central gatekeeper for game logic updates.
 * It decides whether gameplay logic should run or be frozen.
 *
 * IMPORTANT:
 * - It does NOT stop threads.
 * - It does NOT know about UI, Swing, sound, or puzzles.
 * - It only exposes state queries used by the game loop.
 */
public class StateManager {

    /**
     * Possible high-level states of the game.
     * GAMEPLAY  -> logic updates allowed
     * PUZZLE    -> logic updates frozen
     */
    public enum State {
        GAMEPLAY,
        PUZZLE
    }

    /**
     * Holds the current active state.
     * Default is GAMEPLAY when the game starts.
     */
    private State currentState;

    /**
     * Constructor initializes the game in GAMEPLAY state.
     */
    public StateManager() {
        this.currentState = State.GAMEPLAY;
    }

    /**
     * Switches the current game state.
     * This is the ONLY way the state should be changed.
     *
     * @param newState the state to switch to
     */
    public void setState(State newState) {
        this.currentState = newState;
    }

    /**
     * Returns the current game state.
     *
     * @return current State
     */
    public State getState() {
        return currentState;
    }

    /**
     * Convenience method used by the game loop.
     *
     * @return true if gameplay logic should be updated
     */
    public boolean isGameplay() {
        return currentState == State.GAMEPLAY;
    }

    /**
     * Convenience method used by puzzles or controllers.
     *
     * @return true if the game is currently frozen by a puzzle
     */
    public boolean isPuzzle() {
        return currentState == State.PUZZLE;
    }
}