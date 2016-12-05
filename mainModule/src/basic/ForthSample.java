package basic;

import java.util.Arrays;

public class ForthSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[10];
		// 创建一个数字数组时，所有的元素都被初始化为0
		System.out.println(array[5]);

		for (int i = 0; i < 10; i++) {
			array[i] = i;
		}
		System.out.println(array[5]);

		// 创建一个对象数组的元素，所有的元素都被初始化为null
		String[] str = new String[10];
		System.out.println(str[5]);
		for (int i = 0; i < 10; i++) {
			str[i] = "";
		}
		System.out.println(str[5]);

		// Java中，允许数组长度为0
		int[] null_array = new int[0];

		// 增强for循环
		for (int a : array) {
			System.out.println(a);
		}

		// 使用最简单的方式打印数组中的所有值，调用java.util包下的Arrays类的toString方法
		System.out.println(Arrays.toString(array));

		// 创建匿名数组，不能单独创建!必须放到语句中才行
		// 使用匿名数组最佳方式就是实现可变参数（以数组为参数）的方法中，它能够调用不同数量的参数
		System.out.println("The sum of first anonymous is:" + sum(new int[] { 1, 2, 3 }));
		System.out.println("The sum of first anonymous is:" + sum(new int[] { 1, 2, 3, 4, 5 }));


	}

	// 求数组所有元素的和
	public static int sum(int[] array) {
		int sum = 0;
		for (int a : array) {
			sum += a;
		}
		return sum;
	}

}
