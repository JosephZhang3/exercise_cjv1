package chap4;

/**
 * Java语言中的参数传递方式：按值传递
 *
 * @author JianghaoZhang
 *         date 3/13/2017
 */
public class ParamTest {
    public static void main(String[] args) {
        /**
         * Test1:method can't modify primitive type parameters.
         */
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before execute method:percent=" + percent);
        tripleValue(percent);
        System.out.println("After execute method:percent=" + percent);

        /**
         * Test2:method can change the state of object parameters.(by change the salary field)
         */
        System.out.println("\nTesting tripleSalaryField:");
        Officer cancy = new Officer("cancy", 4600);
        System.out.println("Before execute:salary=" + cancy.getSalary());
        tripleSalaryField(cancy);
        System.out.println("After execute:salary=" + cancy.getSalary());

        /**
         * Test3:method can't attach new objects to object's reference parameters.
         * Java中的方法都是“按值调用”，所以不能让对象引用和方法的对象引用参数产生联系。（参数仅仅是对象的引用的拷贝）
         */
        System.out.println("\nTesting swap object's references:");
        Officer a = new Officer("Alice", 3300);
        Officer b = new Officer("Bob", 5400);
        System.out.println("Before execute:a=" + a.getName());
        System.out.println("Before execute:b=" + b.getName());
        swap(a, b);
        System.out.println("After execute:a=" + a.getName());
        System.out.println("After execute:b=" + b.getName());
    }

    public static void tripleValue(double x) {
        x = 3 * x;
        System.out.println("End of method: x=" + x);
    }

    public static void tripleSalaryField(Officer officer) {
        officer.raiseSalary(200);
        System.out.println("End of method:salary=" + officer.getSalary());
    }

    public static void swap(Officer x, Officer y) {
        Officer temp = x;
        x = y;
        y = temp;
        System.out.println("End of method:x=" + x.getName());
        System.out.println("End of method:y=" + y.getName());
    }

}

class Officer {
    private String name;
    private double salary;

    public Officer(String n, double s) {
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
}
