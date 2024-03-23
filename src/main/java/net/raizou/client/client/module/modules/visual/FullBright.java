package net.raizou.client.client.module.modules.visual;

import net.minecraft.client.Minecraft;
import net.raizou.client.client.module.modules.Category;
import net.raizou.client.client.module.modules.Module;

public class FullBright extends Module {
    Minecraft minecraft = Minecraft.getMinecraft();

    private float oldGamma;

    public FullBright() {
        super("FullBright", Category.VISUAL, 0);
    }

    @Override
    public void onEnable() {
        oldGamma = minecraft.gameSettings.gammaSetting;
        minecraft.gameSettings.gammaSetting = 15;
    }

    @Override
    public void onDisable() {
        minecraft.gameSettings.gammaSetting = oldGamma;
    }
}
