package p20200110;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -01
 * Time: 22:56
 */
public class p20200110 {

    // 1. 手形数
    // 一个树的平方后几位数如果等与这个数 就叫这个数是手形数
    public static void main1(String[] args) {
        Scanner in = new  Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            int avg = N*N;
            while(N > 0) {
                int temp1 = avg % 10;
                int temp2 = N % 10;
                if( temp1 != temp2) {
                    System.out.println("No!");
                    break;
                }
                avg /= 10;
                N /= 10;
            }
            if(N <= 0) {
                System.out.println("Yes!");
            }
        }
    }
    //021Abc9000
    //021Abc9Abc1
    //021ABC9000
    //021$bc9000
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String password = in.nextLine();
            if(checkLength(password) && checkLength(password) && checkRepeat(password)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }

        }
    }
    public static boolean checkLength(String password) {
        return password.length() > 8;
    }
    public static boolean checkKinds(String password) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        for (int i = 0; i < password.length(); i++) {
            if(password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                count1 = 1;//4
                //break;
            } else if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z'){
                count2 = 1;//1
            } else if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z'){
                count3 = 1;//2
            } else {
                count4 = 1;
            }
        }
        return count1+count2+count3+count4 >= 3;
    }
//    public static boolean checkRepeat(String password) {
//        for (int i = 0; i < password.length()-2; i++) {
//            if(password.charAt(i) == password.charAt(i+2)) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static boolean checkRepeat(String password){
        for(int i = 0; i < password.length()-2; i++){
            //public String substring​(int beginIndex, int endIndex)
            // //得到字符串中下表从beginIndex 到 endIndex 的 字符串
            String substr1 = password.substring(i, i+3);
            //substring(i+1) 从下表 i+1位置一直取到末尾的字符串
            if (password.substring(i+1).contains(substr1)){
                return false;
            }
        }
        return true;

//        for(int i=0;i<password.length()-3;i++){
//            if(password.substring(i+3).contains(password.substring(i,i+3)))
//                return true;
//        }
//        return false;
//        for (int i=0;i<password.length()-6;i++) {
//            for (int j=i+3;j<password.length();j++) {
//                if (password.charAt(i)==password.charAt(j)
//                        && password.charAt(i+1)==password.charAt(j+1)
//                        && password.charAt(i+2)==password.charAt(j+2)) {
//                    return false;
//                } else {
//                    continue;
//                }
//            }
//
//        }
//        return true;
    }


}
