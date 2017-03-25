package chap4;

import java.util.Random;

/**
 * @author JianghaoZhang
 * @date 3/16/2017
 */
public class ConstructorTest {
    public static void main(String[] args) {
        Clerk[] staff = new Clerk[3];
        
    }
}

class Clerk {
    private static int nextId;

    private int id;
    private String name = "";//initialize instance field
    private double salary;

    //static initialization block.静态初始化块
    static {
        Random generator = new Random();
        //set nextId to a random number between 0 and 9999
        nextId = generator.nextInt(10000);//返回一个0~10000-1之间的随机数
    }

    //object initialization block.对象初始化块
    {
        id = nextId;
        nextId++;
    }

    //three overloaded constructors
    //first
    public Clerk(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    //second
    public Clerk(double salary) {
        this("Clerk #" + nextId, salary);//调用第一个构造器
    }

    //third,the default constructor
    public Clerk() {
        //id is initialized in "object initialization block"
        //name is initialized to "".实例域name被初始化为空字符串。
        //salary not explicitly set,is initialized to 0.实例域salary没有被明确地设定，它被初始化为0。
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}