package chap4;

/**
 * @author JianghaoZhang
 * @date 3/12/2017
 */
public class StaticTest {
    public static void main(String[] args) {
/*      System.out.println(Math.PI);
      Math.PI = 4.3333;//ERROR
      System.out = new PrintStream(new OutputStream() {
          @Override
          public void write(int b) throws IOException {

          }
      });//ERROR*/
        /**
         * The pow method of Math is a static method;
         * 因为pow()方法不需要访问对象的状态，需要的参数-->基数和幂，都是通过显式参数提供。
         */
        //System.out.print(Math.pow(5, 3));//output 125.0


        Worker[] staff = new Worker[3];
        staff[0] = new Worker("Tom", 4200);
        staff[1] = new Worker("Dick", 6700);
        staff[2] = new Worker("Benne", 11000);

        for (Worker e : staff) {
            e.setId();
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());
            //calls static method.
            //一般情况下，我们建议使用类名访问类的静态域或调用类的静态方法而不是通过对象
            System.out.println("The next available id is " + Worker.getNextId());//output  2  3  4
        }
    }
}

class Worker {
    private static int nextId = 1;

    private String name;
    private double salary;
    private int id;

    public Worker(String n, double s) {
        this.name = n;
        this.salary = s;
        this.id = 0;//0只是一个随便给的预置的初始值，每次调用setId()时都不会起任何作用。
    }

    public static int getNextId() {
        return nextId;//返回静态域
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = nextId;//set next available id to id.把可用的静态域（属于类而不属于实例对象）值赋给实例域。
        nextId++;
    }

    //unit test.
    public static void main(String[] args) {
        Worker e = new Worker("Harry", 5000);
        System.out.println(e.getName() + "  " + e.getSalary());
    }
}
