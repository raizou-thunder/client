package net.raizou.client;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.raizou.client.events.PlayerKeyInputEvent;
import net.raizou.client.events.PlayerTickEvent;
import net.raizou.client.ui.ArrayList;
import net.raizou.client.ui.Hud;
import net.raizou.client.modules.ModuleManager;
import net.raizou.client.ui.HudGui;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(modid = RaizouClient.MODID, name = RaizouClient.NAME, version = RaizouClient.VERSION)
public class RaizouClient
{
    public static final String MODID = "raizouclient";
    public static final String NAME = "Raizou Client";
    public static final String VERSION = "1.0";

    private static Logger logger;

    public static ModuleManager module = new ModuleManager();
    public PlayerKeyInputEvent playerKeyInputEvent = new PlayerKeyInputEvent();
    public PlayerTickEvent playerTickEvent = new PlayerTickEvent();
    public Hud hud = new Hud();
    public static HudGui hudGui = new HudGui();
    public ArrayList arrayList = new ArrayList();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        System.out.print("preInit");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        Display.setTitle(NAME + " " + VERSION);
        System.out.print("init");

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(playerKeyInputEvent);
        MinecraftForge.EVENT_BUS.register(playerTickEvent);
        MinecraftForge.EVENT_BUS.register(hud);
        MinecraftForge.EVENT_BUS.register(hudGui);
        MinecraftForge.EVENT_BUS.register(arrayList);
    }
}
