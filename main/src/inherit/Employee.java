package inherit;

import java.util.*;

/**
 * Created by zhangjianghao on 2016/1/12.
 */
public class Employee {
    private String name;
    private double salary;
    private Date hireday;

    /**
     * @param n     the employ's name
     * @param s     the employ' salary
     * @param year  the employ's hire year
     * @param month the employ's hire month
     * @param day   the employ's hire day
     */
    public Employee(String n, double s, int year, int month, int day) {
        this.name = n;
        this.salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        System.out.println(calendar.toString());
        hireday = calendar.getTime();
    }

    //因为不需要给类的属性设置值，在使用构造器创建这个类的对象实例时就给出了所有3个属性的值，所以没有加set()方法
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireday() {
        return hireday;
    }

    public void raiseSalary(double byPercent) {
        salary = salary * (1 + byPercent / 100);
    }
}
