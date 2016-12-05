package charStream;

import java.io.*;

public class FileWriterDemo {
	public static void main(String[] args) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("C:/test.txt", true);
			fileWriter.write("hello");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
