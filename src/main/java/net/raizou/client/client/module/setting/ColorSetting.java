package net.raizou.client.client.module.setting;

public class ColorSetting implements BaseSetting{
    public int hexColor;

    public ColorSetting(int hexColor) {
        this.hexColor = hexColor;
    }
    
    @Override
    public Object getValue() {
        return this.hexColor;
    }

    @Override
    public void setValue(Object value) {
        this.hexColor = (Integer)value;
    }

    @Override
    public Object getMinValue() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public Object getMaxValue() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    public void setMinValue(Object var1) {
        // TODO 自動生成されたメソッド・スタブ
        
    }

    @Override
    public void setMaxValue(Object var1) {
        // TODO 自動生成されたメソッド・スタブ
        
    }
}
