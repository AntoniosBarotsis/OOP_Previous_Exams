package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class iPadTest {
    private iPad iPad1;
    private iPad iPad2;
    private iPad iPad3;

    @BeforeEach
    public void init() {
        iPad1 = new iPad("AIR 2", 9.7, "A8", true, "SILVER", 64, 400);
        iPad2 = new iPad("AIR 2", 9.7, "A8", true, "SILVER", 64, 400);
        iPad3 = new iPad("PRO", 9.7, "A9", true, "SPACE GREY", 32, 650);
    }

    @Test
    public void addDeviceTest() {
        assertNotNull(iPad1);
        assertNotNull(iPad2);
        assertNotNull(iPad3);

        String str = "\nAIR 2\n 9.7 A8 true \nSILVER\n 64 true 400";
        Scanner sc = new Scanner(str);

        assertEquals(iPad1, iPad.addDevice(sc));
    }

    @Test
    public void readDeviceTest() {
        iPad tmp = iPad.readDevice("IPAD AIR 2, 9.7, A8, TRUE, SILVER, 64GB, 400".split(", "));

        assertEquals(iPad1, tmp);
    }

    @Test
    public void toStringTest() {
        assertEquals("Apple iPad AIR 2 with 64GB of memory\n" +
                "with an A8 processor and 9.7 inch screen\n" +
                "having WiFi and 4G technology\n" +
                "400 euros\n", iPad1.toString());
    }

    @Test
    public void toStringTextTest() {
        assertEquals("IPAD AIR 2, 9.7, A8, TRUE, SILVER, 64GB, 400\n", iPad1.toStringText());
    }

    @Test
    public void equalsTest() {
        assertEquals(iPad1, iPad2);
        assertNotEquals(iPad1, iPad3);
    }
}
