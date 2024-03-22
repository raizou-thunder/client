package net.raizou.client.modules.none;

import net.minecraft.util.text.TextComponentString;
import net.raizou.client.modules.Category;
import net.raizou.client.modules.Module;
import org.lwjgl.input.Keyboard;

public class TestModule extends Module {
    private float oldFov;

    public TestModule() {
        super("TestModule", Category.NONE, Keyboard.KEY_O);
    }

    @Override
    public void onUpdate() {
        //minecraft.player.sendMessage(new TextComponentString(String.valueOf(minecraft.player.isDead)));
        if (minecraft.player.isDead) {
            minecraft.player.respawnPlayer();
        }
    }
}
