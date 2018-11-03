package chap13.collection.view_and_wrapper;

import chap13.collection.map.Book;

import java.util.*;

/**
 * 集合框架中使用的包装器和视图
 */

//如下面被注释掉的代码所示，Arrays.asList(T)方法返回的是一个私有的静态内部类对象（通过调用Arrays类中的构造方法ArrayList(E[] array){}），但请注意这个对象不是真正的ArrayList对象，而只是一个简化了的版本，
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

public class ViewWrapperTest {

    public static void main(String[] args) {
        testArrayToList();
        testUnmodifiable();
        testBatchOperation();
    }

    /**
     * 测试将数组转换成列表
     */
    private static void testArrayToList() {
        String[] wordArray = {"Java", "Collection", "wrapper"};
        List<String> wordList = Arrays.asList(wordArray);
//        wordList.add("test add");//抛出异常UnsupportedOperationException
    }

    /**
     * 测试产生并使用不可修改的视图
     */
    private static void testUnmodifiable() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("JCP", "smith"));
        bookList.add(new Book("ALGORITHM", "tony"));
        bookList.add(new Book("INTERVIEW", "alice"));

        List<Book> unmodifiableList = Collections.unmodifiableList(bookList);
//        unmodifiableList.remove(1);//尝试删除ALGORITHM这本算法书，抛出异常UnsupportedOperationException

        unmodifiableList.get(1).setName("algorithm");//尝试把ALGORITHM这本书的名称变成小写，操作成功。记住：不可修改视图中包含的元素依然可以被修改。
    }

    /**
     * 测试批量操作
     */
    private static void testBatchOperation() {
        List<String> bookNameList = new ArrayList<>();
        bookNameList.add("JCP");
        bookNameList.add("ALGORITHM");
        bookNameList.add("INTERVIEW");
        Set<String> bookNameSet = new HashSet<>(bookNameList);

        List<String> otherBookNameList = new ArrayList<>();
        otherBookNameList.add("JQUERY");
        otherBookNameList.add("ALGORITHM");
        otherBookNameList.add("CSAPP");
        Set<String> otherBookNameSet = new HashSet<>(otherBookNameList);

        //retainAll()方法使用了交集运算，而不是使用循环查找两个集合中重复的元素，效率非常高。
        if (bookNameSet.retainAll(otherBookNameSet)) {
            for (String name : bookNameSet) {
                System.out.println("两个书架中重复的书籍有：" + name);
            }
        }

        /**
         * 将批操作应用于视图，代码会更加优雅
         */
        testBatchOnView();

        /**
         * 将批操作应用于子范围视图，通过缩小批操作的影响范围让代码更健壮安全
         */
        testBatchOnSubView();
    }

    private static void testBatchOnView(){

    }

    private static void testBatchOnSubView(){

    }
}
