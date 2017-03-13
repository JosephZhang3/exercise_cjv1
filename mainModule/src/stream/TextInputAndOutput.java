package stream;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;

public class TextInputAndOutput {

	// 文本输入与输出
	public static void main(String[] args) {
		//以文本格式打印数字
		try {
			PrintWriter pwOut = new PrintWriter("C:\\test.txt");
			double salary = 75000;
			pwOut.println(salary);
			pwOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//以文本格式存储对象

	}

	public static void writeData(PrintWriter pwOut){

	}

}
