package ru.job4j.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        String line;
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            while ((line = read.readLine()) != null) {
                if (!line.isEmpty() && line.charAt(0) != '#') {
                    String[] val = line.split("=", 2);
                    if (val.length < 2 || val[0].isEmpty() || val[1].isEmpty()) {
                        throw new IllegalArgumentException();
                    }
                    values.put(val[0], val[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config(("data/app.properties")));
    }
}
