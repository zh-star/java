import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 19:24
 */
public class Test {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int n = scanner.nextInt();

//      int ret = factorial(n);
//      System.out.println(ret);

//      int ret = sum(n);
//      System.out.println(ret);

//      print(n);


//        int ret = numberSum(n);
//        System.out.println(ret);

//        int ret = fib(n);
//        System.out.println(ret);




    }

    //2. 实现代码: 递归求 N 的阶乘
    public static int factorial(int n) {
        if( n == 1) {
            return 1;
        }
        return n * factorial(n -1);
    }


    //3. 实现代码: 递归求 1 + 2 + 3 + ... + 10
    public static int sum(int n) {
        if(n == 1) {
            return 1;
        }
        return n + sum(n-1);
    }

    //4. 实现代码: 按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4)
    public static void print(int n) {
        //如果条件是 < 10 ，打印结果为 3 2 1，而且代码量更少
        if(n > 10) {
            //System.out.print(n + " ");
            //return;
            print(n / 10);
        }
        System.out.print((n % 10) + " ");
        //print(n / 10);
    }

    //5. 实现代码: 写一个递归方法，输入一个非负整数，返回组成它的数字之和.
    public static int numberSum(int n) {
        if(n < 10) {
            return n;
        }
        return n % 10 + numberSum(n /10);
    }


    //6. 实现代码: 求斐波那契数列的第 N 项
    public static int fib(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        return fib(n-2) + fib(n-1);
    }

    //7. 实现代码: 求解汉诺塔问题(提示, 使用递归)

}
