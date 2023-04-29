package chain_of_responsibility.single_method;

/**
 * 单方法版本的拦截器的抽象定义
 *
 * @param <T>
 */
public abstract class AbstractInterceptor<T> {
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public abstract void intercept(T data, InterceptorHandler<T> handlerSingle);
}
