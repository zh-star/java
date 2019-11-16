/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 20:12
 */
public class HasStatic{
    private static int x = 100;
    public static void main(String args[ ]){
        HasStatic hs1 = new HasStatic();
        hs1.x++;
        System.out.println(hs1.x);
        HasStatic hs2 = new HasStatic();
        hs2.x++;
        System.out.println(hs1.x);
        hs1=new HasStatic();
        hs1.x++;
        System.out.println(hs1.x);
        HasStatic.x--;
        System.out.println( "x=" +x);
    }
}
