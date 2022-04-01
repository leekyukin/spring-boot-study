package com.kyukin.springPractice.service;

import com.kyukin.springPractice.logic.BubbleSort;
import com.kyukin.springPractice.logic.JavaSort;
import com.kyukin.springPractice.logic.Sort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortService {

    private final Sort<String> sort;

    public SortService(@Qualifier("bubbleSort") Sort<String> sort) {
        this.sort = sort;
    }

    public List<String> doSort(List<String> list) {
        return sort.sort(list);
    }
}
