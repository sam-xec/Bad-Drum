package badDrum;

import badDrum.equationPuzzle.PuzzleState;
import badDrum.logic.RandomPunishmentTimer;
import badDrum.sound.SoundManager;
import badDrum.ui.GameWindow;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
       SoundManager soundManager = new SoundManager();
       PuzzleState puzzle = new PuzzleState();
       RandomPunishmentTimer punishmentTimer =
               new RandomPunishmentTimer(soundManager, puzzle);

       new GameWindow(); // MY CODE
       punishmentTimer.start();
   }
}
