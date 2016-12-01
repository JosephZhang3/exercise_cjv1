package charStream;

import java.util.*;

//统计字符串中各字符出现的次数
public class CharCount {
	public static void main(String[] args) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		String str = "hellojavahellojava";
		char chars[] = str.toCharArray();
		for (char thechar : chars) {
			if (map.containsKey(thechar)) {
				int value = map.get(thechar);
				value++;
				map.put(thechar, value);
			} else {
				map.put(thechar, 1);
			}
		}
		Set<Character> set = map.keySet();
		Iterator<Character> it = set.iterator();
		while (it.hasNext()) {
			char thekey = it.next();
			System.out.println("字符：" + thekey + "\t" + "出现次数："
					+ map.get(thekey));
		}
	}
}
