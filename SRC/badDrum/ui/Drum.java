package badDrum.ui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Drum {

    private int cx; // MY CODE — center X of drumset
    private int cy; // MY CODE — center Y of drumset

    private BufferedImage drumImage;  // MY CODE — visible drumset

    private int drawnWidth;
    private int drawnHeight;

    public Drum(int centerX, int centerY) {
        this.cx = centerX; // MY CODE
        this.cy = centerY; // MY CODE

        try {
            // MY CODE — load visible drumset
            drumImage = ImageIO.read(Drum.class.getResource("Drum_backG.jpg"));

        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2, int panelWidth, int panelHeight) {

        if (drumImage == null) return; // AI CODE — safety

        // AI CODE — smooth rendering
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        int imgW = drumImage.getWidth();
        int imgH = drumImage.getHeight();

        double scaleX = (double) panelWidth  / imgW;
        double scaleY = (double) panelHeight / imgH;
        double scale  = Math.min(scaleX, scaleY); // fit inside panel

        drawnWidth  = (int)(imgW * scale);
        drawnHeight = (int)(imgH * scale);

        // MY CODE — center the image
        int x = cx - drawnWidth  / 2;
        int y = cy - drawnHeight / 2;

        // MY CODE — draw visible drumset (now scaled)
        g2.drawImage(drumImage, x, y, drawnWidth, drawnHeight, null);
    }

    public void draw(Graphics2D g2) {
        if (drumImage == null) return;
        int x = cx - drumImage.getWidth()  / 2;
        int y = cy - drumImage.getHeight() / 2;
        drawnWidth  = drumImage.getWidth();
        drawnHeight = drumImage.getHeight();
        g2.drawImage(drumImage, x, y, null);
    }

    public double getScaleX() {
        if (drumImage == null || drumImage.getWidth() == 0) return 1.0;
        return (double) drawnWidth / drumImage.getWidth();
    }

    public double getScaleY() {
        if (drumImage == null || drumImage.getHeight() == 0) return 1.0;
        return (double) drawnHeight / drumImage.getHeight();
    }
}
