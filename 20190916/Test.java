import java.util.Arrays;


public class Test {
    public static void main(String[] args) {
        //5.1实现代码: 求斐波那契数列的第 N 项
        int ret1 = fib1(40);
        int ret = fib(40);
        System.out.println("ret1 = " + ret1);
        System.out.println("ret = " + ret);
        
        
    }
    //递归求法:当所求的位数较大时（100），递归次数增多，程序运行较慢（有重复计算的项）
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    //非递归求法：消除重复计算的项
    public static int fib1(int n) {
        int fast = 1;
        int second = 1;
        int ret = 0;
        // if(n == 1 || n == 2) {
        //     return 1;
        // }        
        for(int i = 3; i <= n; i++) {
            ret = fast + second;
            fast = second;
            second = ret;
        }
        return ret;
    }   


    //5.2实现代码: 求解汉诺塔问题(提示, 使用递归) 
    //假设每次64个黄金圆盘为数字64到1的一个数组
    //放到另一个柱子上，也要按此顺序放置
    
    // public static void main(String[] args) {
    //     hanNuota(2,'A','B','C');
    // }
    // public static void hanNuota(int n, char from, char in, char to) {
    //     if (n == 1) {
    //         System.out.println("把第一个从" + from + "移动到" + to);
    //     }else {
    //         hanNuota(n-1, from, to, in);
    //         System.out.println("把第" + n +"个从" + from + "移动到" + to);
    //         hanNuota(n-1, in, from, to);
    //     }
    // }



    //青蛙跳台阶问题(提示, 使用递归) 
    //f(1) = 1;
    //f(2) = 2 = 2,     11;
    //f(3) = 3 = 12,21, 111;
    //f(4) = 5 = 22, 112,211,121,  1111;
    //f(5) = 8 = 221,212,122, 1112,1121,1211,2111, 11111
    public static void main(String[] args) {
        int ret = jumpFrog(5);
        System.out.println(ret);
    }
    public static int jumpFrog(int n) {
        if (n == 1) {
            return 1;
        }else if (n == 2) {
            return 2;
        }
        return jumpFrog(n - 1) + jumpFrog(n - 2);
    }
} 