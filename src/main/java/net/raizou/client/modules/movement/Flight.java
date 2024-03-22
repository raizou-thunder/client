package net.raizou.client.modules.movement;

import net.raizou.client.modules.Category;
import net.raizou.client.modules.Module;

public class Flight extends Module {
    public Flight() {
        super("Flight", Category.NONE, 0);
    }

    @Override
    public void onUpdate() {
        if (minecraft.gameSettings.keyBindJump.isKeyDown()) {
            minecraft.player.motionY = 1;
        }
        if (minecraft.gameSettings.keyBindSneak.isKeyDown()) {
            minecraft.player.motionY = -1;
        }
    }
}
