package chap5.enum_class;

import java.util.Scanner;

/**
 * 枚举类型的工作方式
 * Created by Jianghao Zhang on 2017/5/14.
 */
public class EnumTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size(SMALL/MEDIUM/LARGE):");
        String inputContent = in.next().toUpperCase();

        //使用枚举类不需要实例化过程，使用静态方法valueOf()，直接让s引用枚举类Size的实例Size.SMALL或Size.MEDIUM或Size.LARGE
        Size s = Enum.valueOf(Size.class, inputContent);
        System.out.println("size=" + s.toString());//获取枚举常量实例的名称，SMALL或MEDIUM或LARGE
        System.out.println("size=" + s);//等效于调用了s.toString()方法
        System.out.println("abbreviation=" + s.getAbbreviation());////获取枚举常量实例的值
        if (s == Size.LARGE) {
            System.out.println("Well,you have chose the 'large' specification.");
        }

        if (AuditState.UNAUDIT.getStatenum() == 1) {
            System.out.println(AuditState.UNAUDIT.toString() + "的标识是 " + AuditState.UNAUDIT.getStatenum());
        }
    }
}
