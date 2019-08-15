package com.cjs.test;

import com.cjs.util.ByteArrayConverterUtils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author chen.jinshu (青禾)
 * 2019/01/10
 */
public class Test1 {

    public static void main(String[] args) throws Exception {
        Map<String, String> map = new ConcurrentSkipListMap<>();
        map.put("b", "cjs");
        map.put("a", "lq");
        map.put("c", "hqt");
        System.out.println(map);

        Map<String, String> map1 = new LinkedHashMap<>();
        map1.put("b", "cjs");
        map1.put("a", "lq");
        map1.put("c", "hqt");
        System.out.println(map1);
    }
}
