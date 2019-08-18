package chap3;

public class TypeTransfer {

	public static void main(String[] args) {
		// 将字符串转换为基本数据类型
		System.out.println(Integer.parseInt("12"));
		System.out.println(Integer.valueOf("34"));

		// 将基本数据类型转换为字符串
		int num = 1234;
		String str = String.valueOf(num);
		System.out.println(str);

		int num2 = 5678;
		String str2 = "" + num2;
		System.out.println(str2);
	}

}
