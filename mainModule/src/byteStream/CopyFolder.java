package byteStream;

import java.io.*;

//复制文件夹（考虑文件夹中还存在文件夹的情况）
public class CopyFolder {
	public static void main(String[] args) {

		// 给出被复制的文件夹的路径&粘贴后形成的文件夹的路径
		String sourcePath = "c:\\test";
		String aimPath = "d:\\test";
		File inputFolder = new File(sourcePath);
		File outputFolder = new File(aimPath);

		// 如果源文件夹不存在，报错
		if (!inputFolder.exists()) {
			System.out.println(inputFolder+ "源文件夹路径错误！！！");
			// 如果存在则把源文件夹路径和目标文件夹路径都打印出来
		} else {
			System.out.println("源文件夹路径" + inputFolder);
			System.out.println("目标文件夹路径" + outputFolder);
			System.out.println();
			// 只有确认源文件夹存在了之后，才能调用copy方法 ,静态方法可以直接调用静态方法
			copy("c:\\test", "d:\\test");
		}
	}

	public static void copy(String sourcePath, String aimPath) {

		File inputFolder = new File(sourcePath);
		File outputFolder = new File(aimPath);
		/*
		 * 如果目标文件夹不存在则创建（第一次调用时可能已经存在也可能不存在，之后的每次调用因为是子文件夹所以肯定不存在），
		 * 源文件夹每次调用肯定存在，不用判断
		 */
		if (!outputFolder.exists()) {
			outputFolder.mkdirs();
		}
		// 为源文件夹下的所有成员（可能是文件也可能是文件夹）创建集合
		File files[] = inputFolder.listFiles();
		// 遍历集合
		for (File theObject : files) {
			// 如果遍历到的是文件，复制该文件到目标位置
			if (theObject.isFile()) {

				System.out.println("本次复制的文件名称为：" + theObject.getName());
				System.out.println("粘贴到的目标路径为：" + aimPath);
				System.out.println();

				FileInputStream filIn = null;
				BufferedInputStream bufIn = null;
				FileOutputStream filOut = null;
				BufferedOutputStream bufOut = null;
				byte data[] = new byte[1024];
				try {
					filIn = new FileInputStream(theObject);
					bufIn = new BufferedInputStream(filIn);

					// 给出粘贴到的目标位置（形成的文件的绝对路径）
					File thisFile = new File(aimPath + "\\"
							+ theObject.getName());

					filOut = new FileOutputStream(thisFile);
					bufOut = new BufferedOutputStream(filOut);
					// 边读边写，注意：调用read方法和write方法都要添加data参数！！
					while (bufIn.read(data) != -1) {
						bufOut.write(data);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						bufIn.close();
						filIn.close();
						bufOut.close();
						filOut.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				// 如果遍历到的是文件夹,再次调用自身
			} else {
				copy(sourcePath + "\\" + theObject.getName(), aimPath + "\\"
						+ theObject.getName());
			}
		}
	}

}
