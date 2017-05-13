package chap5.equals;

/**
 * Created by Jianghao Zhang on 2017/5/12
 */
public class Manager extends Employee {
    private double bonus;

    /**
     * @param n the employ's name
     * @param s the employ' salary
     */
    public Manager(String n, double s, int year, int month, int day) {
        super(n, s, year, month, day);
        this.bonus = 0;
    }

    public void setBonus(double b) {
        this.bonus = b;
    }

    //这里需要覆盖父类（职员类）的getSalary()方法，因为给子类（经理类）计算工资要考虑到奖金的因素
    @Override
    public double getSalary() {
        return super.getSalary() + this.bonus;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Manager manager = (Manager) obj;
        return bonus == manager.bonus;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 17 * new Double(bonus).hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + "[bonus=" + bonus + "]";
    }
}
