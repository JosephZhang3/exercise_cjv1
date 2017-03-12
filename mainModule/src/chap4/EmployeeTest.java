package chap4;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by JianghaoZhang on 3/12/2017.
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("zhangsan", 7500, 2017, 2, 23);
        staff[1] = new Employee("lisi", 5000, 2017, 1, 3);
        staff[2] = new Employee("wangwu", 1500, 2017, 3, 12);
        //raise every's salary by 5%
        for (Employee e : staff) {
            e.raiseSalary(5);
        }
        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireday=" + e.getHireday());
        }

        Employee harry = new Employee("harry", 3000, 2017, 8, 9);

        Date d = harry.getHireday();
        double oneYearInMilliSeconds = 365.25 * 24 * 60 * 60 * 1000;
        //Let's give harry one year of added seniority(资历).让哈利的入职时间提前一年（显然这么做是违规的）。
        d.setTime(d.getTime() - (long) oneYearInMilliSeconds);
        //when we haven't used clone() for 'hireday' instance field,print out unexpected result 'Mon Aug 08 18:00:00 CST 2016'
        //when we use,print out right result 'Wed Aug 09 00:00:00 CST 2017',we don't want to change object harry at all!
        System.out.println(harry.getHireday());
    }
}

class Employee {
    private String name;
    private double salary;
    private Date hireday;
    //The final instance field must be evaluated initial value.不可更改的实例域必须被赋予初始值。
    private final String birthday = "1994-04-08 00:00:00";

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
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public Date getHireday() {
//        return this.hireday;
        //如果需要返回一个可变对象的引用，应该首先对它进行克隆clone。否则，对返回的引用进行一些操作可能会导致无意中改变被引用的对象。
        return (Date) this.hireday.clone();
    }

    public void raiseSalary(double byPercent) {
        this.salary *= (1 + byPercent / 100);
    }
}