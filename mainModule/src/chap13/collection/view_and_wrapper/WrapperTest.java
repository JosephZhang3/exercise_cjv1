package chap13.collection.view_and_wrapper;

import java.util.Arrays;
import java.util.List;

/**
 *
 */

//如下面被注释掉的代码所示，Arrays.asList(T)方法返回的是一个私有的静态内部类ArrayList对象（通过调用Arrays类中的构造方法ArrayList(E[] array){}），
//那么这个ArrayList对象当然是不可以被其它类的对象修改的。所以操作add()方法会报错UnsupportedOperationException

//private static class ArrayList<E> extends AbstractList<E>
//        implements RandomAccess, java.io.Serializable
//{
//    private static final long serialVersionUID = -2764017481108945198L;
//    private final E[] a;
//
//    ArrayList(E[] array) {
//        a = Objects.requireNonNull(array);
//    }

public class WrapperTest {

    public static void main(String[] args) {
        String[] wordArray = {"Java", "Collection", "wrapper"};
        List<String> wordList = Arrays.asList(wordArray);
        wordList.add("test add");//抛出异常UnsupportedOperationException
    }
}
