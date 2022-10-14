package com.kyukin.thejava.ch2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerServiceTest {

     @Test
    public void getObject_BookRepository() throws Exception {
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertNotNull(bookRepository);
    }

    @Test
    public void getObject_BookService() {
         BookSerivce bookSerivce = ContainerService.getObject(BookSerivce.class);
         assertNotNull(bookSerivce);
         assertNotNull(bookSerivce.bookRepository);
    }
}