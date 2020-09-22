package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	    String msg = "\nPlease make your choice:\n" +
                "1 - Show the entire Apple catalogue\n" +
                "2 – Add a new iPhone\n" +
                "3 – Add a new iPad\n" +
                "4 - Show the entire Apple catalogue sorted by product\n" +
                "5 – Show the entire Apple catalogue sorted by price (low -> high)\n" +
                "6 – Write to file\n" +
                "7 – Stop the program\n";

	    int input = 0;
	    Scanner scanner = new Scanner(System.in);
        DeviceList deviceList = new DeviceList();
        String filename = readFile(scanner);

        try {
            deviceList.readDevices(new Scanner(new File(filename)));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        while (input != 7) {
            System.out.println(msg);
            input = scanner.nextInt();

            switch (input) {
                case 1:
                    System.out.println(deviceList.toString());
                    break;
                case 2: // Add a new iPhone
                    deviceList.addDevice(iPhone.addDevice(scanner));
                    break;
                case 3: // Add a new iPad
                    deviceList.addDevice(iPad.addDevice(scanner));
                    break;
                case 4: // Show the entire Apple catalogue sorted by product
//                    myThread = new myThread(new productComparator(), deviceList);
//                    myThread.run();
                    new Thread(() -> deviceList.getDevices()
                            .sort((x, y) -> CharSequence.compare(x.modelName, y.modelName)))
                            .start();
                    break;
                case 5: // Show the entire Apple catalogue sorted by price (low -> high)
//                    myThread = new myThread(new priceComparator(), deviceList);
//                    myThread.run();
                    new Thread(() -> deviceList.getDevices()
                            .sort((x, y) -> (int) (x.price - y.price)))
                            .start();
                    break;
                case 6: // Write to file
                    if (!isFileRead(filename))
                        filename = readFile(scanner);

                    try {
                        new FileWriter((new File(filename)))
                                .write(deviceList.toStringText());
                    } catch (IOException e) {
                        System.out.println("File not found.");
                        filename = "";
                    }
                    break;
                case 7: // Stop the program
                    System.out.println("\nBye!");
                    break;
                default:
                    System.out.println("\nInvalid input (Please enter a number between 1 and 7!)\n");
            }

        }
    }

    /**
     * Checks if the file name is empty (because of how the code above works this would mean that the file was not found
     * @param fileName
     * @return True if the fileName is not empty
     */
    public static boolean isFileRead(String fileName) {
        return !fileName.equals("");
    }

    /**
     * Reads the fileName from the user and adds the file extension if needed
     * @param scanner
     * @return fileName
     */
    public static String readFile(Scanner scanner) {
        System.out.print("Please enter the file name: ");
        String filename = scanner.next();

        return (filename.contains(".txt") ? filename : filename.concat(".txt"));
    }
}
