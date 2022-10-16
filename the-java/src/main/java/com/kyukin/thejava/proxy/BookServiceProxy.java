package com.kyukin.thejava.proxy;

// 프록시
public class BookServiceProxy implements BookService {

    // proxy는 bookService를 가지고 있어야 함
    BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("프록시에서");
        bookService.rent(book);
        System.out.println("이런식으로 기능 변경도 가능함");
    }
}
