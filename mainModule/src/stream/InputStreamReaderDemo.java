package stream;

import java.io.*;

public class InputStreamReaderDemo {
	public static void main(String[] args) {
		FileInputStream fI = null;
		BufferedReader bR = null;
		try {
			fI = new FileInputStream("c:/test.txt");
			//本来构造BufferedReader是要使用FileReader的，但也可以用InputStreamReader将FileInputStream转化为FileReader
			bR = new BufferedReader(new InputStreamReader(fI));
			try {
				System.out.println(bR.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				bR.close();
				fI.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
