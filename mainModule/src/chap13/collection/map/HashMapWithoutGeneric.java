package chap13.collection.map;

import java.util.*;

public class HashMapWithoutGeneric {
    public static void main(String[] args) {
        Map<String, Object> hmDemo = new HashMap<>();


        // 添加数据
        hmDemo.put("a", "hello");
        hmDemo.put("b", 90);
        hmDemo.put("c", true);
        hmDemo.put("d", 9.65f);
        hmDemo.put("e", new Book());
        // 删除某项数据
        hmDemo.remove("b");
        // 删除所有数据
//        hmDemo.clear();


        // 判断键是否在键值对中存在，然后按键查找数据
        if (hmDemo.containsKey("d")) {
            System.out.println(hmDemo.get("d"));
        }
        // 判断值是否在键值对中存在
        if (hmDemo.containsValue(true)) {
            System.out.println("值true在键值对中存在");
        }


        // 显示所有的key
        Set allkeys = hmDemo.keySet();
        for (Object allkey : allkeys) {
            System.out.println(allkey);
        }
        // 显示所有的value
        Collection values = hmDemo.values();
        for (Object value : values) {
            System.out.println(value);
        }
        //显示所有的key-value对
        Set<Map.Entry<String, Object>> entrys = hmDemo.entrySet();
        for (Map.Entry<String, Object> entry : entrys) {
            System.out.println("键-->" + entry.getKey());
            System.out.println("值-->" + entry.getValue());
        }


        // 遍历键，然后根据键获取值
        Set skeys = hmDemo.keySet();
        Iterator sbowl = skeys.iterator();
        Collection svalues = hmDemo.values();
        Iterator sbottle = svalues.iterator();
        for (int i = 0; i < hmDemo.size(); i++) {
            while (sbowl.hasNext()) {
                System.out.println(sbowl.next() + "->" + sbottle.next());
            }
        }


        // 集合的长度
        System.out.println("集合的长度为：" + hmDemo.size());
    }

}
