package java8_new_feature.lambda.intftest;

import java.util.Date;

public class IntfTest {

    private void callFunctionalInterfaceMethod(FunctionalIntf functionalIntf, int i) {
        System.out.println("调用开始");
        functionalIntf.functionalMethod("hello", new Date());
        System.out.println(i);
        System.out.println("调用完成");
    }

    public static void main(String[] args) {
        IntfTest t = new IntfTest();
       /* t.callFunctionalInterfaceMethod(new FunctionalIntf() {
            @Override
            public void functionalMethod() {
                System.out.println("主体");
            }
        });*/

        //定义函数
        // 理解：把方法当函数用，非OOP，不需要先new然后用对象调用方法，
        // 而是把仅包含唯一函数的接口当成参数传递，接口即是函数的载体
        FunctionalIntf functionalIntf = (p1, p2) -> {
            System.out.println("打印字符串长度\t" + p1.length());
            System.out.println("打印日期的13位时间戳\t" + p2.getTime());
        };

        //调用函数
        t.callFunctionalInterfaceMethod(functionalIntf, 1);

        //class java8_new_feature.lambda.intftest.IntfTest$$Lambda$1/2003749087
        //函数式接口的类型是jvm动态生成的
        System.out.println(functionalIntf.getClass());

        //class java.lang.Object
        //所有函数式接口的父类都是Object，万物皆对象
        System.out.println(functionalIntf.getClass().getSuperclass());

        //interface java8_new_feature.lambda.intftest.FunctionalIntf
        //jvm动态生成的类中包含一个接口
        System.out.println(functionalIntf.getClass().getInterfaces()[0]);
    }
}
