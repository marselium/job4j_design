package ru.job4j.parsing.parse;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import ru.job4j.parsing.parse.model.LocalDateTypeAdapter;
import ru.job4j.parsing.parse.model.PrCred;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Collection;

public class JsonCred {

    public void parse() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("prcred.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        Collection<PrCred> enums;

        Type collectionType = new TypeToken<Collection<PrCred>>(){}.getType();

        enums = gson.fromJson(reader, collectionType);

        enums.forEach(x -> System.out.println(x.getId() + ","));

        try (PrintWriter output = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("data/prcrID.txt")
                ))) {
            enums.forEach(x -> output.println(x.getId() + ","));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        JsonCred jsonCred = new JsonCred();
        jsonCred.parse();
    }
}
