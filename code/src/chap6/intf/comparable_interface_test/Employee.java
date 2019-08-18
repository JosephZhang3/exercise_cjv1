package chap6.intf.comparable_interface_test;

/**
 * Created by Jianghao Zhang on 2017/5/16
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String n, double s) {
        this.name = n;
        this.salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        this.salary *= (1 + byPercent / 100);
    }

    public int compareTo(Employee e) {
        return Double.compare(salary, e.salary);//以从大至小的顺序排序
    }
}