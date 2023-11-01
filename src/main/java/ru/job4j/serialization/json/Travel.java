package ru.job4j.serialization.json;

import java.util.Arrays;

import ru.job4j.serialization.json.Country;

import java.util.Arrays;

public class Travel {

    private final boolean needVisa;
    private final int cost;
    private final String tourOperator;
    private final Country country;
    private final String[] hotel;

    public Travel(boolean needVisa, int cost, String tourOperator, Country country, String[] hotel) {
        this.needVisa = needVisa;
        this.cost = cost;
        this.tourOperator = tourOperator;
        this.country = country;
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Person{"
                + "needVisa=" + needVisa
                + ", cost=" + cost
                + ", tour operator=" + tourOperator
                + ", country=" + country
                + ", hotel=" + Arrays.toString(hotel)
                + '}';
    }
}
