package net.raizou.client.client.utils.minecraft;

public class ColorUtils {
    public static float[] glColor(int hex) {
        final float red = (float) (hex >> 16 & 255) / 255.0f;
        final float green = (float) (hex >> 8 & 255) / 255.0f;
        final float blue = (float) (hex & 255) / 255.0f;
        float[] glColorRgb = {red, green, blue};

        return glColorRgb;
    }
}
