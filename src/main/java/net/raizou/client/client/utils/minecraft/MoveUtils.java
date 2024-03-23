package net.raizou.client.client.utils.minecraft;

import org.lwjgl.input.Keyboard;

import static net.raizou.client.client.RaizouClient.mc;

public class MoveUtils {
    public static double[] getMoveStraight(float yaw, double speed) {
        //プレイヤーの直進移動を、yawの値を使ってシュミレート
        double moveX = speed * -Math.sin(Math.toRadians(yaw));
        double moveZ = speed * Math.cos(Math.toRadians(yaw));

        return new double[] {moveX, moveZ};
    }

    public static boolean isMoving() {
        return !(!Keyboard.isKeyDown(mc.gameSettings.keyBindForward.getKeyCode()) && !Keyboard.isKeyDown(mc.gameSettings.keyBindBack.getKeyCode()) && !Keyboard.isKeyDown(mc.gameSettings.keyBindRight.getKeyCode()) && !Keyboard.isKeyDown(mc.gameSettings.keyBindLeft.getKeyCode())) && mc.currentScreen == null;
    }

    public static void setMotion(double speed) {
        if (speed == 0) {
            mc.player.motionX = 0;
            mc.player.motionZ = 0;
            return;
        }
        double forward = mc.player.movementInput.moveForward;
        double strafe = mc.player.moveStrafing;
        float yaw = mc.player.rotationYaw;
        if (forward == 0.0D && strafe == 0.0D) {
            mc.player.motionX = 0;
            mc.player.motionZ = 0;
        } else {
            if (forward != 0.0D) {
                if (strafe > 0.0D) {
                    yaw += (forward > 0.0D ? -45 : 45);
                } else if (strafe < 0.0D) {
                    yaw += (forward > 0.0D ? 45 : -45);
                }
                strafe = 0.0D;
                if (forward > 0.0D) {
                    forward = 1;
                } else if (forward < 0.0D) {
                    forward = -1;
                }
            }
            mc.player.motionX = forward * speed * Math.cos(Math.toRadians(yaw + 90.0F)) + strafe * speed * Math.sin(Math.toRadians(yaw + 90.0F));
            mc.player.motionZ = forward * speed * Math.sin(Math.toRadians(yaw + 90.0F)) - strafe * speed * Math.cos(Math.toRadians(yaw + 90.0F));
        }
    }
}
