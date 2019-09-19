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
    // public static void main(String[] args) {
    //     int[] arr = new int[] {1,2,3,4,5};
    //     int[] output = transForm(arr);
    //     printArray(arr);
    //     printArray(output);
    // }
    // public static void printArray(int[] a) {
    //     for(int i = 0; i < a.length; i++) {
    //         System.out.println(a[i]);
    //     }
    // }
    // //写一个方法, 将数组中的每个元素都 * 2
    // public static int[] transForm(int[] a) {
    //     //因为数组是引用类型，实参给形参传值时 传的是地址
    //     //若要不修改原有的数组，则要重新创建一个新的数组，并将原数组赋值给它
    //     int[] ret = new int[a.length];
    //     for(int i = 0; i < a.length; i++) {
    //         ret[i] = a [i] * 2;//不改变原有值
    //     }
    //     return ret;
    // }


    //实现一个自己版本的数组转字符串
    // public static void main(String[] args) {
    //     int[] arr = {1,2,3,4,5};
    //     String ret = ToString(arr);
    //     System.out.println(ret);

    // }
    // public static String ToString(int[] a) {
    //     //打印结果应该是[1,2,3,4,5]
    //     String ret = "[";
    //     for(int i = 0; i < a.length; i++) {
    //         ret += a[i];
    //         //每次打印完一个数时在之后加上“，”
    //         if(i != a.length - 1) {
    //             ret += ",";
    //         }
    //     }
    //     ret += "]";
    //     return ret;
    // }



    //数组的拷贝函数
    // public static void main(String[] args) {
    //     int[] arr = {1,2,3,4,5};
    //     int[] ret = CopyOf(arr);
    //     System.out.println(Arrays.toString(ret));
    // }
    // public static int[] CopyOf(int[] a) {
    //     int[] ret = new int[a.length];
    //     for(int i = 0; i <= a.length; i++) {
    //         ret[i] = a[i];
    //     }
    //     return ret;
    // }



    //给定一个整型数组, 找到其中的大元素 (找小元素同理)
    // public static void main(String[] args) {
    //     int[] arr = {1,7,3,22,5};
    //     int ret = max(arr);
    //     System.out.println(ret);

    // }
    // public static int max(int[] a) {
    //     int max = a[0];
    //     int temp = 0;
    //     for(int i = 1; i < a.length; i++) {
    //         if(a[i] > max) {
    //             max = a[i];
    //         }
    //     }
    //     return max;
    // }



    //给定一个整型数组, 求平均值
    // public static void main(String[] args) {
    //     int[] arr = {1,2,3,4,5};
    //     double ret = avg(arr);
    //     System.out.println(ret);
    // }
    // public static double avg(int[] a) {
    //     double sum = 0;
    //     for(int i = 0; i < a.length; i++) {
    //         sum += a[i];
    //     }
    //     return sum/a.length;
    // }


    //给定一个数组, 再给定一个元素, 找出该元素在数组中的位置
    public static void main(String[] args) {
        int[] arr = {1,2,31,42,23,12};
        int ret = find(arr,31);
        System.out.println(ret);
    }
    public static int find(int[] a,int n) {        
        for(int i = 0; i < a.length; i++) {
            if(n == a[i]) {
                return i + 1;
            }
        }
        return -1;
    }
}