package chap13.collection.set;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * TreeSet ADT 是一种有序的集（无重复元素的已经排好序的集合）
 */
public class TreeSetTest {
    public static void main(String[] args) {

        /*
          如果不传递Comparator比较器对象给TreeSet的构造方法，那么当添加元素到集中时，TreeSet会根据元素FooItem对象的CompareTo()方法为所有元素按partNum部件数量排序
         */
        SortedSet<FooItem> productSet = new TreeSet<>();
        productSet.add(new FooItem("abc", 1234));
        productSet.add(new FooItem("def", 5678));
        productSet.add(new FooItem("ghi", 901));
        System.out.println(productSet);

        /*
          如果传递Comparator比较器对象给TreeSet的构造方法，那么当添加元素到集中时，TreeSet会根据Comparator比较器的Compare()方法为所有元素按description描述字符串的字典序排序，
          忽略掉元素FooItem对象的CompareTo()方法
         */
//        SortedSet<FooItem> productSetSortByDescription = new TreeSet<>(new Comparator<FooItem>() {
//            @Override
//            public int compare(FooItem o1, FooItem o2) {
//                String descriO1 = o1.getDescription();
//                String descriO2 = o2.getDescription();
//                return descriO1.compareTo(descriO2);//使用String类中定义的compareTo()方法
//            }
//        });

        /*lambada函数式写法，取代函数对象（匿名内部类）写法**/
        SortedSet<FooItem> productSetSortByDescription = new TreeSet<>((o1, o2) -> {
            String descriO1 = o1.getDescription();
            String descriO2 = o2.getDescription();
            return descriO1.compareTo(descriO2);//使用String类中定义的compareTo()方法
        });

        productSetSortByDescription.addAll(productSet);
        System.out.println(productSetSortByDescription);

        /*
          控制台打印

          [[description=ghi,partNum=901], [description=abc,partNum=1234], [description=def,partNum=5678]]
          [[description=abc,partNum=1234], [description=def,partNum=5678], [description=ghi,partNum=901]]
         */
    }
}

class FooItem implements Comparable<FooItem> {

    private String description;//描述
    private int partNum;//部件数量

    public FooItem(String aDescription, int aPartNum) {
        description = aDescription;
        partNum = aPartNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPartNum() {
        return partNum;
    }

    public void setPartNum(int partNum) {
        this.partNum = partNum;
    }

    @Override
    public String toString() {
        return "[description=" + description + ",partNum=" + partNum + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {//判断两个对象是否属于同一个类型
            return false;
        }
        FooItem anotherFooItem = (FooItem) obj;
        return Objects.equals(description, anotherFooItem.description) && (partNum == anotherFooItem.partNum);
    }

    /**
     * 覆盖Object父类的hashCode()方法，注意这是根类中的一个native方法，计算并返回对象的hash码
     * 这里根据FooItem对象的两个成员变量description和partNum的值计算其hash码
     *
     * @return hash value
     */
    @Override
    public int hashCode() {
        return Objects.hash(description, partNum);
    }

    @Override
    public int compareTo(FooItem another) {
        /*
          this.partNum比another.partNum小返回1
          this.partNum比another.partNum大返回-1
          this.partNum与another.partNum相等返回0
         */
        return Integer.compare(partNum, another.partNum);
    }
}
