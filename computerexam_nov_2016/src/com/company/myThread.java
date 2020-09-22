package com.company;

import java.util.Comparator;

public class myThread implements Runnable{
    private final Comparator<Device> comparator;
    private final DeviceList deviceList;

    public myThread(Comparator<Device> comparator, DeviceList deviceList) {
        this.comparator = comparator;
        this.deviceList = deviceList;
    }
    @Override
    public void run() {
        deviceList.getDevices().sort(comparator);
//        deviceList.getDevices().sort((x, y) -> (int) (x.price - y.price));
    }
}
