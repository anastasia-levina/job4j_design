package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private List<String> answers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void readFile() {
        answers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            br.lines().forEach(answers::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(List<String> dialogue, String path) {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(path))) {
            dialogue.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getBotAnswers() {
        return answers.get(new Random().nextInt(answers.size()));
    }

    public void run() {
        readFile();
        List<String> chat = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи любое слово или фразу: ");
        String phrase = sc.nextLine();
        chat.add(phrase);
        boolean next = true;
        while (!phrase.equals(OUT)) {
            if (phrase.equals(STOP)) {
                next = false;
            }
            if (phrase.equals(CONTINUE)) {
                next = true;
            }
            if (next) {
                String botAnswer = getBotAnswers();
                System.out.println(botAnswer);
                chat.add(botAnswer);
                System.out.println("Можешь продолжать: ");
            }
            phrase = sc.nextLine();
            chat.add(phrase);
        }
        writeFile(chat, path);
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("chapter_002/src/main/resources/dialogue.txt",
                "chapter_002/src/main/resources/botAnswers.txt");
        cc.run();
    }
}