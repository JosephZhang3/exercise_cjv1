package javadoc_usage;

public class Normal {

    /**
     * 函数 {@link  chap3.ArrayTest#sum(int[])} 演示了求和过程
     *
     * @param id  ID
     * @param ids 不定长参数
     * @return 名称
     *
     * @see chap3.ArrayTest
     * @see java.util.ArrayList
     *
     * @since 1.0
     */
    private String getName(String id, String... ids) {
        return "foo";
    }
}
