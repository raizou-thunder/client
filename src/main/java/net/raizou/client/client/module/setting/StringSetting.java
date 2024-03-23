package net.raizou.client.client.module.setting;

public class StringSetting implements BaseSetting{
    private String value;
    
    public StringSetting(String value) {
        this.value = value;
    }
    
    @Override
    public Object getValue() {
        return this.value;
    }
    
    @Override
    public Object getMinValue() {
        return this.value;
    }
    
    @Override
    public Object getMaxValue() {
        return this.value;
    }
    
    @Override
    public void setValue(Object value) {
        this.value = (String)value;
    }
    
    @Override
    public void setMinValue(Object value) {
        this.value = (String)value;
    }
    
    @Override
    public void setMaxValue(Object value) {
        this.value = (String)value;
    }
}
