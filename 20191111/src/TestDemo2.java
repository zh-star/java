import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 10:01
 */
class Student {
    private String name;
    private String classes;
    private double score;

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}
public class TestDemo2 {
    public static void main(String[] args){
        List<Student> list = new ArrayList<>();
        list.add(new Student("ZHXX","16040",99.0));
        list.add(new Student("WSY","160404",99.0));
        list.add(new Student("WJ","160405",99.0));
        list.add(new Student("WJA","160406",99.0));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
