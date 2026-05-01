package badDrum.logic;

public class CollisionDetection {

    //MY CODE
    public enum DrumZone {
        NONE,
        SNARE,
        BASS_DRUM,
        RACK_TOM,
        RACK_TOM2,
        RACK_TOM3,
        FLOOR_TOM,
        CRASH_CYMBAL,
        RIDE_CYMBAL,
    }

    //MY CODE
    private static class Zone {
        final DrumZone type;
        final int offsetX;
        final int offsetY;
        final int rx;
        final int ry;

        Zone(DrumZone type, int offsetX, int offsetY, int rx, int ry) {
            this.type    = type;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            this.rx      = rx;
            this.ry      = ry;
        }
    }

    //MY CODE + AI
    private static final Zone[] ZONES = {
        new Zone(DrumZone.CRASH_CYMBAL, -235, -189,  61,  50),
        new Zone(DrumZone.RIDE_CYMBAL,   176, -200,  72,  49),
        new Zone(DrumZone.RACK_TOM,     -50,  -58,  67,  28),
        new Zone(DrumZone.RACK_TOM2,    -115, -139,  55,  25),
        new Zone(DrumZone.RACK_TOM3,      9, -139,  53,  25),
        new Zone(DrumZone.SNARE,        -224,  -88,  63,  28),
        new Zone(DrumZone.BASS_DRUM,    -222,   32, 112,  44),
        new Zone(DrumZone.FLOOR_TOM,     300,  -15,  80,  34),
    };

    //MY CODE
    private double scaleX = 1.0;
    private double scaleY = 1.0;

    public void setScale(double scaleX, double scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    //AI CODE
    private int     leftPrevTipY  = Integer.MIN_VALUE;
    private boolean leftHasHit    = false;

    private int     rightPrevTipY = Integer.MIN_VALUE;
    private boolean rightHasHit   = false;

    public DrumZone checkLeftStrike(int tipX, int tipY, int drumCX, int drumCY) {
        DrumZone result = checkStrike(tipX, tipY, drumCX, drumCY, leftPrevTipY, leftHasHit);
        
        if (tipY < leftPrevTipY) {
            leftHasHit = false;
        }
        if (result != DrumZone.NONE) {
            leftHasHit = true;
        }
        leftPrevTipY = tipY;
        return result;
    }

    public DrumZone checkRightStrike(int tipX, int tipY, int drumCX, int drumCY) {
        DrumZone result = checkStrike(tipX, tipY, drumCX, drumCY, rightPrevTipY, rightHasHit);
        if (tipY < rightPrevTipY) {
            rightHasHit = false;
        }
        if (result != DrumZone.NONE) {
            rightHasHit = true;
        }
        rightPrevTipY = tipY;
        return result;
    }

    //AI CODE
    private DrumZone checkStrike(int tipX, int tipY, int drumCX, int drumCY, 
                                 int prevTipY, boolean hasHit) {

        boolean movingDown = (prevTipY != Integer.MIN_VALUE) && (tipY > prevTipY);

        if (!movingDown || hasHit) {
            return DrumZone.NONE;
        }

        return detectZone(tipX, tipY, drumCX, drumCY);
    }

    //AI CODE
    private DrumZone detectZone(int tipX, int tipY, int drumCX, int drumCY) {
        int dx = tipX - drumCX;
        int dy = tipY - drumCY;

        for (Zone zone : ZONES) {
            double zoneCX = zone.offsetX * scaleX;
            double zoneCY = zone.offsetY * scaleY;
            double rxScaled = zone.rx * scaleX;
            double ryScaled = zone.ry * scaleY;

            double nx = (dx - zoneCX) / rxScaled;
            double ny = (dy - zoneCY) / ryScaled;

            if (nx * nx + ny * ny <= 1.0) {
                return zone.type;
            }
        }
        return DrumZone.NONE;
    }

    //MY CODE
    public static String soundFileFor(DrumZone zone) {
        switch (zone) {
            case SNARE:        return "Snare-Drum.wav";
            case BASS_DRUM:    return "Kick-Drum.wav";
            case RACK_TOM:     return "Rack-tom.wav";
            case RACK_TOM2:    return "Rack-tom.wav";
            case RACK_TOM3:    return "Rack-tom.wav";
            case FLOOR_TOM:    return "low-tom.wav";
            case CRASH_CYMBAL: return "Cymabal-drum(1).wav";
            case RIDE_CYMBAL:  return "ride-cymbal.wav";
            default:           return null;
        }
    }
}