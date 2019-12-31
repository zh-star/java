package P20191229;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 13:15
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class P20191229 {

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] A = new int[n];
            for(int i=0;i<n;i++){
                A[i] = in.nextInt();
            }
            int start = 0;
            ArrayList<int[]> result = new ArrayList<int[]>();

            //Permutation(A,start,n,result);
            Set<String> sortResult = new TreeSet<String>();

            for(int[] out:result){
                if(isLegal(A,out,n)){
                    StringBuilder sb = new StringBuilder();
                    for(int i=0;i<n-1;i++){
                        sb.append(out[i]+" ");
                    }
                    sb.append(out[n-1]);
                    sortResult.add(sb.toString());
//                  System.out.println(sb.toString());
                }
            }
            for(String list:sortResult){
                System.out.println(list);
            }
        }
        in.close();

    }

    private static boolean isLegal(int[] a, int[] out, int n) {
        return false;
    }


    //2. 二叉树的镜像
    // 递归
    public  void Mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        Mirror(root.left);
        Mirror(root.right);
    }
}
