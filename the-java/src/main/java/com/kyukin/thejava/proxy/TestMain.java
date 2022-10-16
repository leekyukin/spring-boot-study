package com.kyukin.thejava.proxy;

public class TestMain {
    public static void main(String[] args) {

//        BookService bookService = new DefaultBookService();

        BookService bookService = new BookServiceProxy(new DefaultBookService());

        Book book = new Book();
        book.setTitle("Spring");


        System.out.println("Start");
        bookService.rent(book);
        System.out.println("End");
    }
}
