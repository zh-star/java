package p2020_01.p20200115;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -01
 * Time: 17:38
 */
public class p2020015 {
    public static void main1(String[] args){
        System.out.println(countNumberOf2s(10));
    }
    public static int countNumberOf2s(int n) {
        int count = 0;
        if(n < 2) {
            return 0;
        } else if(n <= 10) {
            return 1;
        } else {
            for (int i = 2; i <= n ; i++) {
                int temp = i;
                while (temp > 0) {
                    if (temp % 10 == 2) {
                        count++;
                    }
                    temp /= 10;
                    if(temp  == 0) {
                        break;
                    }
                }
            }
        }


        return count;
    }


    public static int countNumberOf2s2(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i;
            int b = n % i;
            //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
            //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
            count += (a + 7) / 10 * i + ((a % 10 == 2) ? b + 1 : 0);
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String PA = in.nextLine();
        String[] value =  PA.split(" ");
        String[] Pvalue = value[0].split("\\.");//应付的钱
        String[] Avalue = value[1].split("\\.");//实付的钱
        StringBuilder ret = new StringBuilder();
        System.out.println(Arrays.toString(Pvalue));
        System.out.println(Arrays.toString(Avalue));
        int[] num = new int[] {(int)Math.pow(10.0,7.0),17,29};
        int flag = 0;

        if(Integer.parseInt(Avalue[0]) >= Integer.parseInt(Pvalue[0])) {
            for (int i = Pvalue.length - 1; i >= 0; i--) {
                int tempP = Integer.parseInt(Pvalue[i]);
                int tempA = Integer.parseInt(Avalue[i]) - flag;
                //System.out.println(tempA);
                //System.out.println(tempP);
                if (tempA >= tempP ) {
                    ret.append(tempA - tempP);
                } else {
                    tempA += num[i];//借位
                    ret.append(tempA - tempP);
                    flag = 1;
                }
                if (i != 0) {
                    ret.append(".");
                }
            }

        } else {
            //14.1.28 10.16.27
            for (int i = Pvalue.length - 1; i >= 0; i--) {
                int tempP = Integer.parseInt(Pvalue[i]) - flag; //应付
                int tempA = Integer.parseInt(Avalue[i]); // 实付
                //System.out.println(tempA);
                //System.out.println(tempP);
                if (tempP >= tempA) {
                    ret.append(tempP - tempA);
                } else {
                    tempP += num[i];//借位
                    ret.append(tempP - tempA);
                    flag = 1;
                }
                if (i != 0) {
                    ret.append(".");
                }
            }
            ret.append("-");
        }
        ret.reverse();
        System.out.println(ret);

    }



    public static void main2(String []args){
        Scanner in=new Scanner(System.in);
        String p=in.next();
        String a=in.next();
        int P[]=new int[3];
        int A[]=new int[3];// 实付
        int count=0;
        for(String c:p.split("\\.")){
            P[count++]=Integer.valueOf(c);
        }
        count=0;
        for(String c:a.split("\\.")){
            A[count++]=Integer.valueOf(c);
        }
        int result[]=new int[3];
        if(A[0]>=P[0]) {
            if(A[2]>=P[2])
            {
                result[2]=A[2]-P[2];
            }
            else
            {
                result[2]=A[2]-P[2]+29;
                A[1]-=1;
            }
            if(A[1]>=P[1])
            {
                result[1]=A[1]-P[1];
            }
            else
            {
                result[1]=A[1]-P[1]+17;
                A[0]-=1;
            }

            result[0]=A[0]-P[0];
            System.out.print(result[0]+"."+result[1]+"."+result[2]);
        } else {
            if(P[2]>=A[2])
            {
                result[2]=P[2]-A[2];
            }
            else
            {
                result[2]=P[2]-A[2]+29;
                P[1]-=1;
            }
            if(P[1]>=A[1])
            {
                result[1]=P[1]-A[1];
            }
            else
            {
                result[1]=P[1]-A[1]+17;
                P[0]-=1;
            }

            result[0]=A[0]-P[0];
            System.out.print(result[0]+"."+result[1]+"."+result[2]);
        }
    }
}
