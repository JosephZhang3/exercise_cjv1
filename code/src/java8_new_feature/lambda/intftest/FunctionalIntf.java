package java8_new_feature.lambda.intftest;

import java.util.Date;

@FunctionalInterface
public interface FunctionalIntf {

    void functionalMethod(String p1, Date p2);

    @Override
    String toString();

    //如果继续声明t3抽象方法，编译器就会报错：Multiple non-overriding abstract methods found
    //发现了多个（超过一个）非覆写的抽象方法
//    void t3();
}

