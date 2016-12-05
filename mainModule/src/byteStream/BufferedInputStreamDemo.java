package byteStream;
import java.io.*;
public class BufferedInputStreamDemo {

	public static void main(String[] args) {
		FileInputStream  input = null;
		BufferedInputStream bs = null;
		byte data[] = new byte[1024];
		try{
			input = new FileInputStream("c:/test.txt");
			bs = new BufferedInputStream(input);
			while(bs.read(data)!=-1){
				//将字节数组转换为字符串
				System.out.println(new String(data));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				bs.close();
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
