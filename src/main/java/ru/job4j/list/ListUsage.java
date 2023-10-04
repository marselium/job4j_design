package ru.job4j.list;

import java.util.*;

public class ListUsage {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
        rsl.add("1");
        rsl.add("2");
        rsl.add("3");
        for (String res : rsl) {
            System.out.println(res);
        }
        System.out.println("----------------");
        rsl.add(1, "4");
        for (String res : rsl) {
            System.out.println(res);
        }
        System.out.println("----------------");
        List<String> rsl1 = List.of("1-1", "1-2", "1-3");
        rsl.addAll(rsl1);
        for (String res : rsl) {
            System.out.println(res);
        }
        System.out.println("----------------");
        List<String> rsl2 = new ArrayList<>();
        rsl2.add("2-1");
        rsl2.add("2-2");
        rsl2.add("2-3");
        rsl.addAll(1, rsl2);
        for (String res : rsl) {
            System.out.println(res);
        }
        System.out.println("----------------");
        for (int i = 0; i < rsl1.size(); i++) {
            System.out.println("Текущий элемент fori: " + rsl1.get(i));
        }
        System.out.println("----------------");
        Iterator<String> iterator = rsl2.iterator();
        while (iterator.hasNext()) {
            System.out.println("Текущий элемент iterator: " + iterator.next());
        }
        ListIterator<String> listIterator = rsl2.listIterator(2);
        while (listIterator.hasNext()) {
            System.out.println("Текущий элемент listIterator: " + listIterator.next());
        }
        System.out.println("----------------");
        rsl.set(1, "2-1-1");
        Iterator<String> rslIterator = rsl.iterator();
        while (rslIterator.hasNext()) {
            System.out.println("Текущий элемент rslIterator после set: " + rslIterator.next());
        }
        System.out.println("----------------");
        rsl.remove(2);
        for (String res : rsl) {
            System.out.println(res);
        }
        System.out.println("----------------");
        rsl.removeIf(s -> s.length() <= 3);
        for (int i = 0; i < rsl.size(); i++) {
            System.out.println("Текущий элемент fori: " + rsl1.get(i));
        }
        System.out.println("----------------");
        boolean b = rsl.contains("1");
        System.out.println("Список содержит элемент: " + b);
        int i = rsl.indexOf("2");
        System.out.println(i);
        int size = rsl.size();
        System.out.println("Размер списка равен: " + size);
    }
}
