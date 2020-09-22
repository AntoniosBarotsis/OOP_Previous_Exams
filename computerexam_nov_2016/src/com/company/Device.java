package com.company;

import java.math.BigDecimal;
import java.math.MathContext;

public abstract class Device {
    protected final String modelName;
    protected final BigDecimal screenSize;
    protected final String processor;
    protected final String color;
    protected final int memory;
    protected final float price;

    /**
     * Device constructor
     * @param modelName
     * @param screenSize
     * @param processor
     * @param color
     * @param memory
     * @param price
     */
    public Device(String modelName, Double screenSize, String processor, String color, int memory, float price) {
        this.modelName = modelName;
        this.screenSize = new BigDecimal(screenSize, MathContext.DECIMAL64);
        this.processor = processor;
        this.color = color;
        this.memory = memory;
        this.price = price;
    }

    public abstract String toString();

    public abstract String toStringText();

    /**
     * Checks if this DeviceList is equal to another object
     * @param other
     * @return True iff other is a Device and has identical properties
     */
    public boolean equals(Object other) {
        if (this == other) return true;

        if (!(other instanceof Device)) return false;

        Device that = (Device) other;

        return this.modelName.equals(that.modelName) &&
                this.screenSize.equals(that.screenSize) &&
                this.processor.equals(that.processor) &&
                this.color.equals(that.color) &&
                this.memory == that.memory &&
                (Float.compare(this.price, that.price) == 0);
    }
}
