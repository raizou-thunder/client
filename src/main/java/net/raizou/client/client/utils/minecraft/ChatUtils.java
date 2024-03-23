package net.raizou.client.client.utils.minecraft;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;

import java.util.Iterator;
import java.util.List;

import static net.raizou.client.client.RaizouClient.mc;

public class ChatUtils {
    public static void addChatMessage(Object message) {
        mc.player.sendMessage(new TextComponentString(String.valueOf(message)));
    }

    public static void addChatMessageWithWaterMark(Object message) {
        mc.player.sendMessage(new TextComponentString("RaizouClient | " + String.valueOf(message)));
    }
}
