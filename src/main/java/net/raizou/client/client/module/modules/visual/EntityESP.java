package net.raizou.client.client.module.modules.visual;

import net.minecraft.entity.Entity;
import net.raizou.client.client.module.modules.Category;
import net.raizou.client.client.module.modules.Module;

import static net.raizou.client.client.RaizouClient.mc;

public class EntityESP extends Module {
    public EntityESP() {
        super("EntityESP", Category.COMBAT, 0);
    }

    @Override
    public void onDisable() {
        for(Entity entity : mc.world.loadedEntityList) {
            entity.setGlowing(false);
        }
    }

    @Override
    public void onUpdate() {
        for(Entity entity : mc.world.loadedEntityList) {
            entity.setGlowing(true);
        }
    }
}
