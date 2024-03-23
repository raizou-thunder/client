package net.raizou.client.client.command;

import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.raizou.client.client.command.commands.Bind;
import net.raizou.client.client.command.commands.Toggle;
import net.raizou.client.client.utils.minecraft.ChatUtils;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.Objects;

import static net.raizou.client.client.RaizouClient.mc;

public class CommandManager {
    public ArrayList<Command> commands = new ArrayList<>();
    public String PREFIX = ".";

    public CommandManager() {
        commands.add(new Bind());
        commands.add(new Toggle());
    }

    @SubscribeEvent
    public void listener(ClientChatEvent e) {
        if (mc.world == null || mc.player == null) {
            return;
        }

        String content = String.valueOf(e.getMessage()).toLowerCase();
        if (content.startsWith(PREFIX)) {
            e.setCanceled(true);
            for (Command c : commands) {
                if (Objects.equals(c.getName().toLowerCase(), content.split(" ")[0].replace(PREFIX, ""))
                || Objects.equals(c.getName2().toLowerCase(), content.split(" ")[0].replace(PREFIX, ""))) {
                    c.executeCommand(content.split(" "));
                    return;
                }
            }
        } else {
            return;
        }
        ChatUtils.addChatMessage("Command not found");
    }
}
