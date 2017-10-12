package com.cjs.reflectionTest;

public class Test1 {
	public static void main(String[] args) {
		// if("word".equals(args[0])) {
		// 	Word word = new Word();
		// 	word.print();
		// }
		// if("excel".equals(args[0])) {
		// 	Excel excel = new Excel();
		// 	excel.print();
		// }

        try {
        	// System.out.println(args[0]);
			// System.out.println(args[1]);
        	Class c = Class.forName(args[1]);
        	Document document = (Document) c.newInstance();
        	document.print();
        } catch (Exception e) {
        	e.printStackTrace();
        }

        System.out.println(int.class == Integer.TYPE);
	}
}