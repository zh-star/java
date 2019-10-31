package package4;



/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 18:16
 */
public class Test {
    public static void main(String[] args){
        Shape s1 = new Cycle();
        Shape s2 = new Rect();
        Shape s3 = new Flower();
        drawShap(s1);
        drawShap(s2);
        drawShap(s3);

    }
    public static void drawShap(Shape s) {
        s.draw();
    }
}
