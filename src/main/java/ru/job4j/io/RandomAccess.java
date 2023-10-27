package ru.job4j.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess {
    public static void main(String[] args) {
        try {
            RandomAccessFile racf = new RandomAccessFile("data/random.txt", "rw");
            racf.writeInt(100);
            racf.writeChar('A');
            racf.writeBoolean(true);
            racf.seek(0);
            System.out.println(racf.readInt());
            System.out.println(racf.readChar());
            System.out.println(racf.readBoolean());
            racf.seek(4);
            System.out.println(racf.readChar());
            System.out.println(racf.getFilePointer());
            racf.seek(4);
            racf.writeChar('B');
            racf.seek(4);
            System.out.println(racf.readChar());
            racf.seek(racf.length());
            System.out.println("Положение указателя после boolean: " + racf.getFilePointer());
            racf.writeDouble(3.91);
            racf.seek(7);
            System.out.println(racf.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
