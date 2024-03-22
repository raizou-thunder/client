package net.raizou.client.events;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.raizou.client.RaizouClient;
import net.raizou.client.modules.Module;
import org.lwjgl.input.Keyboard;

public class PlayerKeyInputEvent {
    @SubscribeEvent
    public void toggle(InputEvent event) {
        if (Minecraft.getMinecraft().player == null || Minecraft.getMinecraft().world == null) return;
        if (Keyboard.isCreated() && Keyboard.getEventKeyState()) {
            int key = Keyboard.getEventKey();
            //HudGui
            if (Keyboard.KEY_UP == key) {
                RaizouClient.hudGui.up();
            } else if (Keyboard.KEY_DOWN == key) {
                RaizouClient.hudGui.down();
            } else if (Keyboard.KEY_RIGHT == key) {
                RaizouClient.hudGui.toggle();
            }

            //Module Keybind
            for (Module module : RaizouClient.module.modules) {
                if (module.keybind == key) {
                    module.toggle();
                    return;
                }
            }
        }
    }
}
