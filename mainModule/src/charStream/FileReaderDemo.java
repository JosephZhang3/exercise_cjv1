package charStream;

import java.io.*;

public class FileReaderDemo {
	public static void main(String[] args) {
		FileReader fileReader = null;
		char data[] = new char[1024];
		try {
			fileReader = new FileReader("C:/test.txt");
			int len = 0;
			while ((len = fileReader.read(data)) != -1) {
				// 把（存放读取到的字符的data数组）中（下标从0到len的所有字符）转换为字符串
				String str = new String(data, 0, len);
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
