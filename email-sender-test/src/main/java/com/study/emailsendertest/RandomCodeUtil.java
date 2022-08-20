package com.study.emailsendertest;

import java.util.Random;

public class RandomCodeUtil {

    static final int MIN = 97;
    static final int MAX = 122;
    static final int CODE_LENGTH = 16;
    static Random random = new Random();

    public static String issue() {
        return random.ints(MIN, MAX+1)
                .limit(CODE_LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
