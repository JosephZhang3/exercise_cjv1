package chain_of_responsibility.single_method;

public abstract class AbstractInterceptorHandler<T> {
    abstract void next(T data, int span);
}
