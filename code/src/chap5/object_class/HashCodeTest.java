package chap5.object_class;

/**
 * 测试Object祖先类的hashCode方法
 * Created by Jianghao Zhang on 2017/5/11.
 */
public class HashCodeTest {
    public static void main(String[] args) {
        String s = "demo";
        StringBuilder sBuilder = new StringBuilder(s);
        StringBuffer sBuffer = new StringBuffer(s);
        System.out.println(s.hashCode() + "  " + sBuilder.hashCode());
        System.out.println(s.hashCode() + "  " + sBuffer.hashCode());

        System.out.println("");

        String t = new String("demo");
        StringBuilder tBuilder = new StringBuilder(t);
        StringBuffer tBuffer = new StringBuffer(t);
        System.out.println(t.hashCode() + "  " + tBuilder.hashCode());
        System.out.println(t.hashCode() + "  " + tBuffer.hashCode());

        /**
         * 字符串对象的散列码是根据  构成它的字符数组的内容  得到的，所以如果内容相同，那么哈希码也就一样。
         *
         * 而字符串缓冲对象的散列码是根据 字符串缓冲类继承的Object基类的默认hashCode()方法获取的对象的存储地址 得到，
         * 只要不是引用同一对象，那么哈希码就绝对不一样。
         */
    }
}
