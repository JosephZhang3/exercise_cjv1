package chap3;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *A tool to print out the calendar of month nowaday
 *@author zjh
 *@version 1.0
 */

public class SeventhSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		// 使用日历类
		GregorianCalendar calendar = new GregorianCalendar(2015, Calendar.JULY, 7);
		int month = calendar.get(calendar.MONTH);
		int weekday = calendar.get(calendar.DAY_OF_MONTH);
		System.out.println(month + " " + weekday);

		displayCalendar();
	}

	/**
	 * The effectual part.
	 * @return nothing
	 */
	public static void displayCalendar() {
		Locale.setDefault(Locale.ENGLISH);
		GregorianCalendar g = new GregorianCalendar();
		int today = g.get(Calendar.DAY_OF_MONTH);
		int month = g.get(Calendar.MONTH);
		g.set(Calendar.DAY_OF_MONTH,1);
		int weekday = g.get(Calendar.DAY_OF_WEEK);
		int firstDayOfWeek = g.getFirstDayOfWeek();

		int indentation = 0;
		while(weekday!=firstDayOfWeek){
			indentation++;
			g.add(Calendar.DAY_OF_MONTH, -1);
			weekday = g.get(Calendar.DAY_OF_WEEK);
		}

		String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
		do{
			System.out.printf("%4s",weekdayNames[weekday]);
			g.add(Calendar.DAY_OF_MONTH,1);
			weekday = g.get(Calendar.DAY_OF_WEEK);
		}while(weekday!=firstDayOfWeek);
		System.out.println();

		for(int i=1;i<=indentation;i++)
			System.out.print("    ");

		g.set(Calendar.DAY_OF_MONTH,1);
		do{
			int day = g.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3d",day);

			if(day==today){
				System.out.print("*");
			}else {
				System.out.print(" ");
			}

			g.add(Calendar.DAY_OF_MONTH,1);
			weekday = g.get(Calendar.DAY_OF_WEEK);
			if(weekday==firstDayOfWeek)
				System.out.println();
		}while(g.get(Calendar.MONTH)==month);

	}

}
