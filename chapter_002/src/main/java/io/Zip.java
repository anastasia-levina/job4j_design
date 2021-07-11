package io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target.toFile())))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toFile().getPath()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName arguments = ArgsName.of(args);
        Path directory = Path.of(arguments.get("d"));
        Path output = Path.of(arguments.get("o"));
        String exclude = arguments.get("e");
        if (directory == null || output == null || exclude == null) {
            throw new IllegalArgumentException("The required arguments -d, -o or -e are missing");
        }
        try {
            List<Path> search = Search.search(directory, s -> !s.toFile().getName().endsWith(exclude));
            packFiles(search, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}