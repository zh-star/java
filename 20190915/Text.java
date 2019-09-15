public class Text {
    //4.2 实现代码: 递归求 N 的阶乘  
    // public static void main(String[] args) {
    //     int ret = factor(5);//递归
    //     int ret1 = factor1(5);//非递归
    //     System.out.println("ret = " + ret);
    //     System.out.println("ret1 = " + ret1);
    // }
    // //递归求阶乘
    // public static int factor(int num) {
    //     if (num == 1) {
    //         return 1;
    //     }
    //     return num * factor(num - 1);
    // }



    // //非递归求阶乘
    // public static int factor1(int num) {
    //     int temp = 1;
    //     for(int i = 1; i <= num; i++) {
    //          temp *= i;
    //     }
    //     return temp;
    // }



    //4.3. 实现代码: 递归求 1 + 2 + 3 + ... + 10
    public static void main(String[] args) {
        int ret = sum(10);
        System.out.println(ret);
    }
    public static int sum(int num) {
        if (num == 1) {
            return 1;
        }
        return num + sum(num - 1);
    }
    
}