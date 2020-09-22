package com.company;

import java.math.RoundingMode;
import java.util.Scanner;

public class iPhone extends Device{
    protected enum ModemType { GSM, CMDA }
    private final ModemType modemType;
    private final boolean touch;

    /**
     * iPhone constructor
     * @param modelName
     * @param screenSize
     * @param processor
     * @param color
     * @param memory
     * @param price
     * @param modemType
     * @param touch
     */
    public iPhone(String modelName, Double screenSize, String processor, String color, int memory, int price, ModemType modemType, boolean touch) {
        super(modelName, screenSize, processor, color, memory, price);

        this.modemType = modemType;
        this.touch = touch;
    }

    /**
     * Creates a new iPhone
     * @param scanner
     * @return iPhone
     */
    public static iPhone addDevice(Scanner scanner) {
        System.out.print("Please enter model name: ");
        scanner.nextLine();
        String modelName = scanner.nextLine();

        System.out.print(("Please enter screen size: "));
        Double screenSize = scanner.nextDouble();

        System.out.print("Please enter processor: ");
        String processor = scanner.next();

        System.out.print("Please enter modem type (0 - CMDA, 1 - GSM): ");
        ModemType modemType = (scanner.nextInt() == 0) ? ModemType.CMDA : ModemType.GSM;

        System.out.print("Please enter color: ");
        scanner.nextLine();
        String color = scanner.nextLine();

        System.out.print("Please enter memory: ");
        int memory = scanner.nextInt();

        System.out.print("Please enter presence of 3d touch technology: ");
        boolean touch = scanner.nextBoolean();

        System.out.print("Please enter price: ");
        int price = scanner.nextInt();

        return new iPhone(modelName, screenSize, processor, color, memory, price, modemType, touch);
    }

    /**
     * Creats a new iPhone from a text file
     * @param lineSplit
     * @return iPhone
     */
    public static iPhone readDevice(String[] lineSplit) {
        String modelName = lineSplit[0].replace("IPHONE ", "");
        Double screenSize = Double.parseDouble(lineSplit[1]);
        String processor = lineSplit[2];
        ModemType modemType = (lineSplit[3].equals("GSM")) ? ModemType.GSM : ModemType.CMDA;
        String color = lineSplit[4];
        int memory = Integer.parseInt(lineSplit[5].replace("GB", ""));
        boolean touch = Boolean.parseBoolean(lineSplit[6]);
        int price = Integer.parseInt(lineSplit[7]);

        return new iPhone(modelName, screenSize, processor, color, memory, price, modemType, touch);
    }

    /**
     * toString implementation intended for terminal use
     * @return User friendly textual representation of the iPhone
     */
    public String toString() {
        return "Apple iPhone " + modelName + " with " + memory + "GB of memory\n" +
                "with an " + processor + " processor and " + screenSize.setScale(1, RoundingMode.CEILING) + " inch screen\n" +
                (int) (price) + " euros\n";
    }

    /**
     * toString implementation intended for text file use
     * @return The textual representation of the iPhone in the text file format
     */
    public String toStringText() {
        return "IPHONE " + modelName + ", " +
                screenSize.setScale(2, RoundingMode.HALF_UP).stripTrailingZeros() + ", " +
                processor + ", " +
                modemType + ", " +
                color + ", " +
                memory + "GB, " +
                ((touch) ? "TRUE" : "FALSE") + ", " +
                (int) price + "\n";
    }

    /**
     * Checks if this DeviceList is equal to another object
     * @param other
     * @return True iff other is an iPhone and has identical properties
     */
    public boolean equals(Object other) {
        if (this == other) return true;

        if (!(other instanceof iPhone)) return false;

        iPhone that = (iPhone) other;
        return super.equals(that) &&
                this.touch == that.touch &&
                this.modemType == that.modemType;
    }
}