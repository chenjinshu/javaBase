package com.cjs.collectionTest;

import java.util.*;

public class CollectionTest2 {

	public static void main(String[] args) {

		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("a", "123");
		hashMap.put("a", "456");
		System.out.println(hashMap.get("a"));
	}
}
