package net.raizou.client.client.module.modules.player;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGameOver;
import net.raizou.client.client.events.ClientEvent;
import net.raizou.client.client.events.player.EventRender2D;
import net.raizou.client.client.events.player.EventUpdate;
import net.raizou.client.client.module.modules.Category;
import net.raizou.client.client.module.modules.Module;
import net.raizou.client.client.utils.minecraft.ChatUtils;
import org.lwjgl.input.Keyboard;

import static net.raizou.client.client.RaizouClient.mc;

public class AutoRespawn extends Module {
    public AutoRespawn() {
        super("AutoRespawn", Category.PLAYER, Keyboard.KEY_NONE);
    }

    @Override
    public void onEvent(ClientEvent e) {
        if (e instanceof EventUpdate) {
            if (mc.currentScreen instanceof GuiGameOver) {
                mc.player.respawnPlayer();
            }
            Gui.drawRect(0, 0, 150, 150, 0x00ff00);
        }
    }
}
