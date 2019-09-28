public class Person {
    private String name;
    private String sex;
    private int age;

    //注： 1.一个类必须有一个构造函数，若程序员自己没有创建，系统会默认自己创建，
    //       若创建了，系统不会自己在创建
    //    2.构造函数的函数名必须和类名保持一致，没有返回值
    //    3.构造函数支持重载（函数的参数 类型、个数 不同）
    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void Show(){
        System.out.println("姓名:" + this.name + " 性别:" +
                this.sex + " 年龄:" + this.age);
    }
}
