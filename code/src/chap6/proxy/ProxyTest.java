package chap6.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * TODO 很难理解的概念，多复习理解这个routine
 * 代理
 * 使用场景：编译时无法确定某个类需要实现哪些接口，希望在运行时动态地创建一个实现了若干指定接口的新类的实例。
 * 目的：灵活性
 */
public class ProxyTest {

    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            /*
              给每个Integer类型的对象创建一个追踪处理器
              然后创建一个代理对象proxy，把追踪处理器handler和接口Comparable.class绑定，目的就是每次调用Integer类型对象的compareTo方法时，都让追踪处理器做一些事情。
              (实际上，在调用Integer类型对象的toString方法或者很多其他方法时，追踪处理器也同样做了一些事情)
             */
            InvocationHandler handler = new TraceHandler(value);
            //3个参数：类加载器、接口数组、调用处理器
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            //查看代理类型构造，实际上只有name域和reflectionData反射数据    Class proxyClass = Proxy.getProxyClass(null,new Class[]{Comparable.class});
            elements[i] = proxy;//代理对象的类型是Object
        }

        Integer key = new Random().nextInt(elements.length) + 1;
//        Integer key = 90000;//二分查找不到的情况

        int result = Arrays.binarySearch(elements, key);

        if (result > 0) {
            System.out.println(elements[result]);
        }
    }

}

/**
 * 追踪代码执行过程的handler
 */
class TraceHandler implements InvocationHandler {

    private Object target;//调用的目标，你是要调用哪个对象？

    TraceHandler(Object target) {
        this.target = target;
    }

    /**
     * 定义代理对象调用方法时希望执行的动作
     *
     * @param proxy  代理对象
     * @param method （代理对象调用的）方法
     * @param args   （代理对象调用方法时传递的）参数
     * @return Object
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target + "." + method.getName() + "(");

        if (args != null && args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                if (i != 0) {
                    System.out.print(",");
                }
                System.out.print(args[i]);
            }
        }
        System.out.println(")");
        return method.invoke(target, args);
    }
}