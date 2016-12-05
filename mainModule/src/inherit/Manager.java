package inherit;

/**
 * Created by zhangjianghao on 2016/1/12.
 */
public class Manager extends Employee {
    private double bonus;

    /**
     * @param n the employ's name
     * @param s the employ' salary
     */
    public Manager(String n, double s, int year, int month, int day) {
        super(n, s, year, month, day);
        bonus = 0;
    }

    public void setBonus(double b) {
        this.bonus = b;
    }

    //这里需要覆盖父类的getSalary()方法，因为给子类计算工资要考虑到奖金的因素
    public double getSalary() {
        return super.getSalary() + this.bonus;
    }
}
