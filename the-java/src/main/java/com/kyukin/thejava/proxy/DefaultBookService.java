package com.kyukin.thejava.proxy;

// 리얼 서브젝트
public class DefaultBookService implements BookService {

    BookRepository bookRepository;

    public void rent(Book book) {
        System.out.println("rent: " + book.getTitle());
    }
}
