package chap13.collection.map;

import java.util.*;

/**
 * 使用泛型的HashMap
 */
public class HashMapWithGeneric {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		Example first = new Example("001", "赵");
		Example second = new Example("002", "钱");
		Example third = new Example("003", "孙");
		Example fourth = new Example("004", "李");

		map.put(first.getMyid(), first.getMyname());
		map.put(second.getMyid(), second.getMyname());
		map.put(third.getMyid(), third.getMyname());
		map.put(fourth.getMyid(), fourth.getMyname());

		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		System.out.println("HashMap类实现的Map集合，无序：");
		while (it.hasNext()) {
			String id = it.next();
			String name = map.get(id);
			System.out.println(id + "\t" + name);
		}
	}
}
