package chap13.collection.map;

import java.util.*;

public class HashMapWithoutGeneric {
	public static void main(String[] args) {
		Map hmDemo = new HashMap();
		// 添加数据
		hmDemo.put("a", "hello");
		hmDemo.put("b", 90);
		hmDemo.put("c", true);
		hmDemo.put("d", 9.65f);
		hmDemo.put("e", new Book());

		// 删除某项数据
		hmDemo.remove("b");
		// 删除所有数据
		hmDemo.clear();

		// 按键查找数据
		if (hmDemo.containsKey("d")) {
			System.out.println(hmDemo.get("d"));
		}
		// 按值查找数据
		if (hmDemo.containsValue(true)) {
			System.out.println(hmDemo.get("c"));
		}

		// 集合的数据显示

		// 显示所有的key
		Set allkeys = hmDemo.keySet();
		Iterator bowl = allkeys.iterator();
		while (bowl.hasNext()) {
			System.out.println(bowl.next());
		}

		// 显示所有的value
		Collection values = hmDemo.values();
		Iterator bottle = values.iterator();
		while (bottle.hasNext()) {
			System.out.println(bottle.next());
		}

		// 循环键从而显示值
		Set skeys = hmDemo.keySet();
		Iterator sbowl = skeys.iterator();
		Collection svalues = hmDemo.values();
		Iterator sbottle = svalues.iterator();
		for (int i = 0; i < hmDemo.size(); i++) {
			while (sbowl.hasNext()) {
				System.out.println(sbowl.next() + "->" + sbottle.next());
			}
		}
		// 统计集合的长度
		System.out.println("集合的长度为：" + hmDemo.size());
	}

}
