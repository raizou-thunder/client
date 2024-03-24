package net.raizou.client.client.events;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.raizou.client.client.RaizouClient;
import net.raizou.client.client.module.modules.Module;

public class PlayerTickEvent {
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.START) return;
        if (event.player != Minecraft.getMinecraft().player) return;
        for (Module module : RaizouClient.moduleManager.modules) {
            if (module.istoggled) {
                module.onUpdate();
            }
        }
    }

    public void onEvent(ClientEvent e) {
        if (Minecraft.getMinecraft().player == null)
            return;
        for (Module m : RaizouClient.moduleManager.modules) {
            if (m.istoggled)
                m.onEvent(e);
        }
    }
}
