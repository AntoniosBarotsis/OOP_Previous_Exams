package com.company;

import java.math.RoundingMode;
import java.util.Scanner;

public class iPad extends Device{
    private final boolean presenceOf4G;

    public iPad(String modelName, Double screenSize, String processor, boolean presenceOf4G, String color, int memory, int price) {
        super(modelName, screenSize, processor, color, memory, price);

        this.presenceOf4G = presenceOf4G;
    }

    public static iPad addDevice(Scanner scanner) {
        System.out.print("Please enter model name: ");
        scanner.nextLine();
        String modelName = scanner.nextLine();

        System.out.print(("Please enter screen size: "));
        Double screenSize = scanner.nextDouble();

        System.out.print("Please enter processor: ");
        String processor = scanner.next();

        System.out.print("Please enter presence of 4G technology? (true/false): ");
        boolean presenceOf4G = scanner.nextBoolean();

        System.out.print("Please enter color: ");
        scanner.nextLine();
        String color = scanner.nextLine();

        System.out.print("Please enter memory: ");
        int memory = scanner.nextInt();

        System.out.print("Please enter presence of 3d touch technology: ");
        boolean touch = scanner.nextBoolean();

        System.out.print("Please enter price: ");
        int price = scanner.nextInt();

        return new iPad(modelName, screenSize, processor, presenceOf4G, color, memory, price);
    }

    public static iPad readDevice(String[] lineSplit) {
        String modelName = lineSplit[0].replace("IPAD ", "");
        Double screenSize = Double.parseDouble(lineSplit[1]);
        String processor = lineSplit[2];
        boolean presenceOf4G = Boolean.parseBoolean(lineSplit[3]);
        String color = lineSplit[4];
        int memory = Integer.parseInt(lineSplit[5].replace("GB", ""));
        int price = Integer.parseInt(lineSplit[6]);

        return new iPad(modelName, screenSize, processor, presenceOf4G, color, memory, price);
    }

    public String toString() {
        return "Apple iPad " + modelName + " with " + memory + "GB of memory\n" +
                "with an " + processor + " processor and " + screenSize.setScale(1, RoundingMode.CEILING) + " inch screen\n" +
                "having WiFi " + ((presenceOf4G) ? "and" : "without") + " 4G technology\n" +
                (int) (price) + " euros\n";
    }

    public String toStringText() {
        return "IPAD " + modelName + ", " +
                screenSize.setScale(1, RoundingMode.CEILING).stripTrailingZeros() + ", " +
                processor + ", " +
                ((presenceOf4G) ? "TRUE" : "FALSE") + ", " +
                color + ", " +
                memory + "GB, " +
                (int) price + "\n";
    }

    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof iPad)) return false;

        iPad that = (iPad) o;
        return super.equals(that) &&
                this.presenceOf4G == that.presenceOf4G;
    }
}
