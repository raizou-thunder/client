package net.raizou.client.client.module.modules.none;

import ca.weblite.objc.Client;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.raizou.client.client.events.ClientEvent;
import net.raizou.client.client.events.player.EventRender2D;
import net.raizou.client.client.module.modules.Category;
import net.raizou.client.client.module.modules.Module;
import net.raizou.client.client.utils.minecraft.ChatUtils;
import net.raizou.client.client.utils.minecraft.RenderUtils;
import org.lwjgl.input.Keyboard;

import static net.raizou.client.client.RaizouClient.mc;

public class TestModule extends Module {
    private float oldFov;

    public TestModule() {
        super("TestModule", Category.NONE, Keyboard.KEY_O);
    }

    @Override
    public void onUpdate() {
        //minecraft.player.sendMessage(new TextComponentString(String.valueOf(minecraft.player.isDead)));
        //AutoRespawnとして実装済み
        if (mc.currentScreen instanceof GuiGameOver) {
            mc.player.respawnPlayer();
        }
    }
}
