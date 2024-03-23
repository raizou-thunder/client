package net.raizou.client.client.module.modules.movement;

import net.raizou.client.client.module.modules.Category;
import net.raizou.client.client.module.modules.Module;
import net.raizou.client.client.module.setting.DoubleSetting;
import net.raizou.client.client.module.setting.ModeSetting;
import net.raizou.client.client.module.setting.Setting;
import net.raizou.client.client.utils.minecraft.MoveUtils;

import static net.raizou.client.client.RaizouClient.mc;

public class Flight extends Module {
    private DoubleSetting hSpeed, vSpeed;
    private ModeSetting mode;
    private String[] modes = {"Motion"};

    public Flight() {
        super("Flight", Category.NONE, 0);
        hSpeed = this.addDoubleSetting("HSpeed", 0.01, 20.0, 0.01, 1.0);
        vSpeed = this.addDoubleSetting("VSpeed", 0.01, 20.0, 0.01, 1.0);
        mode = this.addModeSetting("Mode", modes, "Motion");
    }

    @Override
    public void onUpdate() {
        switch (mode.currentMode) {
            case "Motion":
                //上下
                if (mc.gameSettings.keyBindJump.isKeyDown() && !mc.gameSettings.keyBindSneak.isKeyDown()) {
                    mc.player.motionY = vSpeed.currentValue;
                } else if (mc.gameSettings.keyBindSneak.isKeyDown() && !mc.gameSettings.keyBindJump.isKeyDown()) {
                    mc.player.motionY = -vSpeed.currentValue;
                } else {
                    mc.player.motionY = 0;
                }

                //前後左右
                MoveUtils.setMotion(hSpeed.currentValue);
        }
    }
}
