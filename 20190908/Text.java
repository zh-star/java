import javax.swing.plaf.synth.SynthViewportUI;

public class Text{
    //2.1根据年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上) 
//     public static void main(String[] args) {
//         int age = 43;//当前年龄
//         if (age <= 18) {
//             System.out.println("是少年");
//         }else if (age <= 28) {
//             System.out.println("是青年");
//         }else if (age <=55 ) {
//             System.out.println("是中年");
//         }else {
//             System.out.println("是老年");
//         }
//     }

//     //2.2判定一个数字是否是素数 :是否能被1或自己以外的任何数字整除
//     public static void main(String[] args) {
//             int num = 95;
//             int i=0;
//             for (i = 2; i < num; i++) {
//                 if(num % i == 0) {
//                     System.out.println("不是素数");
//                     break;
//                 }else {
//                     System.out.println("是素数");
//                     break;
//                 }
//             }
//         }


//     //2.3打印 1 - 100 之间所有的素数 
//     public static void main(String[] args) {
//         int i = 1;
//         int j = 2;
//         System.out.println("素数有：");
//         for (i = 1; i <= 100; i++) {
//             for (j = 2; j < i; j++) {
//                 if (i % j == 0) {
//                     break;
//                 }else {
//                     System.out.print(i + " ");
//                     break;
//                 }
//             }
//         }
//     }

//     //2.4 输出 1000 - 2000 之间所有的闰年 
//     public static void main(String[] args) {
//         int year = 1000;
//         for (year = 1000; year <= 2000; year++) {
//             if (year % 100 == 0) {
//                 //判定世纪闰年
//                 if (year % 400 == 0) {
//                     System.out.print(year + " ");
//                 }else {
//                     continue;
//                 }
//             }else {
//                 //判定普通闰年
//                 if (year % 4 == 0) {
//                     System.out.print(year +" ");
//                 }
//             }
            
//             一句程序直接判断
//             if (year % 4 == 0 && year % 100 !=0 || year % 400 ==0) {
//                 System.out.print(year +" ");
//             }
//         }
//    }



//    //2.5输出乘法口诀表 
//    public static void main(String[] args) {
//        int i = 1;
//        int j = 1;
//        for (i = 1; i <= 9; i++) {
//            for (j = 1; j <= i; j++) {
//                System.out.print(j+"*"+i+"="+i*j+" ");
//            }
//            System.out.println();
//        }
//    }

//    //2.6求两个正整数的最大公约数:两个数共有的约束中最大的
//    public static void main(String[] args) {
//        int num1 = 15;
//        int num2 = 50;
//        int ret = num1 < num2 ? num1 : num2;//循环的范围是0~两个数中较小的那个
//        int max_yueshu=0;
//        int i = 1;
//        for (i = 1; i <= ret; i++) {
//            if (num1 % i == 0 && num2 % i == 0) {
//                 max_yueshu = i;
//            }
//        }
//        System.out.println(max_yueshu);
//    }


    // 2.7 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
    public static void main(String[] args) {
        int i = 1;
        int r = 1;
        double sum = 0;//存放求和的结果
        for (i = 1; i <= 100; i++){
            //这里是1不是1.0，则系统认为是int型，计算结果只取整数部分，
            //最后求和结果就为1.0，而实际结果是0.688172179310195
            sum = sum + r * 1.0 / i;
            r *= -1;//1*-1与-1*-1进行交换
        }
        System.out.println(sum);
        
    } 
}