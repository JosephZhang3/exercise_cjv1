package chap5.object_class;

import chap5.abstract_class.Staff;

/**
 * 测试Object祖先类的toString方法
 * Created by Jianghao Zhang on 2017/5/11.
 */
public class ToStringTest {
    public static void main(String[] args) {
        Staff staff = new Staff("Harry Potter", 4500, 1988, 5, 8);

        System.out.println(staff.hashCode());//对象的十进制哈希码
        System.out.println(Integer.toHexString(staff.hashCode()));//对象的16进制哈希码
        //toString()方法的实现，是用  类名@对象的16进制哈希码  的形式表示一个对象变量的字面量
        System.out.println(staff.toString());
    }
}
