package chap14.unsynch;

import java.util.Arrays;

/**
 * 抽象出的银行类
 */
class Bank {
    private double[] accounts;//存放帐户余额的数组

    /**
     * 构造器
     *
     * @param n              帐户数量
     * @param initialBalance 为每个帐户设置的初始余额
     */
    Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * 转账功能
     *
     * @param from   转账来源帐户的索引
     * @param to     转账去向目标帐户的索引
     * @param amount 转账金额
     */
    void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) {
//            System.out.println("来源帐户余额不足以转账");
            return;
        }

//        System.out.print(Thread.currentThread());

        accounts[from] -= amount;
//        System.out.printf("\t%10.2f  from  %d  to  %d\t", amount, from, to);

        accounts[to] += amount;
        System.out.printf("银行所有账户的总余额为%10.2f", getTotalBalance());
        System.out.println();

        /**
         * 如果注释一些辅助的print语句，大约在15000多次transfer操作之后，所有帐户总余额才会出现讹误
         * 如果保留注释，非常快就会出现讹误。因为线程在处理耗时的打印操作时，可能有其它线程同时在修改accounts[from]或者accounts[to]的值
         */
    }

    /**
     * 获取银行所有账户的总余额
     *
     * @return double
     */
    private double getTotalBalance() {
        double sum = 0;
        for (double one : accounts) {
            sum += one;
        }
        return sum;
    }

    /**
     * 获取银行所有帐户的数量
     *
     * @return count
     */
    int size() {
        return accounts.length;
    }
}
