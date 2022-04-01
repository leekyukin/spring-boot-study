package com.kyukin.springPractice;

import com.kyukin.springPractice.config.Config;
import com.kyukin.springPractice.logic.JavaSort;
import com.kyukin.springPractice.logic.Sort;
import com.kyukin.springPractice.service.SortService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Sort<String> sort = context.getBean(Sort.class);

        SortService sortService = context.getBean(SortService.class);

        System.out.println("[result]" + sort.sort(Arrays.asList(args)));
    }
}
