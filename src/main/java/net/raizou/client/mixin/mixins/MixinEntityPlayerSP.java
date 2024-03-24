package net.raizou.client.mixin.mixins;

import net.minecraft.client.entity.EntityPlayerSP;
import net.raizou.client.client.RaizouClient;
import net.raizou.client.client.events.EventType;
import net.raizou.client.client.events.player.EventUpdate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public class MixinEntityPlayerSP {
    @Inject(method = "onUpdate", at = @At("HEAD"))
    public void injectOnUpdate(CallbackInfo ci) {
        EventUpdate event = new EventUpdate();
        event.setType(EventType.PRE);
        RaizouClient.instance.playerTickEvent.onEvent(event);
    }
}
