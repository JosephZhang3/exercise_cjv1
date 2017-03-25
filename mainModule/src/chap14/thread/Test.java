package chap14.thread;

public class Test {
	public static void main(String[] args) {
		// 仓库对象
		Storage storage = new Storage();

		// 生产者对象
		Producer p1 = new Producer(storage);
		Producer p2 = new Producer(storage);
		Producer p3 = new Producer(storage);

		// 消费者对象
		Customer c1 = new Customer(storage);
		Customer c2 = new Customer(storage);
		Customer c3 = new Customer(storage);

		// 设置生产者产品生产数量
		p1.setNum(6);
		p2.setNum(2);
		p3.setNum(9);

		// 设置消费者产品消费数量
		c1.setNum(5);
		c2.setNum(8);
		c3.setNum(3);

		// 线程开始执行
		c1.start();
		c2.start();
		c3.start();
		p1.start();
		p2.start();
		p3.start();
	}
}

