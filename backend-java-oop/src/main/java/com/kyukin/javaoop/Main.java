package com.kyukin.javaoop;

import com.kyukin.javaoop.logic.BubbleSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BubbleSort<String> sort = new BubbleSort<>();

        System.out.println("[result]" + sort.sort(Arrays.asList(args)));
    }
}
