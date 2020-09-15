package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class DeviceListTest {
    private iPhone iPhone1;
    private iPhone iPhone2;
    private iPad iPad1;
    private iPad iPad2;
    private DeviceList deviceList;

    @BeforeEach
    public void init() {
        iPhone1 = new iPhone("7", 4.7, "A10", "JET BLACK", 32, 700, iPhone.ModemType.GSM, true);
        iPhone2 = new iPhone("SE", 4.0, "A9", "SILVER", 16, 490, iPhone.ModemType.CMDA, false);
        iPad1 = new iPad("AIR 2", 9.7, "A8", true, "SILVER", 64, 400);
        iPad2 = new iPad("PRO", 9.7, "A9", true, "SPACE GREY", 32, 650);

        deviceList = new DeviceList(new Device[]{iPhone1, iPhone2, iPad1});
    }

    @Test
    public void addDeviceTest() {
        assertNotNull(iPhone1);
        assertNotNull(iPhone2);
        assertNotNull(iPad1);
        assertNotNull(iPad2);
        assertNotNull(deviceList);

        assertEquals(3, deviceList.getDevices().size());

        deviceList.addDevice(iPad2);

        assertEquals(4, deviceList.getDevices().size());
    }

    @Test
    public void readDevicesTest() {
        assertEquals(3, deviceList.getDevices().size());

        deviceList.readDevices(new Scanner("IPAD PRO, 9.7, A9, TRUE, SPACE GREY, 32GB, 650"));

        assertEquals(4, deviceList.getDevices().size());
        assertEquals(iPad2, deviceList.getDevices().get(3));

        deviceList.readDevices(new Scanner("IPHONE 7, 4.7, A10, GSM, JET BLACK, 32GB, TRUE, 700\n"));
        assertEquals(5, deviceList.getDevices().size());
        assertEquals(iPhone1, deviceList.getDevices().get(4));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            deviceList.readDevices(new Scanner("Bruh PRO, 9.7, A9, TRUE, SPACE GREY, 32GB, 650"));
        });
    }

    @Test
    public void toStringTest() {
        assertEquals("Apple iPhone 7 with 32GB of memory\n" +
                "with an A10 processor and 4.7 inch screen\n" +
                "700 euros\n" +
                "Apple iPhone SE with 16GB of memory\n" +
                "with an A9 processor and 4.0 inch screen\n" +
                "490 euros\n" +
                "Apple iPad AIR 2 with 64GB of memory\n" +
                "with an A8 processor and 9.7 inch screen\n" +
                "having WiFi and 4G technology\n" +
                "400 euros", deviceList.toString());
    }

    @Test
    public void toStringTextTest() {
        assertEquals("IPHONE 7, 4.7, A10, GSM, JET BLACK, 32GB, TRUE, 700\n" +
                "IPHONE SE, 4, A9, CMDA, SILVER, 16GB, FALSE, 490\n" +
                "IPAD AIR 2, 9.7, A8, TRUE, SILVER, 64GB, 400", deviceList.toStringText());
    }

    @Test
    public void equalsTest() {
        assertNotEquals(deviceList, new DeviceList());
        assertEquals(deviceList, new DeviceList(new Device[]{iPhone1, iPhone2, iPad1}));
        assertNotEquals(deviceList, new DeviceList(new Device[]{iPhone1, iPhone2, iPad2}));
        assertNotEquals(deviceList, new DeviceList(new Device[]{iPhone1, iPhone2, iPad1, iPad2}));
    }

    @Test
    public void getDevicesTest() {
        assertEquals(deviceList.getDevices(), Arrays.asList(iPhone1, iPhone2, iPad1));
    }
}
