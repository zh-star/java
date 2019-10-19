import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 10:38
 */
public class Test {
    //1.数组中的最大值
    public static int maxArray(int[] arr) {
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    //2.逆置数组
    public static int[] reverse(int[] arrary) {
        int left = 0;
        int right = arrary.length - 1;
        while(left < right) {
            int temp = arrary[left];
            arrary[left] = arrary[right];
            arrary[right] = temp;
            left ++;
            right --;
        }
        return arrary;
    }
    //3.二分查找
    public static int binarySearch1(int[] array,int key) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(key < array[mid]) {
                right = mid - 1;
            }
            if(key > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    //递归版本二分查找
    public static int binarySearch(int[] array, int left, int right, int key) {
        if(left > right) {
            return -1;
        }
        int mid = (left + right)/ 2;
        if(array[mid] == key) {
            return mid;
        } else if(array[mid] > key) {

            return binarySearch(array, left, mid - 1, key);

        } else {
            return binarySearch(array, mid + 1, right,key);
        }
    }

    //4.冒泡排序
    public static void bubbleSort(int[] arrary) {
        boolean flag = false;
        for(int i = 0; i < arrary.length - 1; i++) {
            flag = false;
            for(int j = 0; j < arrary.length - 1 - i; j++) {
                if(arrary[j] > arrary[j+1]) {
                    int temp = arrary[j];
                    arrary[j] = arrary[j+ 1];
                    arrary[j + 1] = temp;
                    flag = true;
                }
            }
            //这一趟没有发生交换，就说明已经有序了
            if(!flag) {
                return;
            }
        }
    }

    //5.给定一个整型数组, 判断是否该数组是有序的(升序)
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }

    //6.求数组的平均数
    public static double average(int[] arrary) {
        double sum = 0;
        for (int i = 0; i < arrary.length - 1; i++) {
            sum += arrary[i];
        }
        return sum / arrary.length;
    }

    //7.数组的顺序查找
    public static int find(int[] arrary,int key) {
        for (int i = 0; i < arrary.length - 1; i++) {
            if(key == arrary[i]) {
                return i;
            }
        }
        return -1;
    }

    //8.数组的打印
    public static void ToString1(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i]);
            if(i != array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public static String ToString2(int[] array) {
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            str += array[i];
            if(i != array.length) {
                str += ",";
            }
        }
        str += "]";
        return str;
    }

    //9.数组的拷贝
    public static int[] CopyOf(int[] array,int length) {
        int[] newArrary = new int[length];
        for (int i = 0; i < length; i++) {
            newArrary[i] = array[i];
        }
        return newArrary;
    }


    //10.数组的数字排列，偶数放前，奇数放后
    public static int[] transform(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && array[left] % 2 == 0) {
                left++;
            }
            while (left < right && array[right] % 2 != 0) {
                right--;
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        return array;
    }
    public static void main(String[] args){
        int[] array = {1,2,3,4,5};
//        int ret = maxArray(arr);
//        System.out.println("最大值是：" + ret);

//        int[] ret = func1(array);
//        System.out.println(Arrays.toString(ret));

//        int ret = binarySearch(array,0,array.length -1,2);
//        System.out.println(ret);


//        bubbleSort(array);
//        System.out.println(ToString1(array));
        System.out.println(ToString2(array));

//        System.out.println(isSorted(array));

//        System.out.println(average(array));

        //System.out.println(find(array,6));

//        ToString(array);

//        System.out.println(Arrays.toString(CopyOf(array,3)));


//        System.out.println(Arrays.toString(reverse(array)));

        System.out.println(Arrays.toString(transform(array)));

        Arrays.copyOf();
    }
}
