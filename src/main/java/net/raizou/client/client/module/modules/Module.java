package net.raizou.client.client.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.raizou.client.client.module.setting.*;

import java.util.ArrayList;

import static net.raizou.client.client.RaizouClient.mc;

public class Module {
    public String name;
    public Category category;
    public boolean istoggled;
    public int keybind;
    public ArrayList<Setting> settings;

    public Module(String name, Category category, int keybind) {
        super();
        this.name = name;
        this.category = category;
        this.keybind = keybind;
        this.istoggled = false;
        this.settings = new ArrayList();
    }

    public void Enable() {
        MinecraftForge.EVENT_BUS.register(this);
        mc.player.sendMessage(new TextComponentString("[RaizouClient] " + this.name + " Enabled"));
    }

    public void Disable() {
        MinecraftForge.EVENT_BUS.unregister(this);
        mc.player.sendMessage(new TextComponentString("[RaizouClient] " + this.name + " Disabled"));
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

    protected DoubleSetting addDoubleSetting(String name, double min, double max, double step, double current) {
        DoubleSetting setting = new DoubleSetting(min, max, step, current);

        this.settings.add(new Setting(name, setting));
        return setting;
    }

    protected ModeSetting addModeSetting(String name, String[] modes, String current) {
        ModeSetting setting = new ModeSetting(current, modes);

        this.settings.add(new Setting(name, setting));
        return setting;
    }

    protected ColorSetting addColorSetting(String name, int hexColor) {
        ColorSetting setting = new ColorSetting(hexColor);

        this.settings.add(new Setting(name, setting));
        return setting;
    }

    protected BooleanSetting addBooleanSetting(String name, boolean current) {
        BooleanSetting setting = new BooleanSetting(current);

        this.settings.add(new Setting(name, setting));
        return setting;
    }
}
