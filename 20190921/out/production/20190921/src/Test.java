public class Test {
    public static void main(String[] args) {
        System.out.println("hehe");
        Person person = new Person();
        System.out.println(person.name);
        person.name = "xiaohau";
        System.out.println(person.name);
        person.eat();
        person.sleep();
    }
}
