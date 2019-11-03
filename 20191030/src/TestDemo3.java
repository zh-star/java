/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 14:47
 */
interface IFlying {
    void fly();
}

interface IRunning {
    void run();
}

interface ISwimming {
    void swim();
}

class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
}

class Cat extends Animal implements IRunning,ISwimming {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(name + "在跑");
    }

    @Override
    public void swim() {
        System.out.println(name + "游泳");
    }
}

//abstract class D implements IRunning {
//
//}
public class TestDemo3 {
    public static void fun(IRunning iRunning) {
        iRunning.run();
    }
    public static void main(String[] args){
        Cat cat = new Cat("小猫");
        fun(cat);

    }
}

