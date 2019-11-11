import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 19:51
 */
public class TestDemo1 {
    public static void main(String[] args){
        Map<String,String> map = new HashMap<>();
        map.put("16040226223","zhxx");
        map.put("16040226224","wsy");
        map.put("16040226225","wj");
        System.out.println(map.get("16040226225"));
        System.out.println(map.containsKey("16040226224"));
        System.out.println(map.containsValue("wj"));
        map.remove("16040226225");
        System.out.println(map.isEmpty());
        System.out.println(map.size());
    }
    public static void main1(String[] args){
        Collection<String> collection = new LinkedList<>();
        collection.add("ab");
        collection.add("c");
        collection.add("de");
        System.out.println(collection);
        //System.out.println(collection.remove("cd"));
        System.out.println(collection);
        //collection.addAll("");
    }
}
