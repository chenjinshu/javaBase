package com.cjs.streamTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BufferedReaderTest {

	public static void main(String[] args) {
		File file = new File("G:/EclipseWorkspace/javaBase/src/com/cjs/streamTest/bufferedReader.txt");
		try {
			FileReader reader = new FileReader(file);
			BufferedReader bfreader = new BufferedReader(reader);
			String line = null;
			while((line = bfreader.readLine()) != null) {
				System.out.println(line);
			}
			bfreader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
