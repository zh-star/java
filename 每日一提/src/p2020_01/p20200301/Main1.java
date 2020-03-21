package p2020_01.p20200301;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -03
 * Time: 18:50
 */
public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        List<Character> charList = new ArrayList<>();
        System.out.println(str.replaceFirst("/?", "B"));
        for (int i = 0; i < str.length(); i++) {
            charList.add(str.charAt(i));
        }
        String str1 = ""; // '?'改成‘A’
        String str2 = ""; // '?'改成‘B’

        for (int i = 0; i < charList.size(); i++) {
            if(charList.get(i) == '?') {
                charList.add(i,'A');
            }
        }

//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < charList.size(); i++) {
//            stringBuilder.append(charList.get(i));
//        }
//        stringBuilder.
        str1 = str.replace('?','A');
        str2 = str.replace('?','B');
        int num1 = findChouNum(str1); //str1丑陋值
        int num2 = findChouNum(str2); //str2 丑陋值

        if(num1 < num2) {
            System.out.println(num1);
        } else {
            System.out.println(num2);
        }

    }
    private static int findChouNum(String str) {
        int num = 0;
        for (int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                num ++;
            }
        }
        return num;
    }

    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n堆草
        int A = sc.nextInt(); // 最开始的大小
        int[] value = new int[n];
        for (int i = 0; i < value.length; i++) {
            value[i] = sc.nextInt();
        }
        //System.out.println(Arrays.toString(value));
        for (int i = 0; i < value.length; i++) {
            if(A == value[i]) {
                A = A*2;
            }
        }
        System.out.println(A);
    }
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        //String str = sc.next();
        String str ="ACC";
        int n = 0;
        //System.out.println(str);
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            //删除一个字符
            list.add(str.charAt(i));
        }
        //System.out.println(list);
        Set<List> num = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            char ch = list.get(i);
            list.remove(i);
            //System.out.println(list);
            num.add(list);
            list.add(i,ch);
        }
        //System.out.println(num);
        System.out.println(num.size());

    }
}
