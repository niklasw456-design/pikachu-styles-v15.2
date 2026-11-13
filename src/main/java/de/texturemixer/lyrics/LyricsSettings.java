package de.texturemixer.lyrics;

/** Einstellungen für die Lyrics-Anzeige (werden in der Config gespeichert). */
public final class LyricsSettings {
    public static final String MODE_SKY = "sky";
    public static final String MODE_AIR = "air";

    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 30;
    /** Farben (RGB), Auswahl per Index. */
    public static final int[] COLORS = {
            0xFFFFFF, 0xFFD83A, 0x55FF55, 0x55FFFF, 0x6C8CFF, 0xFF7ACB, 0xFF5555, 0xFFAA33
    };

    public boolean enabled = false;
    /** Client-ID der eigenen Spotify-App (developer.spotify.com). */
    public String clientId = "";
    /** Langlebiges Token aus der Anmeldung. Leer = nicht verbunden. */
    public String refreshToken = "";
    /** "sky" = am Himmel, "air" = in der Luft vor dem Spieler. */
    public String mode = MODE_AIR;
    /** Größe in Zehnteln (10 = 1,0x). */
    public int size = 10;
    public boolean bold = false;
    public boolean italic = false;
    public int color = 0;

    public void normalize() {
        if (clientId == null) clientId = "";
        if (refreshToken == null) refreshToken = "";
        if (!MODE_SKY.equals(mode) && !MODE_AIR.equals(mode)) mode = MODE_AIR;
        size = Math.max(MIN_SIZE, Math.min(MAX_SIZE, size));
        if (color < 0 || color >= COLORS.length) color = 0;
    }

    public int rgb() {
        return COLORS[Math.max(0, Math.min(COLORS.length - 1, color))];
    }

    public boolean sky() {
        return MODE_SKY.equals(mode);
    }
}
