package net.raizou.client.client.events;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.raizou.client.client.RaizouClient;
import net.raizou.client.client.module.modules.Module;
import org.lwjgl.input.Keyboard;

public class PlayerKeyInputEvent {
    @SubscribeEvent
    public void toggle(InputEvent.KeyInputEvent event) {
        int key = Keyboard.getEventKey();

        if (Minecraft.getMinecraft().player == null || Minecraft.getMinecraft().world == null || key == Keyboard.KEY_NONE) return;
        if (!Keyboard.getEventKeyState()) {
            //HudGui
            if (Keyboard.KEY_UP == key) {
                RaizouClient.hudGui.up();
            } else if (Keyboard.KEY_DOWN == key) {
                RaizouClient.hudGui.down();
            } else if (Keyboard.KEY_RIGHT == key) {
                RaizouClient.hudGui.toggle();
            }

            for (Module module : RaizouClient.moduleManager.modules) {
                if (module.keybind == key) {
                    module.toggle();
                    return;
                }
            }
        }
    }
}
