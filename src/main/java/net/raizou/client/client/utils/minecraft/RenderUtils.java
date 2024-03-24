package net.raizou.client.client.utils.minecraft;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

public class RenderUtils {
    public static net.minecraft.client.renderer.Tessellator tessellator = net.minecraft.client.renderer.Tessellator.getInstance();
    public static net.minecraft.client.renderer.BufferBuilder worldrenderer = tessellator.getBuffer();
    public static void enableGL2D() {
        GlStateManager.enableBlend();
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
    }

    public static void disableGL2D() {
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void startRender2D() {
        GL11.glEnable(2848);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glBegin(9);
    }

    public static void endRender2D() {
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glScaled(2.0D, 2.0D, 2.0D);
        GL11.glPopAttrib();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public static void drawRect(float left, float top, float right, float bottom, int color, float alpha) {
        enableGL2D();
        startRender2D();
        float[] glColorRgb = ColorUtils.glColor(color);
        GL11.glColor4d(glColorRgb[0], glColorRgb[1], glColorRgb[2], alpha);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION);
        worldrenderer.pos(left, bottom, 0.0D).endVertex();
        worldrenderer.pos(right, bottom, 0.0D).endVertex();
        worldrenderer.pos(right, top, 0.0D).endVertex();
        worldrenderer.pos(left, top, 0.0D).endVertex();
        tessellator.draw();
        endRender2D();
        disableGL2D();
    }

    public static void drawRoundedRect(float left, float top, float right, float bottom, int color, float alpha, float radius) {
        enableGL2D();
        GL11.glPushAttrib(0);
        GL11.glScaled(0.5D, 0.5D, 0.5D);
        left *= 2.0D;
        top *= 2.0D;
        right *= 2.0D;
        bottom *= 2.0D;
        GL11.glDisable(3553);
        float[] glColorRgb = ColorUtils.glColor(color);
        GL11.glColor4d(glColorRgb[0], glColorRgb[1], glColorRgb[2], alpha);
        startRender2D();
        for (int i = 0; i <= 90; i += 3) {
            GL11.glVertex2d(left + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, top + radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
        }
        for (int i = 90; i <= 180; i += 3) {
            GL11.glVertex2d(left + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, bottom - radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
        }
        for (int i = 0; i <= 90; i += 3) {
            GL11.glVertex2d(right - radius + Math.sin(i * Math.PI / 180.0D) * radius, bottom - radius + Math.cos(i * Math.PI / 180.0D) * radius);
        }
        for (int i = 90; i <= 180; i += 3) {
            GL11.glVertex2d(right - radius + Math.sin(i * Math.PI / 180.0D) * radius, top + radius + Math.cos(i * Math.PI / 180.0D) * radius);
        }

        endRender2D();
        disableGL2D();
    }
}
