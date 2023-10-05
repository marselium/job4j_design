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
    }
}
