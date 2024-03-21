package net.raizou.client.modules.movement;

import net.minecraft.client.Minecraft;
import net.raizou.client.modules.Category;
import net.raizou.client.modules.Module;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module {
    public Sprint()
    {
        super("Sprint", Category.NONE, Keyboard.KEY_B);
    }

    Minecraft minecraft = Minecraft.getMinecraft();

    @Override
    public void onUpdate()
    {
        if(minecraft.player.moveForward > 0)
        {
            minecraft.player.setSprinting(true);
        }
    }
}
