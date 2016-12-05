package objectStream;

import java.io.*;

import byteStream.Book;




public class ObjectOSandObjectIS {

	public static void main(String[] args) {

	}
	//静态方法可以直接调用静态方法
	static void show(){
		ObjectInputStream objInput = null;
		FileInputStream  fInput = null;
		try {
			fInput = new FileInputStream("c:/test.txt");
			objInput = new ObjectInputStream(fInput);
			Book thisbook = (Book)objInput.readObject();
			System.out.println("书名"+thisbook.getBookName()+"\t"+"作者"+thisbook.getAuthor()+"\t"+"价格"+thisbook.getPrice());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				objInput.close();
				fInput.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
	}

}
