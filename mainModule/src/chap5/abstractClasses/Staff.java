package chap5.abstractClasses;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Jianghao Zhang on 2017/5/9
 */
public class Staff extends Person {
    private double salary;
    private Date hireday;

    public Staff(String n, double s, int year, int month, int day) {
        super(n);
        this.salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        this.hireday = calendar.getTime();
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireday() {
        return hireday;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        this.salary += raise;
    }

    @Override
    public String getDescription() {
        return String.format("An staff with a salary of $%.2f", salary);
    }
}
