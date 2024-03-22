package net.raizou.client.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;

public class Module {
    protected Minecraft minecraft = Minecraft.getMinecraft();

    public String name;
    public Category category;
    public boolean istoggled;
    public int keybind;

    public Module(String name, Category category, int keybind) {
        super();
        this.name = name;
        this.category = category;
        this.keybind = keybind;
        this.istoggled = false;
    }

    public void Enable() {
        MinecraftForge.EVENT_BUS.register(this);
        minecraft.player.sendMessage(new TextComponentString("[RaizouClient] " + this.name + " Enabled"));
    }

    public void Disable() {
        MinecraftForge.EVENT_BUS.unregister(this);
        minecraft.player.sendMessage(new TextComponentString("[RaizouClient] " + this.name + " Disabled"));
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    public void onUpdate() {
    }

    public void toggle() {
        if (istoggled) {
            onDisable();
            Disable();
        } else {
            Enable();
            onEnable();
        }
        istoggled = !istoggled;
    }

    public String getName() {
        return this.name;
    }

    public int getNameLength() {
        return this.name.length();
    }
}
