package net.raizou.client.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.raizou.client.RaizouClient;
import net.raizou.client.modules.Module;

import java.awt.Color;
import java.util.Collections;
import java.util.Comparator;

public class ArrayList extends GuiScreen {
    Minecraft minecraft = Minecraft.getMinecraft();

    @SubscribeEvent
    public void arrayList(RenderGameOverlayEvent event)
    {
        ScaledResolution resolution = new ScaledResolution(minecraft);
        FontRenderer renderer = minecraft.fontRenderer;

        if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT)
        {
            RaizouClient.module.modules.sort(Comparator.comparingInt(Module::getNameLength).thenComparing(Module::getName));
            Collections.reverse(RaizouClient.module.modules);

            int y = 1;
            for(Module module : RaizouClient.module.modules)
            {
                if(module.istoggled)
                {
                    renderer.drawString(module.name, resolution.getScaledWidth() - renderer.getStringWidth(module.name), y, Color.WHITE.getRGB(), true);
                    y += renderer.FONT_HEIGHT + 1;
                }
            }
        }
    }
}
