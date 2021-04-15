package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String fileName) {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            return in.lines()
                    .filter(s -> {
                                String[] elements = s.split(" ");
                                return "404".equals(elements[elements.length - 2]);
                            }
                    )
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}