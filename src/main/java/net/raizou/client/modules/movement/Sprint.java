package net.raizou.client.modules.movement;

import net.raizou.client.modules.Category;
import net.raizou.client.modules.Module;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint", Category.MOVEMENT, 0);
    }

    @Override
    public void onUpdate() {
        if (minecraft.player.moveForward > 0) {
            minecraft.player.setSprinting(true);
        }
    }
}
