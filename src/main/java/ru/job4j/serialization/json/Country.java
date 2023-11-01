package ru.job4j.serialization.json;

public class Country {
    private final String name;

    public Country(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{"
                + "name='" + name  + '\''
                + '}';
    }
}
