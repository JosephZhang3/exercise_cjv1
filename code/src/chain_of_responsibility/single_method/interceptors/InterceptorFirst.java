package chain_of_responsibility.single_method.interceptors;

import chain_of_responsibility.single_method.AbstractInterceptor;
import chain_of_responsibility.single_method.InterceptorHandler;

public class InterceptorFirst<T> extends AbstractInterceptor<T> {
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void intercept(T data, InterceptorHandler<T> handler) {
        System.out.println("1号拦截器数据 " + data + ", type is " + this.type);
        handler.next(data, 0);
    }

}
