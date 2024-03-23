package net.raizou.client.client.module.setting;

public class ModeSetting implements BaseSetting {
    public String currentMode;
    private String[] Modes;

    public ModeSetting(String currentMode, String[] Modes) {
        this.currentMode = currentMode;
        this.Modes = Modes;
    }

    public String[] getModes() {
        return this.Modes;
    }

    @Override
    public Object getValue() {
        return this.currentMode;
    }

    @Override
    public Object getMinValue() {
        return "";
    }

    @Override
    public Object getMaxValue() {
        return this.Modes;
    }

    @Override
    public void setValue(Object value) {
        this.currentMode = (String)value;
    }

    @Override
    public void setMinValue(Object value) {
    }

    @Override
    public void setMaxValue(Object value) {
    }

}
