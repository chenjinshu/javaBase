package com.cjs.collectionTest;

import javax.jnlp.IntegrationService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionTest1 {
    public static void main(String[] args) {
        // 数组转集合最高效的方法。
        Integer[] arr = {4,3,7,5,9};
        List<Integer> list = new ArrayList<>(arr.length);
        Collections.addAll(list, arr);
    }
}
