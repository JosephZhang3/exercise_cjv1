package chap14.unsynch;

/**
 * 以多线程的方式实现转账操作
 */
public class TransferRunnable implements Runnable {
    private Bank bank;
    private int fromAccountIndex;
    private double maxTransferAmount;
    private int DELAY = 10;

    /**
     *
     * @param aBank 银行对象
     * @param aFromAccountIndex 转账来源帐户的索引
     * @param aMaxTransferAmount 最大转账金额
     */
    public TransferRunnable(Bank aBank, int aFromAccountIndex, double aMaxTransferAmount) {
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

        }
    }
}
