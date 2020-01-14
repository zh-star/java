package p20200111;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -01
 * Time: 18:30
 */
public class p20200111 {
    //5 15             5 5 10 2 3

    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int sum = sc.nextInt();
            int[] num = new int[n];
            for(int i=0;i<n;i++){
                num[i] = sc.nextInt();
            }
            long[] count = new long[sum+1];
            count[0] = 1;
            for(int i=0;i<n;i++){
                if(num[i]<=sum){
                    for(int j=sum;j>=0;j--){
                        if(count[j]>0 && j+num[i]<=sum){
                            count[j+num[i]] += count[j];
                        }
                    }
                }
            }
            System.out.println(count[sum]);
        }

    }
//10.0.3.193      1010 0000 0011 0000 0011 1100 0001‬      167969729
//167969729
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String ip = in.nextLine();
            String decIP = in.nextLine();
            //String s = Integer.toBinaryString(0);
            //System.out.println(s);
            //1010
            System.out.println(ipTurnDec(ip));
            System.out.println(DecTurnip(decIP));
        }
    }
    public static long ipTurnDec(String ip) {
        String[] str = ip.split("\\.");
        StringBuffer decIP = new StringBuffer();
        String s = "";
        for(int i = 0; i < str.length; i++) {
            String temp = Integer.toBinaryString(Integer.parseInt(str[i]));
            while(temp.length()!=8 && i!=0){
                temp = "0"+temp;
            }
            decIP.append(temp);
        }

        return Long.parseLong(decIP.toString(),2);
    }

    public static String DecTurnip(String ns){
        long num = Long.parseLong(ns);
        String ip = Long.toBinaryString(num);
        StringBuffer sb = new StringBuffer();
        while(ip.length()%8!=0){
            ip = "0"+ip;
        }
        for(int i=0;i < ip.length();i+=8){
            String temp = ip.substring(i,i+8);
            sb.append(Long.parseLong(temp,2)+".");
        }
        return sb.toString().substring(0,sb.toString().length()-1);
    }


}
