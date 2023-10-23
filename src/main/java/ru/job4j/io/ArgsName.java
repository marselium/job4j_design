package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        String str = values.get(key);
        if (str == null) {
            throw new IllegalArgumentException(String.format("This key: '%s' is missing", key));
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
        if (!str.contains("=")) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain an equal sign", str));
        }
        if (str.charAt(0) != '-') {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not start with a '-' character", str));
        }
        String val = str.substring(str.indexOf("=") + 1);
        String key = str.substring(str.indexOf("-") + 1, str.indexOf("="));
        if (val.isEmpty()) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a value", str));
        }
        if (key.isEmpty()) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a key", str));
        }
    }
}
