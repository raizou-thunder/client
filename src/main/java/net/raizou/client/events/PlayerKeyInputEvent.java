package net.raizou.client.events;

import net.raizou.client.RaizouClient;
import net.raizou.client.modules.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class PlayerKeyInputEvent {
    @SubscribeEvent
    public void toggle(InputEvent event)
    {
        if(Minecraft.getMinecraft().player == null || Minecraft.getMinecraft().world == null) return;
        if(Keyboard.isCreated() && Keyboard.getEventKeyState())
        {
            int key = Keyboard.getEventKey();
            for(Module module : RaizouClient.module.modules)
            {
                if(module.keybind == key)
                {
                    module.toggle();
                    return;
                }
                else if(Keyboard.KEY_UP == key)
                {
                    RaizouClient.hudGui.up();
                }
                else if(Keyboard.KEY_DOWN == key)
                {
                    RaizouClient.hudGui.down();
                }
                else if(Keyboard.KEY_RIGHT == key)
                {
                    RaizouClient.hudGui.toggle();
                }
            }
        }
    }
}
