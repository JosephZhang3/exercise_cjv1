package chap4;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author JianghaoZhang
 *         date 3/12/2017.
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