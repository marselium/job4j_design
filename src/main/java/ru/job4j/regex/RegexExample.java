package ru.job4j.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Я учусь на Job4j");

        String text1 = "Я учусь на Job4j";
        Matcher matcher1 = pattern.matcher(text1);
        boolean isPresent1 = matcher1.matches();
        System.out.println(isPresent1);

        String text2 = "Я учусь на курсе Job4j";
        Matcher matcher2 = pattern.matcher(text2);
        boolean isPresent2 = matcher2.matches();
        System.out.println(isPresent2);

        Pattern pattern1 = Pattern.compile("Job4j");
        String text = "Я учусь на курсе Job4j и Job4j и Job4j";
        Matcher matcher = pattern1.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение");
        }

        Pattern pattern3 = Pattern.compile("Job4j");
        String text3 = "Job4j1 и Job4j2 и Job4j3";
        Matcher matcher3 = pattern3.matcher(text3);
        while (matcher3.find()) {
            System.out.println("Найдено совпадение: " + matcher3.group());
        }

        Pattern pattern4 = Pattern.compile("Job4j");
        String text4 = "Job4j1 и Job4j2 и Job4j3";
        Matcher matcher4 = pattern4.matcher(text4);
        while (matcher4.find()) {
            System.out.println("Найдено совпадение. iStart: " + matcher4.start()
                    + " iEnd: " + matcher4.end());
        }
    }
}
