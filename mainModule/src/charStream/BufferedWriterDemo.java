package charStream;

import java.io.*;

public class BufferedWriterDemo {
	public static void main(String[] args) {
		FileWriter filWriter = null;
		BufferedWriter bufWriter = null;
		try {
			filWriter = new FileWriter("c:/test.txt", true);
			bufWriter = new BufferedWriter(filWriter);
			bufWriter.write("hello");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bufWriter.close();
				filWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
