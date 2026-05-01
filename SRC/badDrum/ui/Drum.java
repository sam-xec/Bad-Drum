package badDrum.ui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Drum {

    private int cx; // MY CODE — center X of drumset
    private int cy; // MY CODE — center Y of drumset

    private BufferedImage drumImage;  // MY CODE — visible drumset


    public Drum(int centerX, int centerY) {
        this.cx = centerX; // MY CODE
        this.cy = centerY; // MY CODE

        try {
            // MY CODE — load visible drumset
            drumImage = ImageIO.read(Drum.class.getResource("Drum_model.jpg"));

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

        // MY CODE — draw visible drumset
        g2.drawImage(drumImage, x, y, null);
    }

}