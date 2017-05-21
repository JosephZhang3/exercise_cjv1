package chap6.intf.comparable_interface_test;

import java.util.Arrays;

/**
 * 按工资对员工进行排序
 * Created by Jianghao Zhang on 2017/5/16.
 */
public class ComparableInterfaceTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry", 3500);
        staff[1] = new Employee("Carl", 7500);
        staff[2] = new Employee("Tony", 4200);

        Arrays.sort(staff);

        for (Employee e : staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }
    }
}