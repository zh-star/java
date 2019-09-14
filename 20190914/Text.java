public class Text {
    // public static void main(String[] args) {
    //     //计算 1! + 2! + 3! + 4! + 5!
    //     int num = 5;
    //     int sum = 0;//求和的结果
    //     int temp = 1;
    //     int i = 1;
    //     int j = 0;
    //     //方法一：
    //     // for (i = 1; i <= num; i++) {
    //     //     temp = temp * i;//结果是num的阶乘
    //     //     sum = sum + temp;
    //     // }

    //     //方法二：
    //     //阶乘和  将每次求得值相加
    //     for ( j = 1; j <= num; j++) {
    //         //分别求每个数的阶乘   1！；2！；3！；4！；5！
    //         temp = 1;//每次求阶乘前，都要让temp==1
    //         for (i = 1; i <= j; i++) {
    //             temp *= i;
    //         }
    //         sum = sum + temp;
    //     }




    //利用方法求阶乘
    //     for (j = 1; j <= num; j++) {
    //         sum += factor(j);
    //     }
    //     System.out.println(sum);
    // }
    
    
    // public static int factor (int num) {
    //     int i = 1;
    //     int temp = 1;
    //     for (i = 1; i <= num; i++) {
    //          temp *= i;
    //     }
    //     return temp;
    // }
    
    
    // 利用方法调用求两个数的相加
    // public static void main(String[] args) {
    //     // int a = 2;
    //     // int b = 3;
    //     System.out.println( add (29,50));
    // }
    // public static int add (int x, int y) {
    //     return x + y;
    // }



    //利用方法交换两个变量
    public static void main(String[] args) {
        int[] arr = {2, 3};
        swap(arr);
        System.out.println("arr[0] = " + arr[0] + "  arr[1] = " + arr[1]);
    }
    
    public static void swap (int[] arr ) {
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }
}