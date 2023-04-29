package chain_of_responsibility.single_method;

public class InterceptorChain<T> {

    public InterceptorHandler<T> handlerSingle = new InterceptorHandler<>(0, null);

    void add(AbstractInterceptor<T> intc) {
        for (AbstractInterceptor<T> i : handlerSingle.getInterceptors()) {
            if (i.getType() == intc.getType()) {
                return;
            }
        }
        handlerSingle.getInterceptors().add(intc);
    }

    void delete(AbstractInterceptor<T> itc) {
        handlerSingle.getInterceptors().remove(itc);
    }

    void intercept(T data) {
        handlerSingle.next(data, 0);
    }
}
