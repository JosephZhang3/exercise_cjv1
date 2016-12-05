package byteStream;

import java.io.*;

//复制单个文件test.txt从c盘到d盘
public class CopyFile {
	public static void main(String[] args) {
		File thatFile = new File("c:/test.txt");
		// 判断源文件是否存在，存在才能copy
		if (thatFile.exists()) {
			// 判断目标盘中是否已有同名文件，如果有则删除后新建
			File thisFile = new File("d:/test.txt");
			if (thisFile.exists()) {
				thisFile.delete();
				try {
					thisFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				//没有则直接新建
			} else {
				try {
					thisFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			FileInputStream fili = null;
			BufferedInputStream bufi = null;
			FileOutputStream filo = null;
			BufferedOutputStream bufo = null;
			byte data[] = new byte[1024];
			try {
				fili = new FileInputStream("c:/test.txt");
				bufi = new BufferedInputStream(fili);
				filo = new FileOutputStream("d:/test.txt", true);
				bufo = new BufferedOutputStream(filo);
				// 使用字节流，所以要先创建byte型数组data[],将读到的字节放入data[]中
				while (bufi.read(data) != -1) {
					bufo.write(data);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					bufi.close();
					fili.close();
					bufo.close();
					filo.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else{
			System.out.println("源文件不存在！！！");
		}
	}
}
