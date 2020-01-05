package chap5.equals;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * Created by Jianghao Zhang on 2017/5/11
 */
public class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    /**
     * 职员对象构造器
     *
     * @param n     姓名
     * @param s     月薪
     * @param year  入职年份
     * @param month 入职月份
     * @param day   入职日期 day of month
     */
    public Employee(String n, double s, int year, int month, int day) {
        this.name = n;
        this.salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
//        System.out.println(calendar.toString());
        this.hireDay = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date gethireDay() {
//        return hireDay;
        //如果需要返回一个可变对象的引用，应该首先对它进行克隆clone。否则，对返回的引用进行一些操作可能会导致无意中改变被引用的对象。
        return (Date) hireDay.clone();
    }

    public void raiseSalary(double byPercent) {
        this.salary *= (1 + byPercent / 100);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        //If the classes don't match,they can't be equal.
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        //Now we know the argument "obj" really references to an Employee object.
        Employee other = (Employee) obj;
        return Objects.equals(this.name, other.name)
                && this.salary == other.salary
                && Objects.equals(this.hireDay, other.hireDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}
