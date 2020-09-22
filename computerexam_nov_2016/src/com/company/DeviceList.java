package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class DeviceList {
    private final LinkedList<Device> devices;


    /**
     * Constructs an empty DeviceList
     */
    public DeviceList() {
        this.devices = new LinkedList<>();
    }

    /**
     * Constructs a DeviceList and fills it with the contents of the passed array of Devices
     * @param devices
     */
    public DeviceList(Device[] devices) {
        this.devices = new LinkedList<>();

        this.devices.addAll(Arrays.asList(devices));
    }

    /**
     * Adds a Device to the DeviceList
     * @param device
     */
    public void addDevice(Device device) {
        devices.add(device);
    }

    /**
     * Reads a text file containing a list of devices and adds all of them to the list
     * @param scanner
     */
    public void readDevices(Scanner scanner) {
        String line;
        String[] lineSplit;

        while (scanner.hasNextLine()) {
            lineSplit = scanner.nextLine().split(", ");

            if (lineSplit[0].contains("IPHONE"))
                addDevice(iPhone.readDevice(lineSplit));
            else if (lineSplit[0].contains("IPAD"))
                addDevice(iPad.readDevice(lineSplit));
            else
                throw new IllegalArgumentException();

        }
    }

    /**
     * toString implementation intended for terminal use
     * @return User friendly textual representation of the list
     */
    public String toString() {
        StringBuilder str = new StringBuilder();

        devices.forEach(d -> str.append(d.toString()));

        str.deleteCharAt(str.length() - 1);

        return str.toString();
    }

    /**
     * toString implementation intended for text file use
     * @return The textual representation of the list in the text file format
     */
    public String toStringText() {
        StringBuilder str = new StringBuilder();

        devices.forEach(d -> str.append(d.toStringText()));

        str.deleteCharAt(str.length() - 1);

        return str.toString();
    }

    /**
     * Checks if this DeviceList is equal to another object
     * @param other
     * @return True iff other is a DeviceList and has identical properties
     */
    public boolean equals(Object other) {
        if (this == other) return true;

        if (!(other instanceof DeviceList)) return false;

        DeviceList that = (DeviceList) other;

        if (this.devices.size() != that.devices.size()) return false;

        for (int i = 0; i < this.getDevices().size(); i++)
            if (!(this.getDevices().get(i).equals(that.getDevices().get(i))))
                return false;

        return true;
    }

    /**
     * DeviceList getter
     * @return The LinkedList of devices
     */
    public LinkedList<Device> getDevices() {
        return devices;
    }
}
