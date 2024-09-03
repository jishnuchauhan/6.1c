package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class MyAppTest {

    @Test
    public void testAdd() {
        MyApp app = new MyApp();
        assertEquals(5, app.add(2, 3));
    }

    @Test
    public void testSubtract() {
        MyApp app = new MyApp();
        assertEquals(1, app.subtract(3, 2));
    }

    @Test
    public void testMultiply() {
        MyApp app = new MyApp();
        assertEquals(6, app.multiply(2, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        MyApp app = new MyApp();
        app.divide(1, 0);
    }

    @Test
    public void testDivide() {
        MyApp app = new MyApp();
        assertEquals(2, app.divide(4, 2));
    }
}
