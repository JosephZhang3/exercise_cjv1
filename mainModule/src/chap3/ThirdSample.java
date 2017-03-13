package chap3;

import java.util.Scanner;

public class ThirdSample {

	enum Size {SMALL,MEDIUM,LARGE,EXTRA_LARGE};
	public static void main(String[] args) {
		/*
		// 控制流程，else子句与最邻近的if构成一组
		int x = 0;
		int sign = 1;
		if (x <= 0)
			if (x == 0)
				sign = 0;
			else
				sign = -1;
		System.out.println(sign);

		// 用switch语句是无法分范围判断的，只能用if else if else if ... else
		int sales = 1000;
		int target = 6000;
		int bonus = 0;
		String performance = null;
		if (sales >= 2 * target) {
			performance = "Excellent";
			bonus = 5000;
		} else if (sales >= 1.5 * target) {
			performance = "Fine";
			bonus = 3000;
		} else if (sales >= target) {
			performance = "satisfactory";
		} else {
			performance = "you are fired";
		}
		System.out.println("performance:" + performance + "    " + "bonus:" + bonus);

		// 利用循环语句计算多长时间才能存储一定数量的退休金
		// 账户当前存款
		double deposit = 0;
		// 年份计数
		int years = 0;
		// 目标存款
		int goal = 400000;
		// 每年存入的钱
		double payment = 60000;
		// 利率
		double interestRate = 0.015f;

		// while循环，如果不满足条件，循环体中的语句一次都不会执行
		while (deposit < goal) {
			deposit += payment;
			double interest = deposit * interestRate;
			deposit += interest;
			years++;
		}
		System.out.println(years);

		// do-while循环，循环体中的语句至少会执行一次
		Scanner in = new Scanner(System.in);
		String result = null;
		do {
			deposit += payment;
			double interest = deposit * interestRate;
			deposit += interest;
			years++;
			System.out.println("当前账户存款为：" + deposit);
			System.out.print("是否打算退休？（Y|N）:");
			result = in.next();
		} while ("N".equals(result));
		in.close();
		System.out.println("您的总退休金金额为：" + deposit);



		//如果把i!=10作为控制条件，会造成死循环，因为0.1无法精确地用二进制表示，会从
		//current i is:9.99999999999998
		//直接跳到
		//current i is:10.09999999999998
		for(double i = 0;i!=10;i+=0.1){
			System.out.println("current i is:"+i);
			if(i>10.2){
				break;
			}
		}


		//倒计数循，从10到0
		for(int m = 10;m>=0;m--){
			System.out.println("now countdown is:"+m);
		}

		//计算中奖概率,从1~n之间的数字中取k个数字
		//结果没办法用分数表示，因为1/2的结果为0,整数相除的结果还是整数。
		int n = 50;
		int k = 6;
		int probablity = 1;
		for(int i = 1;i<=k;i++){
			//probablity *= (n-i+1)/i  相当于  probablity = probablity * ((n-i+1)/i)
			//得出来的结果 not right,原因是整数*浮点数结果就变成了浮点数，而整数*整数再/整数结果还是整数
			probablity = probablity * (n-i+1) / i;
			System.out.println(probablity);
		}
		System.out.println(probablity);

		//多重选择switch语句。如果在case分支语句的末尾没有break语句，就会紧接着执行下一个case分支语句。这常常会引发错误,be careful
		//case标签可以是byte,short,int,char以及它们的包装类Byte,Short,Integer,Character
		Scanner in = new Scanner(System.in);
		System.out.print("enter a number form (1,2,3,4):");
		int choice = in.nextInt();
		switch(choice){
		case 1:
		    System.out.println(1);
		    break;
		case 2:
			System.out.println(2);
			break;
		case 3:
			System.out.println(3);
			break;
		case 4:
			System.out.println(4);
			break;
		default:
			System.out.println("the number you input is out of bound!");
			break;
		}


		//还可以是枚举常量enum
		//还可以是字符串字面量（从Java SE 7 开始）
		Size sz = Size.MEDIUM;
        switch(sz){
        case MEDIUM:
        	System.out.println("you are standard figure!");
            break;
        case SMALL:
        	System.out.println("you are so shin");
        	break;
        case LARGE:
        	System.out.println("you are too fat");
        	break;
        default:
        	System.out.println("There is no clothes for you !");
        	break;
        }


        //带标签的break语句：标签必须放在希望跳出的最外层循环之前
        Scanner num_in = new Scanner(System.in);
        int j = 1;
        get_data:
        	while(j<2){
        		for(int i =1;i<=2;i++){
        			System.out.print("Enter a number >= 0:");
        			int p = num_in.nextInt();
        			if(p<0)
        				break get_data;
        		}
        		j++;
        	}
        num_in.close();
        System.out.println("The circulating is finished");
        */

		//continue语句：将控制转移到‘最内层循环’的首部
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int p;
		int goal = 10;
		while(sum < goal){
			System.out.print("Enter a number >= 0:");
			p = sc.nextInt();
			if(p < 0)
				continue;
			sum+=p;
			System.out.println(sum);
		}
		sc.close();
	}
}




