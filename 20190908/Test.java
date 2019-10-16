import java.util.Scanner;




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

    //6. 求两个正整数的最大公约数 (两个数的相同除数的最大值)
    public static void main6(String[] args) {
        Scanner sca = new Scanner(System.in);
        System.out.print("请输入其中一个正整数:");
        int num1 = sca.nextInt();
        System.out.print("请输入其中另一个正整数:");
        int num2 = sca.nextInt();
        int ret = num1 > num2 ? num1 : num2;
        int max = 0;
        for(int i = 1; i < ret; i++) {
            if(num1 % i == 0 && num2 % i == 0) {
                //只要进来就是约束，而且肯定比上次的值大
                //所以每次进来都将i赋值给max
                max = i;
            }
        }
        System.out.println(max);
    }

    //7. 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
    public static void main7(String[] args) {
        double sum = 0;//用来存放和
        int temp = 1;
        //循环遍历1-100的数值
        for(int i = 1; i <= 100; i++) {
            sum += temp * 1.0/i;
            temp = -1 * temp;//每次更新temp，而且是1 和 -1 进行交换
        }
        System.out.println(sum);
    }

    //8. 编写程序数一下 1到 100 的所有整数中出现多少个数字9。
    public static void main8(String[] args) {
        int n = 0;//记录数字9的个数,
        for(int num = 1; num <= 100; num++) {
            if( num % 10 == 9 || num / 9 == 10 || num / 11 == 9) {
                n += 1;
            }
        }
        System.out.println(n);
    }


    //9. 求出0～999之间的所有“水仙花数”并输出。(重点，每次都忘记)
    //(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本身， 
    // 如；153＝1＋5＋3?，则153是一个“水仙花数”。) 
    public static void main(String[] args) {
        //循环遍历0-999
        for(int num = 0; num < 1000; num ++) {
            //找到它是几位数
            int count = 1;//储存位数
            int temp = num;
            while(temp / 10 != 0) {
                count += 1;
                temp /= 10;
            }       
            int a = num % 10;
             int b = (num / 10) % 10;
             int c = (num / 100);
             if (num == Math.pow(a,count) + Math.pow(b, count) + Math.pow(c, count)) {
                 System.out.print(num + " ");
             }     

        }
    }
}