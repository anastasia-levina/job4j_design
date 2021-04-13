package io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(("1  2  3  4  5" + System.lineSeparator() +
                    "2  4  6  8  10" + System.lineSeparator() +
                    "3  6  9  12 15" + System.lineSeparator() +
                    "4  8  12 16 20" + System.lineSeparator() +
                    "5  10 15 20 25" + System.lineSeparator()).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}