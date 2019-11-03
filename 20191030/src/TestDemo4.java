/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 15:25
 */
interface E {

}
interface F {
    void fun1();
}
interface G extends F {
    void fun2();
}
class H implements G {

    @Override
    public void fun1() {

    }

    @Override
    public void fun2() {

    }
}
public class TestDemo4 {
}
