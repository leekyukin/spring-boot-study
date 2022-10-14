package com.kyukin.thejava.ch1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMain2 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        // 필드 값 변경
        Class<?> bookClass = Class.forName("com.kyukin.thejava.ch1.Book");
        Constructor<?> constructor  = bookClass.getConstructor(String.class);
        Book book = (Book) constructor.newInstance("myBook");
        System.out.println(book);

        // public filed 값 변경
        Field a = bookClass.getField("A");
        System.out.println(a.get(null));
        a.set(null, "AAAAAA");
        System.out.println(a.get(null));

        // private filed 값 변경
        // getDeclaredFiled: private 필드도 가져올 수 있음
        Field b = bookClass.getDeclaredField("B");
        b.setAccessible(true);
        System.out.println(b.get(book));
        b.set(book, "BBBBBBB");
        System.out.println(b.get(book));

        // private method 호출
        Method c = Book.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book); // 실행

        // 파라미터 있는 public method 호출
        Method d = Book.class.getMethod("sum", int.class, int.class);
        int invoke = (int)d.invoke(book, 1, 2);
        System.out.println(invoke);
    }
}
