package com.company;

import java.util.Comparator;

public class myThread implements Runnable{
    private Comparator<Device> comparator;
    private DeviceList deviceList;

    public myThread(Comparator<Device> comparator, DeviceList deviceList) {
        this.comparator = comparator;
        this.deviceList = deviceList;
    }
    @Override
    public void run() {
        deviceList.getDevices().sort(comparator);
    }
}
