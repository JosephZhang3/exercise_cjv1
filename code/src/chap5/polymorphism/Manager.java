package chap5.polymorphism;

/*
 * Created by Jianghao Zhang on 2017/5/11.
 */
class Manager extends Employee {
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
}