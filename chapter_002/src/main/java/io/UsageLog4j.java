package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte num = 3;
        short num1 = 5;
        int num2 = 15;
        long num3 = 150;
        float num4 = 2.5F;
        double num5 = 130.5;
        boolean bool = true;
        char ch = 'c';
        LOG.debug("8 primitive types, which are divided into 4 groups (with examples):" + System.lineSeparator() +
                "1. Integers - byte : {}, short : {},  int : {}, long : {}, " + System.lineSeparator() +
                "2. Floating point numbers - float : {}, double : {}, " + System.lineSeparator() +
                "3. Boolean - boolean : {}," + System.lineSeparator() +
                "4. Character - char : {}", num, num1, num2, num3, num4, num5, bool, ch);
    }
}