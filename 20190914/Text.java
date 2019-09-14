public class Text {
    public static void main(String[] args) {
        //计算 1! + 2! + 3! + 4! + 5!
        int num = 5;
        int sum = 0;//求和的结果
        int temp = 1;
        int i = 1;
        for (i = 1; i <= num; i++) {
            temp = temp * i;//结果是num的阶乘
            sum = sum + temp;
        }
        System.out.println(sum);
    }
}