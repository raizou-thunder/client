package net.raizou.client.ui;

import net.raizou.client.RaizouClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.raizou.client.modules.Module;

import java.awt.Color;

public class HudGui extends GuiScreen {
    Minecraft minecraft = Minecraft.getMinecraft();
    public int selectModuleId = 1;

    @SubscribeEvent
    public void hudGui(RenderGameOverlayEvent event)
    {
        FontRenderer renderer = minecraft.fontRenderer;

        if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT)
        {
            int y = renderer.FONT_HEIGHT + 1;
            for(Module module : RaizouClient.module.modules)
            {
                if(module.name.equals(RaizouClient.module.modules.get(selectModuleId).name))
                {
                    renderer.drawString("> " + module.name, 2, y, Color.WHITE.getRGB(), true);
                }
                else
                {
                    renderer.drawString(module.name, 2, y, Color.WHITE.getRGB(), true);
                }
                y += renderer.FONT_HEIGHT;
            }
        }
    }

    public void up()
    {
        if(selectModuleId == 0)
        {
            selectModuleId = (RaizouClient.module.modules.size());
        }
        else {
            selectModuleId -= 1;
        }
    }

    public void down()
    {
        if(selectModuleId == (RaizouClient.module.modules.size() - 1))
        {
            selectModuleId = 0;
        }
        else {
            selectModuleId += 1;
        }
    }

    public void toggle()
    {
        RaizouClient.module.modules.get(selectModuleId).toggle();
    }
}
