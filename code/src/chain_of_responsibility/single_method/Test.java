package chain_of_responsibility.single_method;

import chain_of_responsibility.single_method.interceptors.InterceptorFirst;
import chain_of_responsibility.single_method.interceptors.InterceptorSecond;

/**
 * 责任链模式实现拦截器器链，每个拦截器中仅有一个处理方法（仅实现一种责任）public void intercept(T data, InterceptorHandler<T> handler)
 */
public class Test {

    public static void main(String[] args) {
        InterceptorFirst<String> first = new InterceptorFirst<>();
        first.setType(1);

        InterceptorSecond<String> second = new InterceptorSecond<>();
        second.setType(2);

        InterceptorChain<String> ad = new InterceptorChain<>();
        ad.add(first);
        ad.add(second);

        ad.intercept("hi");
    }
}
