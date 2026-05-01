package badDrum.ui;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
/* This class loads the drum image and shows it on the screen. Also stores the center point of the drum kit for hit checks. */

public class Drum {

    private int cx; // MY CODE — center X of drum 
    private int cy; // MY CODE — center Y of drum

    private BufferedImage drumImage;  // MY CODE 


    public Drum(int centerX, int centerY) {
        this.cx = centerX; // MY CODE
        this.cy = centerY; // MY CODE

        try {
            // MY CODE — load image of drum with background 
            drumImage = ImageIO.read(Drum.class.getResource("Drum_backG.jpg"));

        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        if (drumImage == null) return; // AI CODE — safety

        // AI CODE — smooth rendering
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // MY CODE — center the image
        int x = cx - drumImage.getWidth() / 2;
        int y = cy - drumImage.getHeight() / 2;

        // MY CODE — draw image of drum 
        g2.drawImage(drumImage, x, y, null);
    }

}