package p2020_01.P20200116;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -01
 * Time: 21:16
 */
public class P20200116 {

    public static void main(String[] args){
        System.out.println(countWays(4));;
    }

    //总结起来有：f(1)=1,f(2)=2,f(3)=4,f(4)=f(1)+f(2)+f(3);f(5)=f(2)+f(3)+f(4)
    //f(n)=f(n-1)+f(n-2)+f(n-3);
    public static int countWays1(int n) {
        // write code here
        // 递归不能通过
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(n == 3) {
            return 4;
        }
//        int fist = 1;
//        int second = 2;
//        int third = 4;
//        //int result = 0;
        return (countWays(n-1) + countWays(n-2) + countWays(n-3))%1000000007;

    }


    public static int countWays(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(n == 3) {
            return 4;
        }

        int fist = 1;
        int second = 2;
        int third = 4;
        int result = 0;
        for (int i = 3; i < n; i++) {
            //模运算有一个特点就是 (a + b) % c  相当于
             //       ((a %c + b%c) % c)
            //另外注意到每次当前状态 i 只与前三个状态有关，因此可以只申请3个空间的数组，每次状态i模3
            //就可以了。
            result += (fist + second + third)%1000000007;
            fist = second;
            second = third;
            third = result;
        }
        return  result;
    }
}
