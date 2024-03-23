package net.raizou.client.client.module.setting;

public class DoubleSetting implements BaseSetting{
    public double currentValue;
    private double minValue;
    private double maxValue;
    private double stepValue;//GUIのスライダーを一段上げたときに増える値

    public DoubleSetting(double minValue, double maxValue, double stepValue, double currentValue) {
        this.currentValue = currentValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.stepValue = stepValue;
    }

    @Override
    public Object getMinValue() {
        return this.minValue;
    }

    @Override
    public Object getMaxValue() {
        return this.maxValue;
    }

    public double getStepValue() {
        return this.stepValue;
    }

    @Override
    public Object getValue() {
        return this.currentValue;
    }

    @Override
    public void setValue(Object value) {
        this.currentValue = (Double)value;
    }

    @Override
    public void setMinValue(Object value) {
        this.minValue = (Double)value;
    }

    @Override
    public void setMaxValue(Object value) {
        this.maxValue = (Double)value;
    }
}
