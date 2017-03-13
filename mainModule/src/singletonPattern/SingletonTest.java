package singletonPattern;

public class SingletonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
      Singleton s1= Singleton.getInstance();
      Singleton s2=Singleton.getInstance();
      System.out.println(s1==s2);
      System.out.println(s1.equals(s2));
	}

}
