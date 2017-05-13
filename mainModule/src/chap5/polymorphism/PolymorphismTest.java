package chap5.polymorphism;

/**
 * 测试继承和多态（polymorphism）特性
 * Created by Jianghao Zhang on 2017/5/13.
 */
public class PolymorphismTest {
    public static void main(String[] args) {
        Manager boss = new Manager("jack", 3500, 1992, 10, 30);
        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("tom", 2500, 1993, 12, 23);
        staff[2] = new Employee("cindy", 3000, 1995, 7, 2);

        for (Employee e : staff) {
            System.out.println("name:" + e.getName() + "\t" + "hireday:" + e.getHireday() + "\t" + "salary:" + e.getSalary());
        }
        System.out.println();

        //staff[0].setBonus(500);  这样调用是错误的，因为staff[0]声明的类型是Employee,而setBonus()不是Employee类的方法
        boss.setBonus(500);
        staff[1].raiseSalary(10);
        staff[2].raiseSalary(10);

        for (Employee e : staff) {
            System.out.println("name:" + e.getName() + "\t" + "hireday:" + e.getHireday() + "\t" + "salary:" + e.getSalary());
        }

        //控制台打印出了下面的数据,试着找出出现这样的salary的计算精度的原因
        //name:cindy	hireday:Sun Jul 02 00:00:00 CST 1995	salary:3300.0000000000005
        //额，int类型与double类型的值相乘，运算规则可能跟严格的数学不同~
    }
}