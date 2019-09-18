import java.util.Arrays;

public class Test {
    //public static void main(String[] args) {
        // int[] arr = new int[5];
        // int[] arr1 = new int[] {1,2,3,4,5};
        // //int[] arr = new int[5] {1,2,3,4,5};//不成立
        // int[] arr2 = {1,2,3,4,5};//【】内不能有值
        // System.out.println(Arrays.toString(arr));//[0, 0, 0, 0, 0]
        // System.out.println(Arrays.toString(arr1));//[1, 2, 3, 4, 5]
        // System.out.println(Arrays.toString(arr2));//[1, 2, 3, 4, 5]

        // //获取数组长度
        // //arr.length中的 . 是成员访问操作符
        // System.out.println("length = " + arr.length);//length = 5

        // //访问数组中的元素
        // System.out.println(arr1[0]);//结果为1
        // arr1[0] = 100;
        // System.out.println(arr1[0]); //结果是100

        // //使用 for-each 遍历数组
        // for(int x : arr1) {
        //     System.out.println(x);
        // }     

    //}

    //打印数组内容（使用方法）
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        printArray(arr);
    }
    public static void printArray(int[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    
}