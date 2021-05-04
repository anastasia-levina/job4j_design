package io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class SearchFiles extends PrintFiles {
    private final Predicate<Path> predicate;
    private final List<Path> list = new ArrayList<>();

    SearchFiles(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    public List<Path> getPaths() {
        return list;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isRegularFile() && predicate.test(file)) {
            list.add(file.toAbsolutePath());
        }
        return FileVisitResult.CONTINUE;
    }
}
