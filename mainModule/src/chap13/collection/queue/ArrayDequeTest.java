package chap13.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * 双端队列Deque的实现类，以数组方式实现
 * 双端队列有两种实现方式，另一种是链表，具体的实现类是LinkedList类；是的，你没看错，因为LinkedList implements List<E>, Deque<E>
 * <p>
 * ArrayDeque实现了Deque接口，而Deque接口又继承自Queue接口
 */
public class ArrayDequeTest {

    public static void main(String[] args) {
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(5);
        arrayDeque.addFirst(7);
        arrayDeque.addFirst(8);
        arrayDeque.add(20);//默认在队列尾部添加新元素
        arrayDeque.addLast(30);

        for (Integer i : arrayDeque) {
            System.out.println(i);
        }

        System.out.println(arrayDeque.getFirst());
        System.out.println(arrayDeque.getLast());

        /**删除首部第一个元素**/
        arrayDeque.removeFirst();
        /**删除尾部第一个元素**/
        arrayDeque.removeLast();

        System.out.println("执行出列操作前...");
        for (Iterator it = arrayDeque.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
        arrayDeque.pop();//把首部第一个元素丢出去，等价于removeFirst()方法
        System.out.println("执行出列操作之后...");
        for (Iterator it = arrayDeque.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }
}
