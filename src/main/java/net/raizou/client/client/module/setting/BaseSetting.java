package net.raizou.client.client.module.setting;

public interface BaseSetting {
    
    public Object getValue();

    public Object getMinValue();

    public Object getMaxValue();

    public void setValue(Object var1);

    public void setMinValue(Object var1);

    public void setMaxValue(Object var1);
}
