package chain_of_responsibility.single_method;


import java.util.ArrayList;
import java.util.List;

public class InterceptorHandler<T> extends AbstractInterceptorHandler<T> {

    int index;// 当前执行到的拦截器的索引值

    private List<AbstractInterceptor<T>> interceptors;

    public InterceptorHandler(int index, List<AbstractInterceptor<T>> interceptors) {
        if (index < 0) {
            this.index = 0;
        }
        this.index = index;
        if (interceptors == null) {
            interceptors = new ArrayList<>();
        }
        this.interceptors = interceptors;
    }

    public List<AbstractInterceptor<T>> getInterceptors() {
        return interceptors;
    }

    @Override
    public void next(T data, int span) {
        if ((index + span) >= interceptors.size()) {
            return;
        }
        AbstractInterceptor<T> inc = interceptors.get(index + span);
        InterceptorHandler<T> kk = new InterceptorHandler<T>(index + (span + 1), interceptors);
        inc.intercept(data, kk);
    }
}
