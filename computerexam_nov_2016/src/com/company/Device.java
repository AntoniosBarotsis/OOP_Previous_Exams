package com.company;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public abstract class Device {
    protected String modelName;
    protected BigDecimal screenSize;
    protected String processor;
    protected String color;
    protected int memory;
    protected float price;

    public Device(String modelName, Double screenSize, String processor, String color, int memory, float price) {
        this.modelName = modelName;
        this.screenSize = new BigDecimal(screenSize, MathContext.DECIMAL64);
        this.processor = processor;
        this.color = color;
        this.memory = memory;
        this.price = price;
    }

    public static Device addDevice(Scanner scanner) {
        return null;
    };

    public static Device readDevice(Scanner scanner) throws IllegalArgumentException{
        return null;
    }

    public abstract String toString();

    public abstract String toStringText();

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
