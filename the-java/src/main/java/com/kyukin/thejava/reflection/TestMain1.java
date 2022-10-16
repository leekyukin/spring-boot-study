package com.kyukin.thejava.reflection;

import java.util.Arrays;

public class TestMain1 {
    public static void main(String[] args) throws ClassNotFoundException {

        // 클레스 가져오는 법

        // 클레스는 .class로
        Class<Book> bookClass = Book.class;


        // 인스턴스는 getClass()로
        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        // FQCN는 Class.forName()으로
        Class<?> aClass1 = Class.forName("com.kyukin.thejava.reflection.Book");


        // 접근후 참조방법
        Arrays.stream(bookClass.getDeclaredFields())
                .forEach(System.out::println);
    }
}
