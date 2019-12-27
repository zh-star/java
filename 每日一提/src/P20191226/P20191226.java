package P20191226;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 20:40
 */
public class P20191226 {
    //1.不用算术计算 计算两个数的和
    public static void main(String[] args){
        System.out.println(addAB(3, 5));
    }
    public static int addAB(int A, int B) {
        // write code here
        if(A == 0) {
            return B;
        } else if(B == 0) {
            return A;
        } else {
            return addAB(A ^ B, (A & B) << 1);
        }
    }
}
