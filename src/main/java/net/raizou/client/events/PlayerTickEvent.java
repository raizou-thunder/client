package net.raizou.client.events;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.raizou.client.RaizouClient;
import net.raizou.client.modules.Module;

public class PlayerTickEvent {
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.START) return;
        if (event.player != Minecraft.getMinecraft().player) return;
        for (Module module : RaizouClient.module.modules) {
            if (module.istoggled) {
                module.onUpdate();
            }
        }
    }
}
