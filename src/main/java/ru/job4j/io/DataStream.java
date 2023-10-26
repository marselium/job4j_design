package ru.job4j.io;

import java.io.*;

public class DataStream {
    public static void main(String[] args) {
        String path = "data/dataOutput.txt";
        String[] names = {"unit1", "unit3", "unit3"};
        int[] amount = {5, 7, 2};
        boolean[] checked = {true, false, true};

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(path));
             DataInputStream in = new DataInputStream(new FileInputStream(path))) {
            for (int i = 0; i < names.length; i++) {
                out.writeUTF(names[i]);
                out.writeInt(amount[i]);
                out.writeBoolean(checked[i]);
            }
            while (true) {
                String n = in.readUTF();
                int a = in.readInt();
                boolean c = in.readBoolean();
                System.out.println("Наименование: " + n + ", количество: " + a + ", проверен: " + c);
            }
        } catch (EOFException e) {
            System.out.println("Достигнут конец файла");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
