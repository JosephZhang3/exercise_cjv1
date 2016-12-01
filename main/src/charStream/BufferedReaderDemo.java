package charStream;

import java.io.*;

//利用BufferedReader统计文本文件包含的行数和总字符个数，空格除外
public class BufferedReaderDemo {
	public static void main(String[] args) {
		FileReader fR = null;
		BufferedReader bR = null;
		try {
			fR = new FileReader("c:/test.txt");
			bR = new BufferedReader(fR);
			String data = null;
			char words[] = new char[1024];
			int allnum = 0;
			int line = 0;
			while ((data = bR.readLine()) != null) {
				words = data.toCharArray();
				for (char x : words) {
					if (x != ' ') {
						allnum++;
					}
				}
				line++;
			}
			System.out.println("该文本文件行数为：" + line);
			System.out.println("该文本文件的总字符数为：" + allnum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bR.close();
				fR.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
