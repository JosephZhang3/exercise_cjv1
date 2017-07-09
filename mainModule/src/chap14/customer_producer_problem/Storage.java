package chap14.customer_producer_problem;

import java.util.LinkedList;

public class Storage {
	// 仓库最大存储量
	private final int MAX_SIZE = 10;

	// 仓库存储的载体
	private LinkedList<Object> list = new LinkedList<Object>();

	// 生产num个产品(入库)
	public void produce(int num) {
		// 同步代码块
		synchronized (list) {
			// 如果仓库剩余容量不足
			while (list.size() + num > MAX_SIZE) {
				System.out.println("【要生产的产品数量】:" + num + "\t【库存量】:"
						+ list.size() + "\t暂时不能执行生产任务!");
				try {
					// 由于条件不满足,list资源处于等待状态
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// 仓库剩余容量充足的情况下，生产num个产品
			for (int i = 1; i <= num; ++i) {
				list.add(new Object());
			}
			System.out.println("【已经生产产品数】:" + num + "\t【现仓储量为】:" + list.size());
			list.notifyAll();
		}
	}

	// 消费num个产品（出库）
	public void consume(int num) {
		// 同步代码段
		synchronized (list) {
			// 如果仓库存储量不足
			while (list.size() < num) {
				System.out.println("【要消费的产品数量】:" + num + "\t【库存量】:"
						+ list.size() + "\t暂时不能执行消费任务!");
				try {
					// 由于条件不满足，消费阻塞
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// 消费条件满足情况下，消费num个产品
			for (int i = 1; i <= num; ++i) {
				list.remove();
			}
			System.out.println("【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size());
			list.notifyAll();
		}
	}

	// get/set方法
	public LinkedList<Object> getList() {
		return list;
	}

	public void setList(LinkedList<Object> list) {
		this.list = list;
	}

}
