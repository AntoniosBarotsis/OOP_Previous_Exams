package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class iPhoneTest {
    private iPhone iPhone1;
    private iPhone iPhone12;
    private iPhone iPhone2;
    private iPhone iPhone3;

    @BeforeEach
    public void init() {
        iPhone1 = new iPhone("7", 4.7, "A10", "JET BLACK", 32, 700, iPhone.ModemType.GSM, true);
        iPhone12 = new iPhone("7", 4.7, "A10", "JET BLACK", 32, 700, iPhone.ModemType.CMDA, true);
        iPhone2 = new iPhone("7", 4.7, "A10", "JET BLACK", 32, 700, iPhone.ModemType.GSM, true);
        iPhone3 = new iPhone("SE", 4.0, "A9", "SILVER", 16, 490, iPhone.ModemType.CMDA, false);
    }

    @Test
    public void addDeviceTest() {
        assertNotNull(iPhone1);
        assertNotNull(iPhone12);
        assertNotNull(iPhone2);
        assertNotNull(iPhone3);

        String str = "\n7\n 4.7 A10 1 \nJET BLACK\n 32 true 700";
        Scanner sc = new Scanner(str);

        assertEquals(iPhone1, iPhone.addDevice(sc));
    }

    @Test
    public void readDeviceTest() {
        iPhone tmp = iPhone.readDevice("IPHONE 7, 4.7, A10, GSM, JET BLACK, 32GB, TRUE, 700".split(", "));

        assertEquals(iPhone1, tmp);
    }

    @Test
    public void toStringTest() {
        assertEquals("Apple iPhone 7 with 32GB of memory\n" +
                "with an A10 processor and 4.7 inch screen\n" +
                "700 euros\n", iPhone1.toString());
    }

    @Test
    public void toStringTextTest() {
        assertEquals("IPHONE 7, 4.7, A10, GSM, JET BLACK, 32GB, TRUE, 700\n", iPhone1.toStringText());
    }

    @Test
    public void equalsTest() {
        assertEquals(iPhone1, iPhone2);
        assertNotEquals(iPhone1, iPhone12);
        assertNotEquals(iPhone1, iPhone3);
    }
}


