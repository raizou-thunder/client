package net.raizou.client.mixin.mixins;

import net.minecraft.client.gui.GuiIngame;
import net.minecraftforge.common.MinecraftForge;
import net.raizou.client.client.RaizouClient;
import net.raizou.client.client.events.EventType;
import net.raizou.client.client.events.player.EventRender2D;
import net.raizou.client.client.module.modules.Module;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngame.class)
public class MixinGuiIngame {
    @Inject(method = "renderGameOverlay", at = @At("HEAD"))
    public void injectRenderGameOverlay(CallbackInfo ci) {
        EventRender2D event = new EventRender2D();
        event.setType(EventType.PRE);
        RaizouClient.instance.playerTickEvent.onEvent(event);
    }
}
