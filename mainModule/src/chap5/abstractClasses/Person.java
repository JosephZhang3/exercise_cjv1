package chap5.abstractClasses;

/**
 * Created by Jianghao Zhang on 2017/5/8
 */
public abstract class Person {
    private String name;

    public Person(String n) {
        this.name = n;
    }

    public String getName() {
        return this.name;
    }

    public abstract String getDescription();
}
