package javadoc_usage;

import chap13.collection.map.Book;

public class Normal {

    /**
     * 从函数 {@link  chap3.ArrayTest#sum(int[])} 中可以看到求和过程
     *
     * @param id  ID
     * @param ids 不定长参数
     * @return 名称
     * @see chap3.ArrayTest
     * @see java.util.ArrayList
     */
    private String getName(String id, String... ids) {
        return "foo";
    }
}
