package net.raizou.client.client.module.modules.visual;

import net.raizou.client.client.module.modules.Category;
import net.raizou.client.client.module.modules.Module;
import org.lwjgl.input.Keyboard;

import static net.raizou.client.client.RaizouClient.mc;

public class Zoom extends Module {
    private float oldFov;

    public Zoom() {
        super("Zoom", Category.NONE, Keyboard.KEY_C);
    }

    @Override
    public void onEnable() {
        oldFov = mc.gameSettings.fovSetting;
        mc.gameSettings.fovSetting -= 30;
    }

    @Override
    public void onDisable() {
        mc.gameSettings.fovSetting = oldFov;
    }
}
