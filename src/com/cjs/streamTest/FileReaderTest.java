package com.cjs.streamTest;

import java.io.File;
import java.io.FileReader;

public class FileReaderTest {

	public static void main(String[] args) {
		File file = new File("G:/EclipseWorkspace/JavaTest/src/com/cjs/streamTest/fileReader.txt");
        try {
			FileReader reader = new FileReader(file);
			char[] ch = new char[1024];
			int len = reader.read(ch);
			reader.close();
			System.out.println(new String(ch, 0, len));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
