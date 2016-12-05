package singletonPattern;

public class Singleton {
	// 使用一个类的成员变量缓存曾经创建过的实例
	private static Singleton instance;

	// 使用private修饰，隐藏该构造器
	private Singleton() {
	}

	//在调用该方法之前还不存在对象，因此调用该方法的必须是类，所以要用static修饰
	// 如果没有创建过Singleton实例，使用构造器new一个后返回。如果已经创建过了Singleton实例，返回已经存在了的Singleton实例
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
