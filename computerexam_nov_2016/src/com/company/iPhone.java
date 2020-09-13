package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class iPhone extends Device{
    private enum ModemType { GSM, CMDA };
    private ModemType modemType;
    private boolean touch;

    public iPhone(String modelName, Double screenSize, String processor, String color, int memory, int price, ModemType modemType, boolean touch) {
        super(modelName, screenSize, processor, color, memory, price);

        this.modemType = modemType;
        this.touch = touch;
    }

    public static iPhone addDevice(Scanner scanner) {
        System.out.print("Please enter model name: ");
        String modelName = scanner.next();

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

    public static Device readDevice(String[] lineSplit) {
        String modelName = lineSplit[0].replace("IPHONE ", "");
        Double screenSize = Double.parseDouble(lineSplit[1]);
        String processor = lineSplit[2];
        ModemType modemType = (lineSplit[3].equals("GSM")) ? ModemType.GSM : ModemType.CMDA;
        String color = lineSplit[4];
        int memory = Integer.parseInt(lineSplit[5].replace("GB", ""));
        boolean touch = Boolean.parseBoolean(lineSplit[6]);
        int price = Integer.parseInt(lineSplit[7]);

        return new iPhone(modelName, screenSize, processor, color, memory, price, modemType, touch);
    };

    public String toString() {
        return "Apple iPhone " + modelName + " with " + memory + "GB of memory\n" +
                "with an " + processor + " and " + screenSize.setScale(2, RoundingMode.CEILING) + " inch screen\n" +
                price + " euros\n";
    }

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

    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof iPhone)) return false;

        iPhone that = (iPhone) o;
        return super.equals(that) &&
                this.touch == that.touch &&
                this.modemType == that.modemType;
    }
}