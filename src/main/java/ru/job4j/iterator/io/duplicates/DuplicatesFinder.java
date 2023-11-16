package ru.job4j.iterator.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), new DuplicatesVisitor());
        for (Map.Entry<Path, FileProperty> entry : duplicatesVisitor.getDoublet().entrySet()) {
            FileProperty val = entry.getValue();
            System.out.println("Size: " + val.getSize() + " Kb; Name :  " + val.getName());
        }
    }
}
