package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class DeviceList {
    private LinkedList<Device> devices;

    public DeviceList() {
        this.devices = new LinkedList<Device>();
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void readDevices(Scanner scanner) {
        String line = "";
        String[] lineSplit = null;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            lineSplit = line.split(", ");

            if (lineSplit[0].contains("IPHONE"))
                addDevice(iPhone.readDevice(lineSplit));
            else if (lineSplit[0].contains("IPAD"))
                addDevice(iPad.readDevice(lineSplit));
            else
                throw new IllegalArgumentException();

        }
    }

    public String toString(boolean textFormat) {
        StringBuilder str = new StringBuilder();

        for (Device d : devices)
            str.append((textFormat) ? d.toStringText() : d.toString());

        str.deleteCharAt(str.length() - 1);

        return str.toString();
    }

    public boolean equals(Object other) {
        if (this == other) return true;

        if (!(other instanceof DeviceList)) return false;

        DeviceList that = (DeviceList) other;

        for (int i = 0; i < this.getDevices().size(); i++)
            if (!(this.getDevices().get(i).equals(that.getDevices().get(i))))
                return false;

        return true;
    }

    public LinkedList<Device> getDevices() {
        return devices;
    }
}
