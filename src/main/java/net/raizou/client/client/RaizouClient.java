package net.raizou.client.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.raizou.client.client.events.PlayerKeyInputEvent;
import net.raizou.client.client.events.PlayerTickEvent;
import net.raizou.client.client.module.modules.ModuleManager;
import net.raizou.client.client.ui.ArrayList;
import net.raizou.client.client.ui.Hud;
import net.raizou.client.client.ui.HudGui;
import net.raizou.client.client.command.CommandManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(modid = RaizouClient.MODID, name = RaizouClient.NAME, version = RaizouClient.VERSION)
public class RaizouClient {
    public static Minecraft mc = Minecraft.getMinecraft();
    public static final String MODID = "raizouclient";
    public static final String NAME = "RaizouClient";
    public static final String VERSION = "1.0";
    public static ModuleManager moduleManager = new ModuleManager();
    public static HudGui hudGui = new HudGui();
    public static RaizouClient instance = new RaizouClient();
    private static Logger logger;
    public PlayerKeyInputEvent playerKeyInputEvent = new PlayerKeyInputEvent();
    public PlayerTickEvent playerTickEvent = new PlayerTickEvent();
    public Hud hud = new Hud();
    public ArrayList arrayList = new ArrayList();
    public CommandManager commandManager = new CommandManager();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        System.out.print("preInit");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        Display.setTitle(NAME + " " + VERSION);
        System.out.print("init");

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(playerKeyInputEvent);
        MinecraftForge.EVENT_BUS.register(playerTickEvent);
        MinecraftForge.EVENT_BUS.register(hud);
        MinecraftForge.EVENT_BUS.register(hudGui);
        MinecraftForge.EVENT_BUS.register(arrayList);
        MinecraftForge.EVENT_BUS.register(commandManager);
    }
}