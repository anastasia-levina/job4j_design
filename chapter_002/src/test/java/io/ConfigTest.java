package io;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "../app.properties";
        Config config = new Config(path);
        try {
            config.load();
        } catch (IOException e) {
            fail();
        }
        assertThat(config.value("name"), is("Petr"));
    }

    @Test
    public void whenIsNoPair() {
        String path = "../testByNull.properties";
        Config config = new Config(path);
        try {
            config.load();
        } catch (IOException e) {
            fail();
        }
        assertNull(config.value("10"));
    }

    @Test
    public void whenPairWithComment() {
        String path = "../comment.properties";
        Config config = new Config(path);
        try {
            config.load();
        } catch (IOException e) {
            fail();
        }
        assertNull(config.value("hibernate.connection.password=password"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenException() {
        String path = "../ex.properties";
        Config config = new Config(path);
        try {
            config.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}