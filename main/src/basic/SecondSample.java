package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class SecondSample {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		// 对文件进行读取
		Scanner in = null;
		try {
			in = new Scanner(Paths.get("C:\\Users\\zjh\\Desktop\\secondSample.txt"));
			if (in != null) {
				while (in.hasNextLine()) {
					System.out.println(in.nextLine());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			in.close();
		}

		// 对文件进行写入(print,write,append方法都会覆盖文件中所有原来的内容！)why???
		PrintWriter out = null;
		try {
			out = new PrintWriter("C:\\Users\\zjh\\Desktop\\secondSample2.txt");
			if (out != null) {
				out.println("this is the first line");
				out.println("this is the second line");
				out.println("...");
				System.out.println("finished");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

}
