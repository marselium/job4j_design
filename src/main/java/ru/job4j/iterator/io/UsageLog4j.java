package ru.job4j.iterator.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte byt = 127;
        char ch = 97;
        short num = 32767;
        int num1 = 32768;
        long num2 = 312342L;
        float num3 = 3232.32f;
        double num4 = 121212.12d;
        boolean bool = true;
        LOG.debug("byte : {}, char: {}, short - {}, boolean - {}", byt, ch, num, bool);
        LOG.debug("int : {}, long: {}, float - {}, double - {}", num1, num2, num3, num4);
    }
}