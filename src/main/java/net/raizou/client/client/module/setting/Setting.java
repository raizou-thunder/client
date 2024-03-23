package net.raizou.client.client.module.setting;

public class Setting {
    private String name;
    private BaseSetting type;
    
    public Setting(String name, BaseSetting type) {
        this.name = name;
        this.type = type;
    }
    
    public String getName() {
        return this.name;
    }

    public BaseSetting getType() {
        return this.type;
    }
}
