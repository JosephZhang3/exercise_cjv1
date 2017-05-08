package chap4;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author JianghaoZhang
 * @date 4/5/2017
 */
public class Employee {
    //The final instance field must be evaluated initial value.不可更改的实例域必须被赋予初始值。
    private final String birthday = "1994-04-08 00:00:00";
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
//        System.out.println(calendar.toString());
        this.hireday = calendar.getTime();
    }

    /**
     * 因为不需要给类的成员属性（实例域）设置值，在使用构造器创建这个类的对象实例时就给出了所有3个属性的值，所以没有加set()方法
     * 实际项目中以防万一使用无参或者少参的构造器，最好还是加上
     */
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireday() {
//        return hireday;
        //如果需要返回一个可变对象的引用，应该首先对它进行克隆clone。否则，对返回的引用进行一些操作可能会导致无意中改变被引用的对象。
        return (Date) hireday.clone();
    }

    public void raiseSalary(double byPercent) {
        this.salary *= (1 + byPercent / 100);
    }
}