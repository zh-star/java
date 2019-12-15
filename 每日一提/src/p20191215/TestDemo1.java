package p20191215;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 每日一题 12-13  等待补充
 * User: STAR
 * Date: 2019 -12
 * Time: 22:31
 */
public class TestDemo1 {
    //2.
    //They are students.
    //aeiou
    //Thy r stdnts.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String sb1 = sc.nextLine();
        String str2= sc.nextLine();
        //System.out.println(sb1);
        //System.out.println(str2);
        for (int i = 0; i < sb1.length(); i++) {
            if (str2.contains(sb1.charAt(i) + "")) {
                //System.out.println("jinlai");
                sb1 = sb1.replaceAll(sb1.charAt(i)+"","");
                //System.out.println(sb1);
            }
        }
        System.out.println(sb1);
    }

    //1.
}
