package com.kyukin.thejava.di;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerServiceTest {

    @Test
    public void getObject_BookRepository() throws Exception {
        com.kyukin.thejava.di.BookRepository bookRepository = com.kyukin.thejava.di.ContainerService.getObject(com.kyukin.thejava.di.BookRepository.class);
        assertNotNull(bookRepository);
    }

    @Test
    public void getObject_BookService() {
         com.kyukin.thejava.di.BookSerivce bookSerivce = com.kyukin.thejava.di.ContainerService.getObject(com.kyukin.thejava.di.BookSerivce.class);
         assertNotNull(bookSerivce);
         assertNotNull(bookSerivce.bookRepository);
    }
}