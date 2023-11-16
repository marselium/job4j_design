package ru.job4j.iterator.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        //Path start = Paths.get(".");
        validate(args);
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName().endsWith(".js")).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        try {
           Files.walkFileTree(root, searcher);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }
        return searcher.getPaths();
    }

    public static void validate(String[] args) {
        Path path = Paths.get(args[0]);
        if (args.length < 2) {
            throw new IllegalArgumentException("There must be 2 arguments;");
        }
        if (!Files.exists(path) || !Files.isDirectory(path)) {
            throw new IllegalArgumentException("Invalid path;");
        }
        if (!Objects.equals(args[1], ".js")) {
            throw new IllegalArgumentException("Format must be .js");
        }
    }
}