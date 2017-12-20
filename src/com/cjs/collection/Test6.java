package com.cjs.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test6 {

	public static void main(String[] args) {
		
		Comparator<Cat> ageComparator = new Comparator<Cat>(){
			@Override
			public int compare(Cat c1, Cat c2) {		
				return c1.getAge() - c2.getAge();
			}
		};
		
		Comparator<Cat> weightComparator = new Comparator<Cat>(){
			@Override
			public int compare(Cat c1, Cat c2) {		
				return c1.getWeight() - c2.getWeight();
			}
		};
		
		List<Cat> catList = new ArrayList<>();	
		catList.add(new Cat(13, 24));
		catList.add(new Cat(8, 32));
		catList.add(new Cat(29, 18));
		catList.add(new Cat(5, 7));
		
		Collections.sort(catList, ageComparator);
		
		for(Cat cat : catList) {
			System.out.println(cat.getAge());
		}
		
		System.out.println("====================");
		
		Collections.sort(catList, weightComparator);
		
		for(Cat cat : catList) {
			System.out.println(cat.getWeight());
		}
	}
}
