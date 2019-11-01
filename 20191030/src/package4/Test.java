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
        //drawShape2();
        drawShape3();
    }

    // 不使用多态的方式
    public static void drawShape2() {
        Cycle cycle = new Cycle();
        Rect rect = new Rect();
        Flower flower = new Flower();

        String[] shapes = {
                "Cycle","Rect","Cycle","Rect","Flow"
        };
        for (String shape : shapes) {
            if(shape.equals("Cycle")) {
                cycle.draw();
            } else if(shape.equals("Rect")) {
                rect.draw();
            } else if (shape.equals("Flow")) {
                flower.draw();
            }
        }
    }

    //使用多态的方式
    public static void drawShape3() {
        Shape[] shapes = {
                new Cycle(),
                new Rect(),
                new Cycle(),
                new Rect(),
                new Flower(),
        };

        for (Shape shape : shapes) {
            shape.draw();
        }
    }
    public static void main1(String[] args){
        Shape s1 = new Cycle();
        Shape s2 = new Rect();
        Shape s3 = new Flower();
        drawShape1(s1);
        drawShape1(s2);
        drawShape1(s3);

    }
    public static void drawShape1(Shape s) {
        s.draw();
    }


}
