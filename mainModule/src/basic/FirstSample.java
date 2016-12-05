package basic;

import java.io.Console;
import java.util.Date;
import java.util.Scanner;

public class FirstSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		System.out.println(0x1.0p-3);// 使用16进制表示浮点数 why it is this result?????
		System.out.println(0.125);

		System.out.println(0 / 5);// 任何数除以0都会产生arithmeticException，整数被o除得到0
		System.out.println(0 / 0.532);// 浮点数被0除得到0.0

		int n = 123456789;
		float m = n;
		System.out.println(m);// m=1.23456792E8 产生了精度损失

		double x = 9.998;
		int y = (int) Math.round(x);// 对浮点数四舍五入返回的是float类型
		System.out.println(y);

		String word = "tough";
		String word2 = word.substring(1, 3);// 截取子串 ，t o u g h的索引分别是0 1 2 3
											// 4,起始索引为1，终止索引为3，终止的位置不算。
		System.out.println(word2);

		String through = "thr" + word.substring(1, 5);// 终止索引为5，就能把末尾的索引为4的字符截取到
		System.out.println(through);

		String scare = "mygod";
		String same = "mygod";
		String different = same.substring(0, 3) + "od";// 只有字符串常量是共享的，而+（拼接）或substring等操作产生的结果并不是共享的
		if (different == "mygod") {
			System.out.println("==");
		}

		// 大多数常用的Unicode字符使用一个代码单元就可以表示，辅助字符需要两个代码单元表示。
		// 一个字符就是一个代码点！一个代码点可能只有一个代码单元，也可能有两个代码单元
		// 代码单元数量
		int unitNum = word.length();
		System.out.println(unitNum);

		// 代码点数量（实际的长度），终止位置都不算进去的
		int codePointNum = word.codePointCount(0, word.length());
		System.out.println(codePointNum);

		// 返回位置i的代码单元
		char third = word.charAt(2);
		char last = word.charAt(4);
		System.out.println(third + "    " + last);

		// 得到第i个代码点
		int index = word.offsetByCodePoints(0, 3);
		int codePoint = word.codePointAt(index);
		System.out.println(codePoint);

		int g = 'g';
		System.out.println(g);

		// 遍历word字符串"tough"，依次查看每一个代码点的最好方法.(代码点和代码单元都是从0开始计数)
		for (int i = 0; i < word.codePointCount(0, word.length());) {
			int cp = word.codePointAt(i);
			// 如果这个代码点是“追加的，补充的”代码点（这个代码点包含两个代码单元），则跳过下一个代码点
			if (Character.isSupplementaryCodePoint(cp)) {
				i += 2;
				// 如果这个代码点只包含一个代码单元，则访问下一个代码点
			} else {
				i++;
			}
			System.out.println(cp);
		}

		// 实现回退操作（倒序遍历）
		for (int i = word.codePointCount(0, word.length()) - 1; i >= 0;) {
			// 判断第i个代码单元是否是“代理”，如果是代理，则跳过这个代码单元
			if (Character.isSurrogate(word.charAt(i))) {
				i--;
			}
			int cp = word.codePointAt(i);
			System.out.println(cp);
			i--;
		}

		// 等价于实现回退操作（正序遍历）
		for (int i = 0; i < word.codePointCount(0, word.length());) {
			if (Character.isSurrogate(word.charAt(i))) {
				i++;
			}
			int cp = word.codePointAt(i);
			System.out.println(cp);
			i++;
		}

		// 计算从1累加到1000的和
		int num = 0;
		for (int i = 1; i <= 1000; i++) {
			num += i;
		}
		System.out.println(num);

		// 读取“标准输入流”，需要构造一个Scanner对象，并与“标准输入流”System.in关联
		Scanner in = new Scanner(System.in);

		// 读取一行
		System.out.println("what is your name ？");
		String name = in.nextLine();
		// System.out.println(name);

		// 读取一个单词（以空格符作为分隔符）
		// String oneWord = in.next();
		// System.out.println(oneWord);

		// 读取一个整数
		System.out.println("How old are you ?");
		int age = in.nextInt();
		System.out.println("hi,"+name + "。next year,you will be " + (age+1));

		//关闭扫描接收器
		in.close();


		//从控制台读取密码
		Console cons =System.console();
		//Java要与Console进行交互，不总是能得到可用的Java Console类的。
		//一个JVM是否有可用的Console，依赖于底层平台和JVM如何被调用。
		//如果JVM是在交互式命令行（比如Windows的cmd）中启动的，
		//并且输入输出没有重定向到另外的地方，那么就我们可以得到一个可用的Console实例。
		//即如果在命令行而不是eclipse中编译运行这个程序，就能得到一个可用Console。
		if(cons==null){
			System.out.println("The console is unavilable.Java控制台("
					+ "实质上是调用windows的cmd控制台)不可用！");
			System.exit(0);
		}else{
		String userName = cons.readLine("user name:");
		char[] pwd = cons.readPassword("password:");

		System.out.print("The userName is "+userName+" and the password is ");
		//对密码进行处理后马上用一个填充值覆盖数组元素，但是不要在foreach循环中修改或者删除数组的元素
		//删除或者修改元素一定要根据索引下标，否则可能出错！
		for(int x = 0;x<pwd.length;x++){
			System.out.print(pwd[x]);
			pwd[x]='*';
		}
		System.out.println();
		System.out.print("The overwritten password is:");
		for(char n : pwd){
			System.out.print(n);
		}
		}
		*/

		//格式化输出（打印正数和负数的符号，添加分组分隔符，以小数点后两个字符的精度打印，浮点数）
		System.out.printf("%+,.2f",10000.0/3.0);
		//使用静态的String.format方法创建一个格式化的字符串，而不打印输出
		String formatMessage = String.format("Hi,%s。next year,you will be %d", "zjh", 22);
		System.out.println(formatMessage);

		//使用完整的日期和时间格式打印当前的日期和时间
		System.out.printf("%tc",new Date());

		System.out.println();
		//使用一个格式化的字符串  指出  要被格式化的参数索引。索引紧跟在%后面并以$终止。
		System.out.printf("%1$s %2$tB %2$te %2$tY年 %2$tH时%2$tM分%2$tS秒  %2$tZ","format date:",new Date());

		System.out.println();
		//可以使用<标志,重复使用前面格式说明中的参数索引
		System.out.printf("%1$s %2$tB %<te %<tY年 %<tH时%<tM分%<tS秒  %<tZ","format date:",new Date());


	}

}
