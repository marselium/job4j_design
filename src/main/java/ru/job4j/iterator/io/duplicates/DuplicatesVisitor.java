package ru.job4j.iterator.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Map<Path, FileProperty> doublet = new HashMap<>();
    private Map<FileProperty, Path> origin = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toAbsolutePath());
        if (!attrs.isDirectory()) {
            FileProperty prop = new FileProperty(attrs.size(), file.getFileName().toString());
            if (origin.containsKey(prop)) {
                doublet.put(origin.get(prop), prop);
            } else {
                origin.put(prop, file);
            }
        }
        return super.visitFile(file, attrs);
    }

    public Map<Path, FileProperty> getDoublet() {
        return doublet;
    }
}