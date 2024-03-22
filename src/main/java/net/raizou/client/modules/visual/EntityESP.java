package net.raizou.client.modules.visual;

import net.minecraft.entity.Entity;
import net.raizou.client.modules.Category;
import net.raizou.client.modules.Module;

public class EntityESP extends Module {
    public EntityESP() {
        super("EntityESP", Category.COMBAT, 0);
    }

    @Override
    public void onDisable() {
        for(Entity entity : minecraft.world.loadedEntityList) {
            entity.setGlowing(false);
        }
    }

    @Override
    public void onUpdate() {
        for(Entity entity : minecraft.world.loadedEntityList) {
            entity.setGlowing(true);
        }
    }
}
