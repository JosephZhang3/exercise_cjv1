package stream;

import java.io.*;

public class OutputStreamWriterDemo {
	public static void main(String[] args) {
		FileOutputStream fO = null;
		BufferedWriter bW = null;
		try {
			fO = new FileOutputStream("c:/test.txt",true);
			//本来构造BufferedWriter是要使用FileWriter的，但也可以用OutputStreamWriter将FileOutputStream转化为FileWriter
			bW = new BufferedWriter(new OutputStreamWriter(fO));
			try {
				bW.write("the output data");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				bW.close();
				fO.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}

}
