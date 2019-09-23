public class Person {
    private String name;
    private String sex;
    private int age;

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
        System.out.println("姓名:" + this.name + " 性别:" + this.sex + " 年龄:" + this.age);
    }
}
