package com.kyukin.thejava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {

        // 아래의 코드는 요구사항이 추가될 수록 복잡해진다.
        // 그래서 스프링에서는 AOP 인터페이스로 뜯어 고침
        // 아래의 또 다른 단점: 클레스는 적용 불가능 (인터페이스만 가능)
        BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class},
            new InvocationHandler() {
                //  리얼 서브젝트
                BookService bookService = new DefaultBookService();

                @Override       // 프록시에서 할 수행 정의하는 곳
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                    // rent()에만 프록시를 적용하고 싶을 떄
                    if (method.getName().equals("rent")) {
                        System.out.println("프록시에서 추가하고 싶은 추가 로깅입니다.");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("프록시에서 추가하고 싶은 추가 로깅입니다.");
                        return invoke;
                    }

                    return method.invoke(bookService, args);
                }
        });


       Book book = new Book();
       book.setTitle("spring");
       bookService.rent(book);
    }
}
