package io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(("1  2  3  4  5\n" +
                    "2  4  6  8  10\n" +
                    "3  6  9  12 15\n" +
                    "4  8  12 16 20\n" +
                    "5  10 15 20 25\n").getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}