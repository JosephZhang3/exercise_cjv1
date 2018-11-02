package chap13.collection.queue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * 优先级队列priority queue
 * feature:无论何时调用remove()方法，总是会获得最小的一个元素
 * application case（应用场景）：任务调度，每当启动一个新的任务，都把优先级最高（级数最小）的任务从队列中删除
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<GregorianCalendar> queue = new PriorityQueue<>();
        queue.add(new GregorianCalendar(2018, Calendar.NOVEMBER, 6));
        queue.add(new GregorianCalendar(2018, Calendar.NOVEMBER, 1));
        queue.add(new GregorianCalendar(2018, Calendar.NOVEMBER, 4));
        queue.add(new GregorianCalendar(2018, Calendar.NOVEMBER, 3));
        queue.add(new GregorianCalendar(2018, Calendar.NOVEMBER, 20));

        System.out.println("Iterating via elements...");
        for (GregorianCalendar day : queue) {
            System.out.println(day.get(Calendar.DAY_OF_MONTH));
        }
        System.out.println("Circularly removing elements...");
        while (!queue.isEmpty()) {
            //先删除1号这天，再删除3号这天，以此类推，最后删除20号。每次remove()都获取当前队列中最小的一个元素然后删除
            System.out.println(queue.remove().get(Calendar.DAY_OF_MONTH));
        }
    }
}
