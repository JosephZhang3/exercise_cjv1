import java.math.BigInteger;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class UseFinal {

    private final Foo foo = new Foo("one");

    private Foo otherFoo = new Foo("zzz");

    public static void main(String[] args) throws Throwable {
        UseFinal me = new UseFinal();
        // final 常量如果是一个对象的引用，那么这个对象的内部成员变量是可以被修改的
        me.foo.setName("two");
        System.out.println(me.foo.getName());

        Foo newFoo = new Foo("three");
        // 接上句注释，但是，禁止对final常量赋予新值。可以这么理解：final只作用于指针，对指针指向的内存块不起“写保护”作用。
//        me.foo = newFoo; // Cannot assign a value to final variable 'foo'

        final Foo otherFoo = new Foo("YYY");
        System.out.println(otherFoo.getName());

        // Long的最大值加一后会溢出变成最小值，参见 CSAPP 第 章第 节
        System.out.println(Long.MAX_VALUE + 1 == Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE + 2);
        System.out.println(Long.MAX_VALUE);
        System.out.println(new BigInteger("922337203685477580700").toString());// 存储任意大小的无限制的整型值

        System.out.println(me.hashCode());
        System.out.println(Integer.toHexString(me.hashCode())); // 十进制转十六进制
        System.out.println(me); // 如果不重写hashcode方法，打印对象的结果就是对象的hashcode值

        Scanner scanner = new Scanner(System.in);
        scanner.next();
        doNothing();
//        me.finalize();// 不要这样显式调用，GC会自动处理回收的
        scanner.next();

        TreeMap<String, Integer> demotree = new TreeMap<>(Comparator.naturalOrder());
        demotree.put("m", 13);
        demotree.put("a", 1);
        demotree.put("d", 4);
        demotree.put("z", 26);
        demotree.put("o", 15);
// 因为有序，所以可以截取从某个 key 开始，比这个 key 大或者小的子集
        // 当使用类库中的类时，先仔细查看文档，确定没有能满足自己需求的方法（或者组合运用的方法）之后，再自己手搓代码。现成的轮子能满足需求就不要自己重复造
        NavigableMap<String, Integer> result = demotree.tailMap("o", true);
        System.out.println(result);
    }

    private static void doNothing() {
        UseFinal u = new UseFinal();
        System.out.println(u.foo.getName());
    }

    @Override
    protected void finalize() {
        System.out.println("I am called");
    }
}

class Foo {
    private String name;

    public Foo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}