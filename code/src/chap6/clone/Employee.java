package chap6.clone;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Jianghao Zhang on 2017/5/16
 */
public class Employee implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String n, double s) {
        name = n;
        salary = s;
        hireDay = new Date();
    }

    public void setHireDay(int year, int month, int day) {
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        this.salary *= (1 + byPercent / 100);
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {//直接抛掉异常不管
        //call Object.clone()  调用基类的克隆方法
        Employee cloned = (Employee) super.clone();
        //clone mutable fields 克隆可变的子对象
        cloned.hireDay = (Date) hireDay.clone();
        return cloned;
    }

    @Override
    public String toString() {
        return "Employee[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }
}
