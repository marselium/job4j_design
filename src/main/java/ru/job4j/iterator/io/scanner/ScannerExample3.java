package ru.job4j.iterator.io.scanner;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.util.Scanner;

public class ScannerExample3 {
    public static void main(String[] args) throws Exception {
        var data = "A 1B FF 100";
        var file = File.createTempFile("data", null);
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            out.write(data.getBytes());
        }
        try (var scanner = new Scanner(file).useRadix(16)) {
            while (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
                System.out.println(" ");
            }
        }
    }
}
