package ru.job4j.io;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private List<String> logs = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> readPhrases = readPhrases();
        Scanner scanner = new Scanner(System.in);
        boolean bool = false;
        System.out.println("Insert any phrase: ");
        String in = scanner.nextLine();
        logs.add(in);
        while (!OUT.equals(in)) {
            if (STOP.equals(in)) {
                bool = true;
            } else if (CONTINUE.equals(in)) {
                bool = false;
            }
            if (!bool) {
                String answer = readPhrases.get(new Random().nextInt(readPhrases.size()));
                System.out.println(answer);
                logs.add(answer);
            }
            in = scanner.nextLine();
            logs.add(in);
        }
        saveLog(logs);
    }

    private List<String> readPhrases() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            rsl = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            for (String lg : log) {
                writer.println(lg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/BotChatLog.txt", "./data/BotAnswers.txt");
        cc.run();
    }
}