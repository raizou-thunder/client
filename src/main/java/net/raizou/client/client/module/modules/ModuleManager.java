package net.raizou.client.client.module.modules;

import net.raizou.client.client.module.modules.movement.Flight;
import net.raizou.client.client.module.modules.movement.Sprint;
import net.raizou.client.client.module.modules.none.TestModule;
import net.raizou.client.client.module.modules.player.AutoRespawn;
import net.raizou.client.client.module.modules.visual.EntityESP;
import net.raizou.client.client.module.modules.visual.FullBright;
import net.raizou.client.client.module.modules.visual.Zoom;

import java.util.ArrayList;

public class ModuleManager {
    public ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager() {
        modules.add(new Flight());
        modules.add(new Zoom());
        modules.add(new EntityESP());
        modules.add(new Sprint());
        modules.add(new TestModule());
        modules.add(new FullBright());
        modules.add(new AutoRespawn());
    }
}
