import java.util.Random;
import java.util.Scanner;

public class Text {
    //3.1. 编写程序数一下 1到 100 的所有整数中出现多少个数字9
    // public static void main(String[] args) {
    //     int i = 1;
    //     int num = 0;
    //     for (i = 1; i <= 100; i ++) {
    //         //9,19,29,39...89;99
    //         if (i % 10 == 9) {
    //             num ++;
    //         //90,91,92..98
    //         }else if (i / 10 == 9) {
    //             num ++;
    //         }
    //     }
    //     System.out.println("num = " + num);
    // }



    //3.2. 求出0～999之间的所有“水仙花数”并输出。
    //“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本身，
    //如；153＝1＋5＋3?，则153是一个“水仙花数”。
    public static void main(String[] args) {
        int i = 0;            
        for (i = 0; i <= 999; i++) {
            int temp = i;
            //double sum = 0; 
             //判断位数:10~99 只判断一次10 三位数只判断一次100
             //10%10==0；100%10==0，但中间会有20%10==0所以就有
             //20/10=2(20>>1)，30/10=3；10/10=1（10>>1），100/10=10(100>>1)
             //所以 就要加一个条件使20，30...不能进循环，让10和100要进循环
            int count = 1;  //存储一个数的位数           
            //int j = 0;
            //while (((temp % 10) == 0) && ((temp / 10) == (Math.pow(10,j)))) {            
            while (temp / 10 != 0){
                count++;
                temp /= 10;
               // j++;           
            }  
           // System.out.println(count);       
            //求余进行判断
            // int a = i % 10;
            // int b = (i / 10) % 10;
            // int c = (i / 100);
            // if (i == Math.pow(a,count) + Math.pow(b, count) + Math.pow(c, count)) {
            //     System.out.print(i + " ");
            // }      
            
            

        }
    }



    //3.3编写代码模拟三次密码输入的场景。 
    //最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 
    //可以重新输入，最多输入三次。三次均错，则提示退出程序 
    // public static void main(String[] args) {
    //     int count = 3;//三次机会
    //     Scanner s = new Scanner(System.in);       
    //     while (count != 0) {
    //         System.out.println("请输入密码：");
    //         String password = s.nextLine();
    //         if (password.equals("123456")== true) {
    //             //java中用equals判断两个字符串是否相等
    //             //例：String a = new String("abc");
    //             //String b = new String("abc");
    //             //a.equals(b),相等返回ture,不相等返回false
    //             System.out.println("登录成功！");
    //             break;
    //         }
    //         count --;
    //         System.out.println("您的输入机会还有" + count +"次" );
    //     }   
    // }



    //3.4 写一个函数返回参数二进制中 1 的个数 
    //比如： 15 0000 1111 4 个 1 
    // public static void main(String[] args) {
    //     int num = 15;
    //     int i = 0;
    //     int count = 0;
    //     for (i = 0; i < 32; i++) {
    //         if ((num & 1) == 1) {
    //             count ++;
    //         }
    //         num >>= 1;
    //     }
    //     System.out.println("count = " + count);
    // }



    //3.5获取一个数二进制序列中所有的偶数位和奇数位，分别输出二进制序列。
    //例：5  0000 0101   偶数位：0011；奇数位：0000
    //与0相与等于  0&0==0；0&1==0；1&1==1
    //要想得到一个数的每一位的值：就是让个数和1相与
    // public static void main(String[] args) {
    //     int num = 5;
    //     int i = 0;
    //     System.out.print("偶数位：");
    //     for (i = 0; i < 32; i+=2) {
    //         System.out.print(((num >> i) & 1 )+ " ");
    //     }
    //     System.out.print("奇数位：");
    //     for (i = 1; i < 32; i+=2) {
    //         System.out.print(((num >> i) & 1 )+ " ");
    //     }
    // }



    //3.6 输出一个整数的每一位. 
    // public static void main(String[] args) {
    //     int num = 15;
    //     int i = 0;
    //     for (i = 31; i >= 0; i--) {
    //         System.out.print(((num >> i) & 1) + " ");
    //     }
    // }



    //3.7. 完成猜数字游戏 
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);//Scanner输入
    //     Random random = new Random();//默认随机种子是系统时间，可在（）内进行自己设置
    //     int toGuss = random.nextInt(100) + 1;
    //     while (true) {
    //         System.out.println("请输入您猜的数（0-100）：");
    //         int num = sc.nextInt();
    //         if (num == toGuss) {
    //             System.out.println("恭喜您，猜对了！");
    //             break;
    //         }else if (num < toGuss) {
    //             System.out.println("您猜小了！");
    //         }else if (num >= toGuss) {
    //             System.out.println("您猜大了！");
    //         }else {
    //             System.out.println("您的输入的数字范围有误！");
    //         }
    //     }
    // }


    
}