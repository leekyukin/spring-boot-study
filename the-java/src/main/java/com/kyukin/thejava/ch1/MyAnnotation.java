package com.kyukin.thejava.ch1;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD  })
@Inherited // 어노테이션 상속가능
public @interface MyAnnotation {

    String name() default "이규진";

    int age() default 17;
}
