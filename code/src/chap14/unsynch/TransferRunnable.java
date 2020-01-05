package chap14.unsynch;

import java.util.logging.Logger;

/**
 * 转账操作（用多线程的方式实现的）
 */
public class TransferRunnable implements Runnable {
    private Bank bank;
    private int fromAccountIndex;
    private double maxTransferAmount;
    private static final int DELAY = 10;

    /**
     * @param aBank              银行对象
     * @param aFromAccountIndex  转账来源帐户的索引
     * @param aMaxTransferAmount 最大转账金额
     */
    TransferRunnable(Bank aBank, int aFromAccountIndex, double aMaxTransferAmount) {
        bank = aBank;
        fromAccountIndex = aFromAccountIndex;
        maxTransferAmount = aMaxTransferAmount;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int toAccountIndex = (int) (bank.size() * Math.random());
                double amount = maxTransferAmount * Math.random();

                bank.transfer(fromAccountIndex, toAccountIndex, amount);
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException ie) {
            Logger.getGlobal().severe("发生了线程中断异常");
        }
    }
}
