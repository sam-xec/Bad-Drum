package badDrum.ui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Drum {

    private int cx; // MY CODE — center X of drumset
    private int cy; // MY CODE — center Y of drumset

    private BufferedImage drumImage;  // MY CODE — visible drumset
    private BufferedImage hitmap;     // AI CODE — hidden hitmap

    public Drum(int centerX, int centerY) {
        this.cx = centerX; // MY CODE
        this.cy = centerY; // MY CODE

        try {
            // MY CODE — load visible drumset
            drumImage = ImageIO.read(Drum.class.getResource("drumset.jpg"));

            // AI CODE — load hitmap (same size)
            hitmap = ImageIO.read(Drum.class.getResource("hitmap.jpg"));

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

    // AI CODE — detect hit using hitmap
    public String detectHit(int mx, int my) {

        int x = cx - drumImage.getWidth() / 2;
        int y = cy - drumImage.getHeight() / 2;

        int imgX = mx - x;
        int imgY = my - y;

        
        if (imgX < 0 || imgY < 0 ||
            imgX >= hitmap.getWidth() ||
            imgY >= hitmap.getHeight()) {
            return "";
        }

        int rgb = hitmap.getRGB(imgX, imgY);

        // AI CODE — match colors
        if (rgb == new Color(255, 0, 0).getRGB()) return "snare";
        if (rgb == new Color(0, 255, 0).getRGB()) return "tomLeft";
        if (rgb == new Color(0, 0, 255).getRGB()) return "tomRight";
        if (rgb == new Color(255, 255, 0).getRGB()) return "floorLeft";
        if (rgb == new Color(255, 0, 255).getRGB()) return "floorRight";
        if (rgb == new Color(0, 255, 255).getRGB()) return "kick";
        if (rgb == new Color(255, 165, 0).getRGB()) return "cymbalLeft";
        if (rgb == new Color(165, 42, 42).getRGB()) return "cymbalRight";

        return "";
    }
}