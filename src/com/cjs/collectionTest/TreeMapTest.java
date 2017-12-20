package com.cjs.collectionTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		TreeMap<String, String> treeMap = new TreeMap<>();
		treeMap.put("1", "cjs");
		treeMap.put("2", "lq");
		treeMap.put("3", "llp");
		treeMap.put("4", "zxl");
		
		Set<String> keySet = treeMap.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			System.out.println(treeMap.get(it.next()));
		}
		
		System.out.println("======================");
		
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("1", "cjs");
		hashMap.put("2", "lq");
		hashMap.put("3", "llp");
		hashMap.put("4", "zxl");
		
		Set<String> keySet1 = hashMap.keySet();
		Iterator<String> it1 = keySet1.iterator();
		while(it1.hasNext()) {
			System.out.println(hashMap.get(it1.next()));
		}
	}
}
