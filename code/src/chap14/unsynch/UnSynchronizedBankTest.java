package chap14.unsynch;

/**
 * 测试：未采取同步措施的银行账户间的转账操作
 */
public class UnSynchronizedBankTest {

    private static final int N_ACCOUNTS = 100;//账户数量
    private static final double INITIAL_BALANCE = 1000;//最初的余额

    public static void main(String[] args) {

        Bank b = new Bank(N_ACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < N_ACCOUNTS; i++) {
            TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }

    }
}
