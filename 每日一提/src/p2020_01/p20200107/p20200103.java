package p2020_01.p20200107;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -01
 * Time: 20:55
 */
public class p20200103 {
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        String seller = in.nextLine();//卖家
        String buyers = in.nextLine();//买家

        StringBuilder sb = new StringBuilder();

        int noContains = 0;
        int contains = 0;
        for (int i = 0; i < buyers.length(); i++) {
            // 如果不包含想要买的颜色
            if(!seller.contains(String.valueOf(buyers.charAt(i)))) {
               // sb.append(buyers.charAt(i));
                noContains ++;
            } else {
                seller.replace(buyers.charAt(i),'#');
            }
        }
        if(noContains == 0) {
            // 都包含的
            System.out.print("Yes " + (seller.length()-contains));
        } else {
            System.out.print("No " + noContains);
        }

    }

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner sc=new Scanner (System.in);
            String seller=sc.nextLine();
            String buyers=sc.nextLine();
            int c=0;
            int cha=0;
            StringBuffer ab=new StringBuffer(seller);
            StringBuffer arb=new StringBuffer(buyers);
            for(int i=0;i<arb.length();i++) {
                int b=0;
                for(int j=0;j<ab.length();j++) {
                    if(arb.charAt(i)==ab.charAt(j)) {
                        c++;
                        b++;
                        ab.deleteCharAt(j);
                        break;
                    }
                }
                if(b==0) {
                    cha++;
                }

            }

            if(c==arb.length()) {
                System.out.print("Yes"+" "+(seller.length()-arb.length()));
            }else {
                System.out.print("No"+" "+(cha));
            }

        }



    public static void main1(String[] args){

        第二题链表的相加 ma = new 第二题链表的相加();
        ListNode head = null;
        head = ma.addLater(1,head);
        head = ma.addLater(2,head);
        head = ma.addLater(3,head);
        ma.display(head);
        System.out.println();
        ListNode head2 = null;
        head2 = ma.addLater(7,head2);
        head2 = ma.addLater(9,head2);
        head2 = ma.addLater(1,head2);
        ma.display(head2);
        System.out.println();

        ListNode head3 = ma.plusAB2(head,head2);
        ma.display(head3);

    }
}
