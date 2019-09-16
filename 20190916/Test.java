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


} 