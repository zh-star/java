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
        Animal animal = new Cat("小猫");
        if(animal instanceof Cat) {
            Bird bird = (Bird)animal;
            bird.fly();
        }
    }
    public static void main1(String[] args){
        //向上转型
//        Animal animal = new Bird("圆圆");
//        animal.eat("小米");
        //向下转型
//        Bird bird= new Bird("圆圆");
//        feed(bird);

//        Bird bird1 = new Bird("圆圆");
//        feed(bird1);
        Animal animal = findMyAnimal();


    }
    public static void feed(Animal animal) {

        animal.eat("谷子");
    }
    public static Animal findMyAnimal() {
        Bird bird = new Bird("圆圆");
        return bird;
    }
}
