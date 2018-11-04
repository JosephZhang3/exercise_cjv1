package chap14.unsynch;

/**
 *
 */
public class UnsynchBankTest {

    private static final int N_ACCOUNTS = 100;
    private static final double INITIAL_BALANCE = 1000;

    public static void main(String[] args) {

        Bank b = new Bank(N_ACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < N_ACCOUNTS; i++) {
            TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }

    }
}
