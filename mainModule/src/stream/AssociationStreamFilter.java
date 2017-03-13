package stream;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.util.zip.ZipInputStream;

//组合流过滤器
public class AssociationStreamFilter {

	public static void main(String[] args) {
		String separator = java.io.File.separator;
		// 使用程序所运行平台的文件分隔符
		String url = "C:" + separator + "test.txt";
		File file = new File(url);

		/*
		// FileInputStream没有任何读入数值类型的方法，DataInputStream没有任何从文件中获取数据的方法
		// FileInputStream获取字节，然后DataInputStream将字节组装到更有用的数据类型中
		FileInputStream fin = null;
		DataInputStream din = null;
		try {
			fin = new FileInputStream(file);
			din = new DataInputStream(fin);
			// 读取第一个字节的ASCII码
			// Byte d = din.readByte();

			// 读取第一个双精度浮点数，如果文件中并没有这样的数据，就会抛出EOFException异常
			// Double d = din.readDouble();
			// System.out.println(d);
			din.close();
			fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

		// 当多个流链接在一起时，需要跟踪中介流
		try {
			PushbackInputStream pbin = new PushbackInputStream(new BufferedInputStream(new FileInputStream(file)));
			// 读取下一个字节
			int b = pbin.read();
			if (b != 'x')
				// 如果读取到的并非是所期望的值，将其推回流中,继续读取下一个字节
				pbin.unread(b);
			else {
				System.out.println(b);
			}
			pbin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 如果希望不仅能预先浏览还能读入数字，可以构造一个既是可回退输入流(PushBackInputStream),又是数据输入流(DataInputStream)的构造器链
		try {
			PushbackInputStream pbin = new PushbackInputStream(new BufferedInputStream(new FileInputStream(file)));
			DataInputStream dain = new DataInputStream(pbin);

			int pb = 0;
			int sd = 0;
			// 如果PushbackInputStream因为当前读到的位置位于文件末尾而没有字节可用，则返回值 -1
			// 如果DataInputStream因为当前读到的位置位于文件末尾而没有字节可用，则返回值 -255
			while (pb != -1) {
				pb = pbin.read();
				if (pb == -1) {
					System.out.println("all of the data have been read !");
				} else if (pb == 'x') {
					System.out.println("This is the letter I wanna");
				} else {
					// 如果PushbackInputStream当前读取到的字节不是'x'，则回退到读取到的字节位置之前。让DataInputStream读取这个字节。
					pbin.unread(pb);
					sd = dain.read();
					System.out.println(sd);
				}
			}
			dain.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		*/
		String zipUrl = "C:" + separator + "test.zip";
		File zipFile = new File(zipUrl);
		//通过流序列从zip文件中读取数字
		try {
			ZipInputStream zin = new ZipInputStream(new FileInputStream(zipFile));
			DataInputStream dins = new DataInputStream(zin);
			int d = 0;
			while(d != -1){
				//为什么总是会返回-1？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
				d = dins.read();
				System.out.println(d);
			}
			dins.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
