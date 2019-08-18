package chap5.equals;

/**
 * 对象相等性测试
 * Created by Jianghao Zhang on 2017/5/9.
 */
public class EqualsTest {
    public static void main(String[] args) {
        Employee alice1 = new Employee("Alice Adams", 7500, 1986, 5, 7);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alice Adams", 7500, 1986, 5, 7);
        Employee bob = new Employee("Bob Brandson", 5000, 1995, 8, 22);

        System.out.println("alice1 == alice2 ?  " + (alice1 == alice2));
        System.out.println("alice1 == alice3 ?  " + (alice1 == alice3));
        System.out.println("alice1.equals(alice3) ?  " + alice1.equals(alice3));
        System.out.println("alice1.equals(bob) ?  " + alice1.equals(bob));

        System.out.println("bob.toString()  " + bob.toString());

        Manager carl = new Manager("Carl Cracker", 11000, 1978, 11, 23);
        Manager boss = new Manager("Carl Cracker", 11000, 1978, 11, 23);
        boss.setBonus(3450);
        System.out.println("carl.equals(boss) ?  " + carl.equals(boss));//bonus域的值不一样！

        System.out.println("alice1.hashCode()  " + alice1.hashCode());
        System.out.println("alice3.hashCode()  " + alice3.hashCode());
        System.out.println("bob.hashCode()  " + bob.hashCode());
        System.out.println("carl.hashCode()  " + carl.hashCode());

        System.out.println("boss.toString()  " + boss);
    }
}
