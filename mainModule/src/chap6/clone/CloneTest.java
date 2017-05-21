package chap6.clone;

/**
 * 测试克隆机制的实现
 * Created by Jianghao Zhang on 2017/5/16.
 */
public class CloneTest {
    public static void main(String[] args) {
        Employee original = new Employee("Lincoln", 4800);
        original.setHireDay(2000, 1, 1);
        try {
            Employee copy = original.clone();
            copy.raiseSalary(15);
            copy.setHireDay(1998, 2, 2);

            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
