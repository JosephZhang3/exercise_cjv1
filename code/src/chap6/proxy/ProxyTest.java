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
 * 这个实例是JVM帮助生成的，不是你在代码中显式地new出来的
 * 目的：灵活性
 * <p>
 * JDK动态代理的特点：要求被代理类必须实现接口，只能对接口中的方法实现代理（即在调用接口中的方法时触发 handler 的 handle() ）
 */
public class ProxyTest {

    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            /*
              给每个Integer类型的对象创建一个追踪处理器（实质是一个代理对象）
              把追踪处理器handler与Integer实现的接口Comparable.class绑定，目的就是每次调用Integer类型对象的compareTo方法时，都让绑定的追踪处理器做一些事情。
              (实际上，在调用Integer类型对象的toString方法或者很多其他方法时，追踪处理器也同样做了一些事情)
             */
            InvocationHandler customHandler = new TraceHandler(value);
            // 3个参数：类加载器null表示默认、被代理类自身已经实现的interface class的数组 此处是 []{compare.class}、调用处理器
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, customHandler);
            // debug查看代理类型proxyClass的内部构造，实际上只有两个属性 name:com.sun.proxy.$Proxy0 和 reflectionData
            Class proxyClass = Proxy.getProxyClass(null, new Class[]{Comparable.class});
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

    private final Object target;// 调用的目标，你是要调用哪个对象？此处为Integer的实例对象，指定（构造）后就不可变

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
        // print targetInstance.methodName(args[1],args[2],args[3]...)
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