package io;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void test1() throws IOException {
        File source = new File("source.csv");
        File target = new File("target.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01" + System.lineSeparator() +
                    "500 10:57:01" + System.lineSeparator() +
                    "400 10:58:01" + System.lineSeparator() +
                    "200 10:59:01" + System.lineSeparator() +
                    "500 11:01:02" + System.lineSeparator() +
                    "200 11:02:02");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01;10:59:01;11:01:02;11:02:02;"));
    }
}