package chap14.customer_producer_pattern;

public class Customer extends Thread {
    // 每次消费的产品数量
    private int num;

    // 所在放置的仓库
    private Storage storage;

    // 构造函数，设置仓库
    public Customer(Storage storage) {
        this.storage = storage;
    }

    // 线程run函数
    public void run() {
        consume(num);
    }

    // 调用仓库Storage的消费函数
    public void consume(int num) {
        storage.consume(num);
    }

    // get/set方法
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}