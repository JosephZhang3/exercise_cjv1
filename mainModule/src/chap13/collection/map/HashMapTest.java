package chap13.collection.map;

import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Object> fooHashMap = new HashMap<>();


        // 添加数据
        fooHashMap.put("a", "hello");
        fooHashMap.put("b", 90);
        fooHashMap.put("c", true);
        fooHashMap.put("d", 9.65f);
        fooHashMap.put("e", new Book());
        // 删除某项数据
        fooHashMap.remove("b");
        // 删除所有数据
//        fooHashMap.clear();


        // 判断键是否在键值对中存在，然后按键查找数据
        if (fooHashMap.containsKey("d")) {
            System.out.println(fooHashMap.get("d"));
        }
        // 判断值是否在键值对中存在
        if (fooHashMap.containsValue(true)) {
            System.out.println("值true在键值对中存在");
        }


        // 显示所有的key
        Set allkeys = fooHashMap.keySet();
        for (Object allkey : allkeys) {
            System.out.println(allkey);
        }
        // 显示所有的value
        Collection values = fooHashMap.values();
        for (Object value : values) {
            System.out.println(value);
        }
        //显示所有的key-value对    实际存储在HashMap类的静态内部类Map.Entry中
        Set<Map.Entry<String, Object>> entrys = fooHashMap.entrySet();
        for (Map.Entry<String, Object> entry : entrys) {
            System.out.println("键-->" + entry.getKey());
            System.out.println("值-->" + entry.getValue());
        }


        // 遍历键，然后根据键获取值
        Set skeys = fooHashMap.keySet();
        Iterator sbowl = skeys.iterator();
        Collection svalues = fooHashMap.values();
        Iterator sbottle = svalues.iterator();
        for (int i = 0; i < fooHashMap.size(); i++) {
            while (sbowl.hasNext()) {
                System.out.println(sbowl.next() + "->" + sbottle.next());
            }
        }


        // 集合的长度
        System.out.println("集合的长度为：" + fooHashMap.size());


        /**
         * 来做一些有趣的尝试吧！
         */
        //首先，我们往entrySet()方法返回的集中添加键值对元素
        Set<Map.Entry<String, Object>> entriesSet = fooHashMap.entrySet();
//        entriesSet.add(new Map.Entry<String, Object>() {
//            private String key = "initial-k";
//            private Object value = "initial-v";
//
//            @Override
//            public String getKey() {
//                return key;
//            }
//
//            @Override
//            public Object getValue() {
//                return value;
//            }
//
//            @Override
//            public Object setValue(Object v) {
//                value = v;
//                return v;
//            }
//        });
        /**
         * 运行至上面的add()方法时会报如下错误：
         * Exception in thread "main" java.lang.UnsupportedOperationException
         * 不支持这样的操作
         * 原因是什么呢？嘿嘿
         * 别被欺骗了，HashMap类的entrySet()方法返回的entriesSet只是一个视图，并不是真正的数据结构Set（集）！当然就不支持add()操作咯。
         */


        //然后，我们来试验下删除 "a"<->"hello" 这个键值对
        entriesSet.remove(new Map.Entry<String, Object>() {
            private String key = "a";
            private Object value = "hello";

            @Override
            public String getKey() {
                return key;
            }

            @Override
            public Object getValue() {
                return value;
            }

            @Override
            public Object setValue(Object v) {
                value = v;
                return v;
            }
        });
        /**
         * debugger模式下我们查看变量，"a"<->"hello" 这个键值对确实被删除了
         * 说明针对Map.Entry的remove()操作是被支持的！在这里，视图支持删除操作，但是不支持添加操作。
         */

    }

}
