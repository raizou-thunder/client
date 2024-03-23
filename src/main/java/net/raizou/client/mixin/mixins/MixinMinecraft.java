package net.raizou.client.mixin.mixins;

import net.minecraft.client.Minecraft;
import net.raizou.client.client.RaizouClient;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.raizou.client.client.RaizouClient.mc;

@Mixin(Minecraft.class)
public class MixinMinecraft {
}
