package printwriter;

import java.io.*;

public class PrintWriterDemo {
	public static void main(String[] args) {
		PrintWriter pW = null;
		FileWriter fW = null;
		try {
			/*
			 * 注意：PrintWriter的write和print方法默认直接覆盖目标文件中原有的内容！！PrintWriter的构造方法中的参数不仅可以是file
			 * ,filename,这里不能自动刷新缓冲区；还可以是FileWriter或者FileOutputStream，使用true就 可以避免将之前传输的内容覆盖
			 * 查看API文档，最好的两种构造方法如下
			 * PrintWriter(OutputStream out ,boolean autoflush) 通过现有的OutputStream 创建新的可自动刷新的PrintWriter
			 * PrintWriter(Writer out,boolean autoflush) 通过现有的 Writer 创建新的可自动刷新的 PrintWriter
			 */
			fW = new FileWriter("c:/test.txt");
			pW = new PrintWriter(fW, true);

			pW.write("this is the transport by pW");
			pW.write("this is the second line ");

			pW.print("use println method");
			pW.print("...........");

			pW.println(true);
			pW.println(3.1415926);
			Book object = new Book("中国", "张江浩", 20);
			pW.println(object);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pW.close();
				fW.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
