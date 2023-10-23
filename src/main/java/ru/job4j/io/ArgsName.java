package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        String str = values.get(key);
        if (str == null) {
            throw new IllegalArgumentException("This key: '" + key + "' is missing");
        }
        return values.get(key);
    }

    public void parse(String[] args) {
        for (String el : args) {
            validate(el);
            String[] str = el.split("=", 2);
            values.put(str[0].replace("-", ""), str[1]);
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }

    private void validate(String str) {
        String[] strings = str.split("=", 2);
        if (!str.contains("=")) {
            throw new IllegalArgumentException("Error: This argument '" + str + "' does not contain an equal sign");
        }
        if (str.charAt(0) != '-') {
            throw new IllegalArgumentException("Error: This argument '" + str + "' does not start with a '-' character");
        }
        if (strings[1].isEmpty()) {
            throw new IllegalArgumentException("Error: This argument '" + str + "' does not contain a value");
        }
        if (Objects.equals(strings[0], "-")) {
            throw new IllegalArgumentException("Error: This argument '" + str + "' does not contain a key");
        }
    }
}
