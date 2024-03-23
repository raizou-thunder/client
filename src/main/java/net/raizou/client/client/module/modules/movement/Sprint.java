package net.raizou.client.client.module.modules.movement;

import net.raizou.client.client.module.modules.Category;
import net.raizou.client.client.module.modules.Module;

import static net.raizou.client.client.RaizouClient.mc;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint", Category.MOVEMENT, 0);
    }

    @Override
    public void onUpdate() {
        if (mc.player.moveForward > 0) {
            mc.player.setSprinting(true);
        }
    }
}
