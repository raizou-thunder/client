package net.raizou.client.client.command.commands;

import net.raizou.client.client.RaizouClient;
import net.raizou.client.client.command.Command;
import net.raizou.client.client.module.modules.Module;
import net.raizou.client.client.utils.minecraft.ChatUtils;
import org.lwjgl.input.Keyboard;

public class Bind extends Command {
    public Bind() {
        super("Bind", "B", "Bind <Module> <Key>");
    }

    @Override
    public void executeCommand(String[] args) {
        try {
            for (Module m : RaizouClient.moduleManager.modules) {
                if (m.name.equalsIgnoreCase(args[1])) {
                    m.keybind = Keyboard.getKeyIndex(args[2].toUpperCase());
                    ChatUtils.addChatMessageWithWaterMark(args[1] + " was bound to " + args[2]);
                    return;
                }
            }
            ChatUtils.addChatMessageWithWaterMark("Module not found");
        } catch (Exception ex) {
            ChatUtils.addChatMessageWithWaterMark("Error");
        }
    }
}
