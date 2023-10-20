package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(
                     new BufferedOutputStream(
                             new FileOutputStream(target)
                     ))) {
            String line;
            boolean flag = true;
            String sep = System.lineSeparator();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if (flag == (data[0].contains("500") || data[0].contains("400"))) {
                    out.append(data[1]).append(";").append(flag ? "" : sep);
                    flag = !flag;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}