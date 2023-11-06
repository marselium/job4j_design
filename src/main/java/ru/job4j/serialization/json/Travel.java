package ru.job4j.serialization.json;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.serialization.json.Country;

import java.util.List;

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

    private boolean getNeedVisa() {
        return needVisa;
    }

    private int getCost() {
        return cost;
    }

    private String getTourOperator() {
        return tourOperator;
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

    public static void main(String[] args) {
        JSONObject jsonCountry = new JSONObject("{\"name\":\"Egypt\"}");
        List<String> list = new ArrayList<>();
        list.add("Kleopatra");
        list.add("5-star");
        JSONArray jsonHotel = new JSONArray(list);

        final Travel travel = new Travel(true, 122000, "Anex Tour",
                new Country("Egypt"), new String[]{"Kleopatra", "5-Star"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("needVisa", travel.getNeedVisa());
        jsonObject.put("cost", travel.getCost());
        jsonObject.put("tourOperator", travel.getTourOperator());
        jsonObject.put("country", jsonCountry);
        jsonObject.put("hotel", jsonHotel);
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(travel).toString());
    }
}
