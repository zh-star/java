package package2;

import package1.Animal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 17:20
 */
public class Test {
    public static void main(String[] args){
        //向下转型
        Bird bird= new Bird("圆圆");
        feed(bird);

    }
    public static void feed(Animal animal) {
        animal.eat("谷子");
    }
}
