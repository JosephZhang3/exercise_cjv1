package byteStream;

import java.io.*;
public class BufferedOutputSteamDemo {

	public static void main(String[] args) {
		FileOutputStream out = null;
		BufferedOutputStream bs = null;
		try{
			//true表示接着文件尾继续写入，不写表示直接覆盖
			out = new FileOutputStream("c:/test.txt",true);
			//只要大于等于缓冲区，就能全部写进去
			bs = new BufferedOutputStream(out,3);
			String content = "at the moment ";
			bs.write(content.getBytes());
			//刷新缓冲区
			//bs.flush();
		}catch(Exception E){
			E.printStackTrace();
		}finally{
			try {
				//先清空缓冲区，再拆除管道
				bs.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
