package chap5.enum_class;

/**
 * Created by Jianghao Zhang on 2017/5/15
 */
public enum Size {
    //刚好有3个实例，尽量不要使用new构造新对象！
    SMALL("S"), MEDIUM("M"), LARGE("L");

    private String abbreviation;//枚举常量值，对应"S"、"M"、"L"

    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

}
