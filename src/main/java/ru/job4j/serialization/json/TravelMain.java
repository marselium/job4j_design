package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.serialization.json.Travel;

public class TravelMain {
    public static void main(String[] args) {
        final Travel travel = new Travel(true, 122000, "Anex Tour",
                new Country("Egypt"), new String[]{"Kleopatra", "5-Star"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(travel));
        final String travelJson =
                "{"
                        + "\"needVisa\":true,"
                        + "\"cost\":130000,"
                        + "\"tourOperator\":\"Anex Tour\","
                        + "\"country\":"
                        + "{"
                        + "\"name\":\"Egypt\""
                        + "},"
                        + "\"hotel\":"
                        + "[\"Kleopatra\",\"5-Star\"]"
                        + "}";

        final Travel travel1 = gson.fromJson(travelJson, Travel.class);
        System.out.println(travel1);
    }
}
