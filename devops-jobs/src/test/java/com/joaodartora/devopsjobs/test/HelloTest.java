package com.joaodartora.devopsjobs.test;

import com.joaodartora.devopsjobs.main.HelloServlet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloTest {

    @Test
    public void testHello() {
        HelloServlet helloServlet = new HelloServlet();
        assertEquals("Hello", helloServlet.getMessage());
    }

}
