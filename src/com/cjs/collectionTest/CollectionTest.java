package com.cjs.collectionTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
        list.add("cjs");
        list.add("lq");
        list.add("llp");
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
        	System.out.println(it.next());
        }
	}

}
