import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class Test{
    //1. 根据年龄, 来打印出当前年龄的人是少年(低于18), 
    //青年(19-28), 中年(29-55), 老年(56以上) 
    public static void main1(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("请输入当前的年龄：");
        int age = scn.nextInt();
        if(age > 0 && age < 18) {
            System.out.println("是少年");
        } else if( age < 28) {
            System.out.println("是青年");
        } else if( age < 55) {
            System.out.println("是中年");
        } else if( age > 56){
            System.out.println("是老年");
        } else {
            System.out.println("您的输入有误 ");
        }
    }

    //2. 判定一个数字是否是素数/质数 (除过1和它本身外，不能被其它数整除)
    public static void main2(String[] args) {
        Scanner sca = new Scanner(System.in);
        System.out.print("请输入您要判断的数:");
        int num = sca.nextInt();
        for(int i = 2; i < num; i++) {
            if(num % i == 0) {
                //不是素数
                System.out.println("不是素数");
                return;
            }
        }
        //是素数
        System.out.println("是素数");
    }

    //3. 打印 1 - 100 之间所有的素数 
    public static void main3(String[] args) {
        System.out.println("素数有：");
        //第一层循环：遍历1-100的数字
        for(int num = 1; num <= 100; num++) {
            //第二层循环：遍历 除过1和所要判断数字本身的其它值
            for(int i = 2; i < num; i++) {
                if(num % i == 0) {
                    //不是素数
                    break;//到上一层循环
                } else {
                    //是素数
                    System.out.print(num + " ");
                    break;
                }
            }           
        }
    }

    //4. 输出 1000 - 2000 之间所有的闰年
    public static void main4(String[] args) {
        System.out.println("闰年有：");
        for(int year = 1000; year <= 2000; year++) {
            if(year % 4 == 0 && year % 400 != 0 || year % 100 == 0) {
                //是闰年
                System.out.print(year + " ");
            }
        }
    }

    //5. 输出乘法口诀表 
    public static void main5(String[] args) {
        //第一层循环：遍历乘法口诀表的行
        for(int i = 1; i < 10; i++) {
            //第二层循环：遍历乘法口诀表的列
            for(int j = 1; j < i; j++) {//第一行只打印一个
                System.out.print(j + " * " + i + " = " + j * i + "  ");
            }
            System.out.println();
        }
    }
}