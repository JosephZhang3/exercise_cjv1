package chap5.abstract_class;

/**
 * 抽象类及其子类
 * Created by Jianghao Zhang on 2017/5/8.
 */
public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];
        people[0] = new Staff("Harry Potter", 4500, 1988, 5, 8);
        people[1] = new Student("John Douglas", "computer science", 1998, 5, 9);

        for (Person p : people) {
            System.out.println(p.getName() + " is " + p.getDescription() + ".");
        }
    }
}
