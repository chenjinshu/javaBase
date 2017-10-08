package com.cjs.enumTest;

public enum Color {
	RED("红色", 1),
	GREEN("绿色", 2),
	YELLOW("黄色", 3);
	
	private String name;
	private int index;
	
	private Color(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	public static String getName(int index) {
		for(Color color : Color.values()) {
			//System.out.println(Color.YELLOW.getName());
			if (color.getIndex() == index) {
				return color.getName();
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}
