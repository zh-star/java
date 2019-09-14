public class Text {
    public static void main(String[] args) {
        //计算 1! + 2! + 3! + 4! + 5!
        int num = 5;
        int sum = 0;//求和的结果
        int temp = 1;
        int i = 1;
        int j = 0;
        //方法一：
        // for (i = 1; i <= num; i++) {
        //     temp = temp * i;//结果是num的阶乘
        //     sum = sum + temp;
        // }

        //方法二：
        //阶乘和  将每次求得值相加
        for ( j = 1; j <= num; j++) {
            //分别求每个数的阶乘   1！；2！；3！；4！；5！
            temp = 1;//每次求阶乘前，都要让temp==1
            for (i = 1; i <= j; i++) {
                temp *= i;
            }
            sum = sum + temp;
        }

        System.out.println(sum);
    }
}