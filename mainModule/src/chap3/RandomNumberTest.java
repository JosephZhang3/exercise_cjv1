package chap3;

import java.util.Arrays;

public class RandomNumberTest {

	public static void main(String[] args) {
		// args 命令行参数数组
//		if ("first".equals(args[0])) {
//			System.out.println("the first arg");
//		} else if ("error".equals(args[0])) {
//			System.out.println("error");
//		}
//		for (int i = 1; i < args.length; i++) {
//			System.out.print(args[i] + " ");
//		}
//		System.out.println("!");

		lottery();
	}

	// 从1~49中抽取6个数值，抽到的数值必须互不相同
	public static void lottery() {
		int k = 6;
		int n = 49;
		int[] nums = new int[n];
		//将1~49装入nums数组中
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}

		int[] result = new int[k];
		for (int i = 0; i < result.length; i++) {
			//得到从0到n-1之间的一个随机数
			int r = (int) (Math.random() * n);
			//用nums数组中随机的一个值填充至result数组中
			result[i] = nums[r];
			//用nums数组的最后一个值改写本次抽取到的值
			nums[r] = nums[n - 1];
			n--;
		}

		Arrays.sort(result);
		System.out.println(Arrays.toString(result));
	}
}
