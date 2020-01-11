package p20200104;

import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: 2020 01 04号题 第23天
 * User: STAR
 * Date: 2020 -01
 * Time: 22:08
 */
public class p20190104 {

    // 1.数字分类 (20)
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }
        //System.out.println(list);
        int sum1 = 0;
        int sum2 = 0;
        int flag = 1;
        int count1 = 0;
        int sum3 = 0;
        int count2 = 0;
        int max = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] % 5 == 0 && array[i] % 2 == 0) {
                sum1 += array[i];
            } else if(array[i] % 5 == 1) {
                sum2 += array[i]*flag;
                flag = flag*(-1);
            } else if(array[i] % 5 == 2) {
                count1 ++;
            } else if(array[i] % 5 == 3) {
                sum3 += array[i];
                count2++;
            } else if(array[i] % 5 == 4) {
                if(max < array[i]) {
                    max = array[i];
                }
            }
        }

        if(sum1 != 0) {
            System.out.print(sum1 + " ");
        } else {
            System.out.print("N" + " ");
        }
        if(sum2 != 0) {
            System.out.print(sum2 + " ");
        } else {
            System.out.print("N" + " ");
        }
        if(count1 != 0) {
            System.out.print(count1 + " ");
        } else {
            System.out.print("N" + " ");
        }
        if(sum3 != 0) {
            System.out.print(String.format("%.1f",(float)sum3/count2)+ " ");
        } else {
            System.out.print("N" + " ");
        }
        if(max != 0) {
            System.out.print(max + " ");
        } else {
            System.out.print("N" + " ");
        }
    }

    //2.实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。

    //给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
    public static void main2(String[] args){

    }
}
