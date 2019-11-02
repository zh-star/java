package package1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 16:45
 */
public class Animal {
    protected String name;

    public Animal(String name) {

        this.name = name;
    }
    public void eat(String food) {
        System.out.println(name + "正在吃" + food);
    }

    public String getName() {
        return name;
    }
}
