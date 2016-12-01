package basic;

import java.util.ArrayList;

public class LearnObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// PrintStream类的设计者并没有覆盖Object类的toString方法
		System.out.println(System.out);

		ArrayList<Integer> count = new ArrayList<>();
		// 如果已经估计出可能存储的元素的数量，可以预设容量
		count.ensureCapacity(100);

		// 将所有元素添加进数组列表（灵活地扩展数组）
		for (int i = 0; i < 10; i++) {
			// autoboxing自动装箱,count.add(i) 等效于 count.add(Integer.valueOf(i))
			// 自动拆箱示例 int n = count.get(i) 等效于 int n = count.get(i).intValue()
			count.add(i);
		}
		Integer[] intList = new Integer[count.size()];
		// 将所有的数组元素拷贝到一个数组中（方便地访问数组元素，用数组下标而不是调用数组列表的方法）
		count.toArray(intList);
		for (int i = 0; i < intList.length; i++) {
			System.out.println(intList[i]);
		}
	}

}
