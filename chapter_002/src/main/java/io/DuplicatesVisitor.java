package io;


import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Set<FileProperty> setFiles = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty element = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (!setFiles.add(element)) {
            System.out.println(file.toFile().getName());
            System.out.println("there is a duplicate");
        } else System.out.println("no duplicates");
        System.out.println(file.toAbsolutePath());
        return super.visitFile(file, attrs);
    }

    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Path.of("./chapter_002"), new DuplicatesVisitor());
    }
}