package chap12;

/**
 * 简单泛型（generic type）测试
 */
public class PairTest {
	public static void main(String[] args) {
		Pair<String> p = ArrayAlgo.findMinMax(new String[] { "a", "c", "f", "fe", "X" });
		System.out.println(p.getFirst() + "\t" + p.getSecond());
	}
}

class ArrayAlgo {
	static Pair<String> findMinMax(String[] a) {
		if (a == null || a.length == 0) {
			return null;
		}
		String min = a[0];
		String max = a[0];

		for (String s : a) {
			if (s != null) {
				if (s.compareTo(min) < 0) {
					min = s;
				}
				if (s.compareTo(max) > 0) {
					max = s;
				}
			}
		}
		return new Pair<>(min, max);
	}
}