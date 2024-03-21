package net.raizou.client.ui;

import net.raizou.client.RaizouClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.Color;
import java.util.Random;

public class Hud extends GuiScreen {
    Minecraft minecraft = Minecraft.getMinecraft();

    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    Random random = new Random();

    @SubscribeEvent
    public void hud(RenderGameOverlayEvent event)
    {
        FontRenderer renderer = minecraft.fontRenderer;

        if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT)
        {
            StringBuilder randomString = new StringBuilder();
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
            String hudTitle = randomString.toString() + " " + RaizouClient.NAME + " " + RaizouClient.VERSION + " " + randomString.toString() + " | " + minecraft.player.getName() + RaizouClient.hudGui.selectModuleId;
            renderer.drawString(hudTitle, 1, 1, Color.WHITE.getRGB(), true);
        }
    }
}
