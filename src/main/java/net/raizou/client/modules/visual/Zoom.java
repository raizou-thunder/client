package net.raizou.client.modules.visual;

import net.raizou.client.modules.Category;
import net.raizou.client.modules.Module;
import org.lwjgl.input.Keyboard;

public class Zoom extends Module {
    private float oldFov;

    public Zoom() {
        super("Zoom", Category.NONE, Keyboard.KEY_C);
    }

    @Override
    public void onEnable() {
        oldFov = minecraft.gameSettings.fovSetting;
        minecraft.gameSettings.fovSetting -= 30;
    }

    @Override
    public void onDisable() {
        minecraft.gameSettings.fovSetting = oldFov;
    }
}
