package ru.job4j.generics;

import java.lang.reflect.ParameterizedType;
import java.util.*;

public class GenericUsage {
    public void printRsl(Collection<?> col) {
        for (Iterator<?> iterator = col.iterator();iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    public void printInfo(Collection<? extends Person> col) {
        for (Iterator<? extends Person> iterator = col.iterator();iterator.hasNext();) {
            Person next = iterator.next();
            System.out.println(next);
        }
    }

    public void adAll(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        for (Object line : list) {
            System.out.println("Текущий элемент: " + line);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        new GenericUsage().printRsl(list);
        System.out.println("------------");
        List<Person> per = List.of(new Person("name", 21, new Date(913716000000L)));
        new GenericUsage().printInfo(per);
        System.out.println("------------");
        List<Programmer> pro = List.of(new Programmer("name123", 23, new Date(913716000000L)));
        new GenericUsage().printInfo(pro);
        System.out.println("------------");
        List<? super Integer> list1 = new ArrayList<>();
        new GenericUsage().adAll(list1);
        GenericsClass<String, String> first = new GenericsClass<>("First key", "First value");
        System.out.println("Вывод в консоль: " + first);
        GenericsClass<Integer, String> second = new GenericsClass<>(12345, "Sec value");
        System.out.println("Вывод в консоль: " + second);
        System.out.println("------------");
        ArrayList<Float> listOfNumbers = new FloatList();
        Class actual = listOfNumbers.getClass();
        ParameterizedType type = (ParameterizedType) actual.getGenericSuperclass();
        System.out.println(type);
        Class parameter = (Class) type.getActualTypeArguments()[0];
        System.out.println(parameter);
        System.out.println("------------");

    }
}
