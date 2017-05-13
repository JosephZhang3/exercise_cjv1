package chap5.abstract_class;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Jianghao Zhang on 2017/5/9
 */
public class Student extends Person {
    private String major;
    private Date matriculateDay;

    public Student(String n, String m, int year, int month, int day) {
        super(n);
        this.major = m;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        this.matriculateDay = calendar.getTime();
    }

    public String getMajor() {
        return major;
    }

    public Date getMatriculateDay() {
        return matriculateDay;
    }

    @Override
    public String getDescription() {
        return "a student majoring in " + major;
    }
}
