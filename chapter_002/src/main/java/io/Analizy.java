package io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        String[] signalDownServer = {"400", "500"};
        boolean activity = true;
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            String line;
            while ((line = read.readLine()) != null) {
                String[] range = line.split(" ");
                String signal = range[0];
                String time = range[1];
                for (String s : signalDownServer) {
                    if (signal.equals(s) && activity) {
                        out.print(time + ";");
                        activity = false;
                    }
                }
                if (!signal.startsWith("400") && !signal.startsWith("500") && !activity) {
                    out.println(time + ";");
                    activity = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}