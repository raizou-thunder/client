package net.raizou.client.modules;

import net.raizou.client.modules.movement.*;
import net.raizou.client.modules.none.*;

import java.util.ArrayList;

public class ModuleManager {
    public ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager()
    {
        modules.add(new Sprint());
        modules.add(new TestModule());
    }
}
