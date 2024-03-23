package net.raizou.client.client.module.modules.none;

import net.raizou.client.client.module.modules.Category;
import net.raizou.client.client.module.modules.Module;
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
        if (mc.player.isDead) {
            mc.player.respawnPlayer();
        }
    }
}
