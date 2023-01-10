public class TestStaticVariable {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        StaticVariable sv = new StaticVariable();
        // 通过类的实例修改类静态属性的值
        sv.changeStaticVar(2);
        System.out.println(StaticVariable.a);

        // 通过类直接修改类静态属性的值
        StaticVariable.a = 4;
        System.out.println(StaticVariable.a);

        // 反射获取属性值
        System.out.println(sv.getClass().getField("a").getInt(null));
    }
}
